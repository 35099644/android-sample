package com.qxw.music;

import java.util.Timer;

import java.util.TimerTask;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class Zeropage extends Activity {
	private Animation myAnimation_Scale;
	private ImageButton imagebutton;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.zero);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        imagebutton=(ImageButton) findViewById(R.id.imageButton1);
        myAnimation_Scale= AnimationUtils.loadAnimation(this,R.anim.my_scale_action);
        imagebutton.startAnimation(myAnimation_Scale);
        
        final Intent localIntent=new Intent(this,home.class);
        Timer timer=new Timer();
  
        TimerTask timerTask = new TimerTask() {
                
                @Override
                public void run() {
                        // 你要干的活
                	
                	  startActivity(localIntent);
                	  Zeropage.this.finish(); 
                	  overridePendingTransition(R.anim.zoomin,R.anim.zoomout);
                }
        };
        timer.schedule(timerTask, 1000 * 2); //2秒后执行
       


    }
}