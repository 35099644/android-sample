package com.qxw.music;


import java.io.IOException;


import java.io.OutputStream;
import java.util.Timer;
import java.util.TimerTask;

import android.app.ActivityGroup;
import android.app.AlertDialog;
import android.app.LocalActivityManager;
import android.content.DialogInterface;
import android.content.Intent;
//import android.graphics.Shader;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

@SuppressWarnings("deprecation")
public class Main extends ActivityGroup implements OnGestureListener,OnTouchListener {
	//声明ViewFlipper对象
	private ViewFlipper m_ViewFlipper;
	//声明GestureDetector对象
	private GestureDetector m_GestureDetector;
	//声明LocalActivityManager对象
	private LocalActivityManager m_ActivityManager;
	private static int FLING_MIN_DISTANCE = 100;
	private static int FLING_MIN_VELOCITY = 200;
	//定义自定义图片加文字按钮ImageButton对象
	//private ImageButton mButton1;
	
	//单选按键部分1
	private String[] areas = new String[]{"一般模式", "会议模式", "视频模式","迎接模式", "返回"};  
	private RadioOnClick radioOnClick = new RadioOnClick(4);  
	@SuppressWarnings("unused")
	private ListView RadioListView;  
    private ImageButton imagebtn,imagebutton; 
    OutputStream tmpOut = null;
    Timer timer=new Timer();  	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置内容试图
        setContentView(R.layout.main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        imagebutton=(ImageButton)findViewById(R.id.imageButton1);
        imagebutton.setOnClickListener(new ImageButton.OnClickListener()
        {
        	@Override
            public void onClick(View v)
        	{
        		/*Intent intent=new Intent();
        		intent.setClass(Main.this, stand.class);
        		startActivity(intent);
        		Main.this.finish();
        		overridePendingTransition(R.anim.zoomin,R.anim.zoomout);*/
        		LayoutInflater inflater = getLayoutInflater();
		    	  View layout = inflater.inflate(R.layout.lightstandard,
		    	  (ViewGroup) findViewById(R.id.stand));

		    	   new AlertDialog.Builder(Main.this)
		    	   .setTitle("Ihe nationl atandard of illumination")
		    	   .setView(layout)
		    	   .setPositiveButton("Return", null)
		    	   //.setNegativeButton("取消", null)
		    	   .show();	   
        	}
        }
        		);
        
        //单选按键部分2
        imagebtn=(ImageButton)findViewById(R.id.imageButton2);  
        imagebtn.setOnClickListener(new RadioClickListener());   
        
        
        //构建ViewFlipper对象
    	m_ViewFlipper = (ViewFlipper) findViewById(R.id.fliper);
    	//获取Activity消息
    	m_ActivityManager = getLocalActivityManager();
    	//注册一个用于手势识别的类
    	m_GestureDetector = new GestureDetector(this);
    	//添加视图，指定每个视图对应的Activity
		m_ViewFlipper.addView((m_ActivityManager.startActivity("", new Intent(Main.this,Firstpage.class)).getDecorView()),0);
    	m_ViewFlipper.addView((m_ActivityManager.startActivity("", new Intent(Main.this,Secondpage.class)).getDecorView()),1);
    	//给ViewFlipper设置一个listener
    	m_ViewFlipper.setOnTouchListener(this);
    	//默认为正在播放页面并设置图标
    	//设置相应元素索引显示的子视图
		m_ViewFlipper.setDisplayedChild(0);
    	//允许长按住ViewFlipper,这样才能识别拖动等手势
    	m_ViewFlipper.setLongClickable(true);
    	//监听
    	
    	
	    /** Called when the activity is first created. */
	    
        /*取得 Button对象*/
    	//返回按钮按键事件
      /* btnbac = (ImageButton) findViewById(R.id.btnback);
       btnbac.setOnClickListener(new ImageButton.OnClickListener(){
        @Override
        public void onClick(View v)
        {
           // TODO Auto-generated method stub  
        	Intent intent=new Intent();
    		intent.setClass(Main.this, home.class);
    		startActivity(intent);
    		Main.this.finish();
    		overridePendingTransition(R.anim.zoomin,R.anim.zoomout);
        	/*Intent intent = new Intent();   
        	intent.setClass(Main.this, home.class);   
        	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  //注意本行的FLAG设置   
        	startActivity(intent);   
        	
        	
        } });*/}
    
    @Override

	public boolean onKeyDown(int keyCode, KeyEvent event) {

		

		//按下键盘上返回按钮

		if(keyCode == KeyEvent.KEYCODE_BACK){

 

			new AlertDialog.Builder(this)

				//.setIcon(R.drawable.services)

		    .setTitle(R.string.app_about)
	          /*设置弹出窗口的图式*/
	         // .setIcon(R.drawable.hot)
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

			

			
			//setResult(11,this.getIntent());
			return true;

		}else{		

			return super.onKeyDown(keyCode, event);

		}

	}


