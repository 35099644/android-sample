package com.qxw.music;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class home extends Activity {
	private ImageButton enterr,enterp,enterc,back;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        enterr=(ImageButton) findViewById (R.id.Enterr);
        enterp=(ImageButton) findViewById (R.id.Enterp);
        enterc=(ImageButton) findViewById (R.id.Enterc);
        back=(ImageButton) findViewById (R.id.back);
        enterr.setOnClickListener(new Button.OnClickListener()
        {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();   
	        	intent.setClass(home.this, BluetoothMain.class);   
	        	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  //注意本行的FLAG设置   
	        	startActivity(intent); 
	        	 //home.this.finish();
	        	overridePendingTransition(R.anim.zoomin,R.anim.zoomout);
				
				
			}
        	
        }
        
        		);
        
        
        enterp.setOnClickListener(new Button.OnClickListener()
        
        {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
        		intent.setClass(home.this, product.class);
        		startActivity(intent);
        		home.this.finish();
        		overridePendingTransition(R.anim.zoomin,R.anim.zoomout);
        	
        }}
        		);
        
        enterc.setOnClickListener(new Button.OnClickListener()
        
        {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
        		intent.setClass(home.this, company.class);
        		startActivity(intent);
        		home.this.finish();
        		overridePendingTransition(R.anim.zoomin,R.anim.zoomout);
        	
        }}
        		);
        
       back.setOnClickListener(new Button.OnClickListener()
        {

			@Override
			public void onClick(View v) {
			     
				 AlertDialog.Builder alertbBuilder=new AlertDialog.Builder(home.this); 


					//.setIcon(R.drawable.services)

					 alertbBuilder.setTitle(R.string.app_about)
		          /*设置弹出窗口的图式*/
		          //.setIcon(R.drawable.hot)
		          /*设置弹出窗口的信息*/
		          .setMessage(R.string.app_about_msg)
		          .setPositiveButton(R.string.str_ok,
		          new DialogInterface.OnClickListener()
		        {
		         public void onClick(DialogInterface dialoginterface, int i)
		         {           
		          finish();/*关闭窗口*/
		         }
		         }
		        )
		          /*设置弹出窗口的返回事件*/
		          .setNegativeButton(R.string.str_no,
		           new DialogInterface.OnClickListener()
		          {
		         public void onClick(DialogInterface dialoginterface, int i)   
		        {
		        }
		          })
		        .show();
				
					 
			}

    });}
    
  


}