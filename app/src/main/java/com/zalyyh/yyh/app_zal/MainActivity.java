package com.zalyyh.yyh.app_zal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.zalyyh.yyh.view.textView.VerificationText;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] data;
    private VerificationText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
        text.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Log.e("text","我是上层点击事件");
                                    }
                                }
        );
    }
    int i = 0;
    private void cesh() {

//        RemoteViews views = Notice.CustomView(this,R.layout.noti_update);
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
//        builder.setContentTitle(getString(R.string.app_name))
//                .setContentText("正在下载")
//                .setSmallIcon(R.mipmap.dalogo);
//        builder.setContent(views);
//        views.setProgressBar(R.id.progressBar,100,i,false);
//        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
//        manager.notify(100, builder.build());
//
//
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                i++;
//                builder.setProgress(100, i, false);
//                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//                manager.notify(0x45ab, builder.build());
//            }
//        }, 1000,3000);

    }


}