	@Override

	protected void onDestroy() {

		super.onDestroy();

		
		android.os.Process.killProcess(android.os.Process.myPid()); 
		System.exit(0);
		overridePendingTransition(R.anim.zoomin,R.anim.zoomout);
		//或者下面这种方式

		

	}
        
  
    
    
    
    
    //按下home键后直接退出蓝牙界面返回到home界面
    

   /* public boolean onKeyUp(int keyCode,KeyEvent event){
		if(keyCode==KeyEvent.KEYCODE_BACK){
           setResult(11,this.getIntent());
		this.finish();
		return false;
	}}





    /** Called when the activity is first created. */

    /**
     * 定义从右侧进入的动画效果
     * @return
     */
    public Animation inFromRightAnimation()
    {
    	Animation inFromRight = new TranslateAnimation(
    			Animation.RELATIVE_TO_PARENT, +1.0f,
    			Animation.RELATIVE_TO_PARENT, 0.0f, 
    			Animation.RELATIVE_TO_PARENT, 0.0f, 
    			Animation.RELATIVE_TO_PARENT, 0.0f);
    	inFromRight.setDuration(500);
    	inFromRight.setInterpolator(new AccelerateInterpolator());
    	return inFromRight;
    }
    /**
     * 定义从左侧退出的动画效果
     * @return
     */
    public Animation outToLeftAnimation()
    {
    	Animation outtoLeft = new TranslateAnimation(
    			Animation.RELATIVE_TO_PARENT, 0.0f,
    			Animation.RELATIVE_TO_PARENT, -1.0f, 
    			Animation.RELATIVE_TO_PARENT, 0.0f, 
    			Animation.RELATIVE_TO_PARENT, 0.0f);
    	outtoLeft.setDuration(500);
    	outtoLeft.setInterpolator(new AccelerateInterpolator());
    	return outtoLeft;
    }
    /**
     * 定义从左侧进入的动画效果
     * @return
     */
    public Animation inFromLeftAnimation()
    {
    	Animation inFromLeft = new TranslateAnimation(
    			Animation.RELATIVE_TO_PARENT, -1.0f,
    			Animation.RELATIVE_TO_PARENT, 0.0f, 
    			Animation.RELATIVE_TO_PARENT, 0.0f, 
    			Animation.RELATIVE_TO_PARENT, 0.0f);
    	inFromLeft.setDuration(500);
    	inFromLeft.setInterpolator(new AccelerateInterpolator());
    	return inFromLeft;
    }
    /**
     * 定义从右侧退出时的动画效果
     * @return
     */
    public Animation outToRightAnimation()
    {
    	Animation outtoRight = new TranslateAnimation(
    			Animation.RELATIVE_TO_PARENT, 0.0f,
    			Animation.RELATIVE_TO_PARENT, +1.0f, 
    			Animation.RELATIVE_TO_PARENT, 0.0f, 
    			Animation.RELATIVE_TO_PARENT, 0.0f);
    	outtoRight.setDuration(500);
    	outtoRight.setInterpolator(new AccelerateInterpolator());
    	return outtoRight;
    }
    
