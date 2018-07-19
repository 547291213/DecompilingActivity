package com.example.xkfeng.decompilingactivity;

import android.app.Dialog;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.LevelListDrawable;
import android.graphics.drawable.RotateDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ImageView iv_testIv ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_testIv = (ImageView) findViewById(R.id.iv_testIv);
        //获取图片所显示的ClipDrawble对象
        //final ClipDrawable drawable = (ClipDrawable) iv_testIv.getDrawable();
        //获取图片的ScaleDrawable
        //final ScaleDrawable drawable = (ScaleDrawable) iv_testIv.getDrawable() ;
        //获取图片的RotateDrawable
        //final RotateDrawable drawable = (RotateDrawable) iv_testIv.getDrawable() ;
        //获取图片的AnimationDrawable
        //final AnimationDrawable drawable = (AnimationDrawable) iv_testIv.getDrawable() ;
        //获取图片的LevelListDrawable
        //final LevelListDrawable drawable =  (LevelListDrawable) iv_testIv.getDrawable() ;
        final TransitionDrawable drawable = (TransitionDrawable) iv_testIv.getDrawable() ;
        final Handler handler = new Handler() {
            public void handleMessage(Message msg) {
                if (msg.what == 0x1233) {
                    //修改Drawable的level值
                    if (drawable != null)
                    {
                 //       drawable.start();
                        drawable.setLevel(drawable.getLevel() + 200);
                        drawable.startTransition(2000);
                    }
                }
            }
        };
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                Message msg = new Message();
                msg.what = 0x1233;
                //发送消息,通知应用修改ClipDrawable对象的level值
                handler.sendMessage(msg);
                //取消定时器
                if (drawable!=null)
                if (drawable.getLevel() >= 10000) {
                    drawable.setLevel(0) ;
                    //timer.cancel();
                }
            }
        }, 0, 30);

    }
}
