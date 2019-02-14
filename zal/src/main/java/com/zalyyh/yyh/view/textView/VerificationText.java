package com.zalyyh.yyh.view.textView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

@SuppressLint("AppCompatCustomView")
public class VerificationText extends TextView {
    private int process = 0;
    private Timer time;
    private int times = 60;
    private String volue;
    private String startVolue="%d后重新获取";
    private int textColor;
    private int startColor;
    private int date = 60;
    private VerificationText text;


    public VerificationText(Context context) {
        this(context, null);
    }

    public VerificationText(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, android.R.attr.textStyle);
    }

    public VerificationText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        text = this;
        volue = getText().toString().trim();
        textColor = getCurrentTextColor();
        startColor = getCurrentTextColor();
    }

    public void start(){
        if (process == 0 && date == times) {
            process = 1;
            time = new Timer();
            time.purge();
            time.schedule(new TimerTask() {
                @Override
                public void run() {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {
                                    if (date == 0) {
                                        text.setText(volue);
                                        time.cancel();
                                        time = null;
                                        date = times;
                                        process = 0;
                                        text.setTextColor(textColor);
                                    } else {
                                        text.setTextColor(startColor);
                                        date--;
                                        text.setText(String.format(startVolue, date));
                                        Log.e("zalyyh",String.format(startVolue, date));
                                    }
                                }
                            });

                        }
                    }).start();
                }
            }, 0, 1000);
        }
    }

    public void setTimes(int times) {
        this.times = times;
        this.date = times;
    }


    public void setStartColor(int startColor) {
        this.startColor = startColor;
    }


    public void setStartVolue(String startVolue) {
        this.startVolue = startVolue;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(time !=null){
            time.cancel();
            time = null;
        }
    }
}