	@Override
	public boolean onDown(MotionEvent e) {
		return false;
	}	
	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		//当像左侧滑动的时候 
    	if(e1.getX()-e2.getX()>FLING_MIN_DISTANCE && Math.abs(velocityX)>FLING_MIN_VELOCITY)
    	{
			//设置View进入屏幕时候使用的动画
    		m_ViewFlipper.setInAnimation(inFromRightAnimation());
    		//设置View退出屏幕时候使用的动画 
    		m_ViewFlipper.setOutAnimation(outToLeftAnimation());
    		//下一个页面
    		m_ViewFlipper.showNext();
    		//获取相应元素索引显示的子视图
    	}
    	//当像右侧滑动的时候 
		else if(e2.getX()-e1.getX()>FLING_MIN_DISTANCE && Math.abs(velocityX)>FLING_MIN_VELOCITY)
		{
			//设置View进入屏幕时候使用的动画
			m_ViewFlipper.setInAnimation(inFromLeftAnimation());
			//设置View退出屏幕时候使用的动画 
			m_ViewFlipper.setOutAnimation(outToRightAnimation());
			//上一个页面
			m_ViewFlipper.showPrevious();
			//获取相应元素索引显示的子视图
		}
		return false;
	}	
	@Override
	public void onLongPress(MotionEvent e) {
		
	}	
	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		
		return false;
	}	
	@Override
	public void onShowPress(MotionEvent e) {
		
	}	
	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		return false;
	}
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		//一定要将触屏事件交给手势识别类去处理(自己处理会很麻烦的)
		return m_GestureDetector.onTouchEvent(event);
	}
	
	
	
    //单选按键部分3
    class RadioClickListener implements OnClickListener {  
	  @Override  
	  public void onClick(View v) {  
	   AlertDialog ad =new AlertDialog.Builder(Main.this).setTitle("选择模式")  
	   .setSingleChoiceItems(areas,radioOnClick.getIndex(),radioOnClick).create();  
	   RadioListView=ad.getListView();  
	   ad.show();  
    }  
    }  
    
    /** 
     * 点击单选框事件 
     */  
    class RadioOnClick implements DialogInterface.OnClickListener{  
  private int index;  
  
  public RadioOnClick(int index){  
   this.index = index;  
  }  
  public void setIndex(int index){  
   this.index=index;  
  }  
  public int getIndex(){  
   return index;  
  }  
  
  public void onClick(DialogInterface dialog, int whichButton){  
    setIndex(whichButton);  
   // Toast.makeText(Main.this, "您选择了： " + areas[index], Toast.LENGTH_LONG).show();  
    switch (index)
    {
   //一般模式下；
      case  0: 
    	  
      { 
    	//第一个子节点的亮度；
    	send(0x01,0x5a);    	 
      
      //第二个子节点的亮度；
      	send(0x02,0x5a);
     
      //第三个子节点的亮度；
      	send(0x03,0x5a);
      	
     //第四个子节点的亮度；
      	send(0x04,0x5a);
    	Toast.makeText(Main.this, "您选择了： " + areas[index], Toast.LENGTH_LONG).show();  
    	 dialog.dismiss(); 
    }   
    break;
    
    
   // 会议模式下；
      case  1: 
      { 
    	  //第一路子节点；
    	  send(0x01,0x23);
   	  
    	  //第二路子节点；
    	  send(0x02,0x23);
    	  
    	 //第三路子节点； 
    	  send(0x03,0x23);
    	  
    	  //第四路子节点；
    	  send(0x04,0x23);
    	  Toast.makeText(Main.this, "您选择了： " + areas[index], Toast.LENGTH_LONG).show();  
    	  dialog.dismiss(); 
    }   break;
    
    
    //视频模式下；
      case  2: 
      { 
    	  //第一路子节点；
    	  send(0x01,0xc8);
    	
    	  //第二路子节点；
    	  send(0x02,0xc8);
    	  
    	 //第三路子节点； 
    	  send(0x03,0xc8);
    	  
    	  //第四路子节点；
    	  send(0x04,0xc8);
    	  
    	  Toast.makeText(Main.this, "您选择了： " + areas[index], Toast.LENGTH_LONG).show();  
    	  dialog.dismiss();  
    }   break;
    
    
    //迎接模式下
      case  3: 
      { 
    	  //第一路子节点；
    	  send(0x01,0x23);
    
    	  //第二路子节点；
    	  TimerTask timerTask = new TimerTask() {              
              @Override
              public void run() 
              {
                      // 你要干的活
            	  send(0x02,0x23);
             }
      };
      timer.schedule(timerTask, 1000 * 3);
       //第三路子节点：
	  TimerTask timerTask1 = new TimerTask() {              
          @Override
          public void run() {
        	  
                  // 你要干的活
        	  send(0x03,0x23);
        	  
          }
      };
        	 timer.schedule(timerTask1, 1000 * 6); //2秒后执行
    	  
    	  //第四路子节点；
       TimerTask timerTask2 = new TimerTask() {              
            @Override
            public void run() {
                         // 你要干的活
            	send(0x04,0x23);
    	 	
            }};	            
            timer.schedule(timerTask2, 1000 * 9);
    	  Toast.makeText(Main.this, "您选择了： " + areas[index], Toast.LENGTH_LONG).show();  
    	   dialog.dismiss();  
    }   break;
    
    //返回
      case 4:
    	  
      {//Toast.makeText(Main.this, "您选择了： " + areas[index], Toast.LENGTH_LONG).show();  
	   dialog.dismiss();  }
 }  
 
      
}
  
  private void  send(int Room,int Grade){
		
		try {
          
	           //String strpass="@@UP....";
			 byte[] byteone=new byte[8];//=strpass.getBytes("US-ASCII");
			     byteone[0]=(byte)0xf5;
			     byteone[1]=(byte)0x5f;
			     byteone[2]=(byte)0x00;
			     byteone[3]=(byte)Room;
			     byteone[4]=(byte)0x03;
			     byteone[5]=(byte)0x00;
			     byteone[6]=(byte)Grade;
			     byteone[7]=(byte)0x06;
			     
			   //byte[] bytekai=strpass.getBytes("US-ASCII");
           tmpOut = BluetoothMain.btSocket.getOutputStream();
           tmpOut.write(byteone);}
        catch (IOException e) {
           Log.e("BluetoothReadService", "temp sockets not created", e);
       }

		}
  }}
    