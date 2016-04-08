package com.qxw.music;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class company extends Activity {
	private ImageButton back;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.company);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
       
        back=(ImageButton) findViewById (R.id.back);
       
        back.setOnClickListener(new Button.OnClickListener()
        {

			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
        		intent.setClass(company.this, home.class);
        		startActivity(intent);
        		company.this.finish();
        		overridePendingTransition(R.anim.zoomin,R.anim.zoomout);
        	
			}
        	
        }
        
        );
    
    
    }}
