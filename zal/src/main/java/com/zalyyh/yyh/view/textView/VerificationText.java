package com.zalyyh.yyh.view.textView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
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
    private String startVolue="%后重新获取";
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
        time = new Timer();
        volue = getText().toString().trim();
        textColor = getCurrentTextColor();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_DOWN:
                if (process == 0 && date == times) {
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
                                                date = times;
                                                text.setTextColor(textColor);
                                            } else {

                                                text.setTextColor(startColor);
                                                text.setText(String.format(startVolue, ""+ date--));
                                            }
                                        }
                                    });

                                }
                            }).start();
                        }
                    }, 0, 1000);
                } else {
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
                //点击抬起后，回复初始位置。
                if (process != 0) {
                    process = 0;
                }
                break;
        }
        //这句话不要修改
        return super.onTouchEvent(event);
    }

    /**
     * 设置循环次数
     * @param times
     */
    public void setTimes(int times) {
        this.times = times;
        this.date = times;
    }

    /**
     * 设置循环状态下显示的文字颜色
     *
     * @param startColor
     */
    public void setStartColor(int startColor) {
        this.startColor = startColor;
    }

    /**
     * 设置循环状态下显示的文字
     *
     * @param startVolue
     */
    public void setStartVolue(String startVolue) {
        this.startVolue = startVolue;
    }



}
