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
	//����ViewFlipper����
	private ViewFlipper m_ViewFlipper;
	//����GestureDetector����
	private GestureDetector m_GestureDetector;
	//����LocalActivityManager����
	private LocalActivityManager m_ActivityManager;
	private static int FLING_MIN_DISTANCE = 100;
	private static int FLING_MIN_VELOCITY = 200;
	//�����Զ���ͼƬ�����ְ�ťImageButton����
	//private ImageButton mButton1;
	
	//��ѡ��������1
	private String[] areas = new String[]{"һ��ģʽ", "����ģʽ", "��Ƶģʽ","ӭ��ģʽ", "����"};  
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
        //����������ͼ
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
		    	   //.setNegativeButton("ȡ��", null)
		    	   .show();	   
        	}
        }
        		);
        
        //��ѡ��������2
        imagebtn=(ImageButton)findViewById(R.id.imageButton2);  
        imagebtn.setOnClickListener(new RadioClickListener());   
        
        
        //����ViewFlipper����
    	m_ViewFlipper = (ViewFlipper) findViewById(R.id.fliper);
    	//��ȡActivity��Ϣ
    	m_ActivityManager = getLocalActivityManager();
    	//ע��һ����������ʶ�����
    	m_GestureDetector = new GestureDetector(this);
    	//�����ͼ��ָ��ÿ����ͼ��Ӧ��Activity
		m_ViewFlipper.addView((m_ActivityManager.startActivity("", new Intent(Main.this,Firstpage.class)).getDecorView()),0);
    	m_ViewFlipper.addView((m_ActivityManager.startActivity("", new Intent(Main.this,Secondpage.class)).getDecorView()),1);
    	//��ViewFlipper����һ��listener
    	m_ViewFlipper.setOnTouchListener(this);
    	//Ĭ��Ϊ���ڲ���ҳ�沢����ͼ��
    	//������ӦԪ��������ʾ������ͼ
		m_ViewFlipper.setDisplayedChild(0);
    	//������סViewFlipper,��������ʶ���϶�������
    	m_ViewFlipper.setLongClickable(true);
    	//����
    	
    	
	    /** Called when the activity is first created. */
	    
        /*ȡ�� Button����*/
    	//���ذ�ť�����¼�
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
        	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  //ע�Ȿ�е�FLAG����   
        	startActivity(intent);   
        	
        	
        } });*/}
    
    @Override

	public boolean onKeyDown(int keyCode, KeyEvent event) {

		

		//���¼����Ϸ��ذ�ť

		if(keyCode == KeyEvent.KEYCODE_BACK){

 

			new AlertDialog.Builder(this)

				//.setIcon(R.drawable.services)

		    .setTitle(R.string.app_about)
	          /*���õ������ڵ�ͼʽ*/
	         // .setIcon(R.drawable.hot)
	          /*���õ������ڵ���Ϣ*/
	          .setMessage(R.string.app_about_msg)
	          .setPositiveButton(R.string.str_ok,
	          new DialogInterface.OnClickListener()
	        {
	         public void onClick(DialogInterface dialoginterface, int i)
	         {           
	          finish();/*�رմ���*/
	         }
	         }
	        )
	          /*���õ������ڵķ����¼�*/
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
		//�����������ַ�ʽ

		

	}
        
  
    
    
    
    
    //����home����ֱ���˳��������淵�ص�home����
    

   /* public boolean onKeyUp(int keyCode,KeyEvent event){
		if(keyCode==KeyEvent.KEYCODE_BACK){
           setResult(11,this.getIntent());
		this.finish();
		return false;
	}}





    /** Called when the activity is first created. */

    /**
     * ������Ҳ����Ķ���Ч��
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
     * ���������˳��Ķ���Ч��
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
     * �����������Ķ���Ч��
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
     * ������Ҳ��˳�ʱ�Ķ���Ч��
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
		//������໬����ʱ�� 
    	if(e1.getX()-e2.getX()>FLING_MIN_DISTANCE && Math.abs(velocityX)>FLING_MIN_VELOCITY)
    	{
			//����View������Ļʱ��ʹ�õĶ���
    		m_ViewFlipper.setInAnimation(inFromRightAnimation());
    		//����View�˳���Ļʱ��ʹ�õĶ��� 
    		m_ViewFlipper.setOutAnimation(outToLeftAnimation());
    		//��һ��ҳ��
    		m_ViewFlipper.showNext();
    		//��ȡ��ӦԪ��������ʾ������ͼ
    	}
    	//�����Ҳ໬����ʱ�� 
		else if(e2.getX()-e1.getX()>FLING_MIN_DISTANCE && Math.abs(velocityX)>FLING_MIN_VELOCITY)
		{
			//����View������Ļʱ��ʹ�õĶ���
			m_ViewFlipper.setInAnimation(inFromLeftAnimation());
			//����View�˳���Ļʱ��ʹ�õĶ��� 
			m_ViewFlipper.setOutAnimation(outToRightAnimation());
			//��һ��ҳ��
			m_ViewFlipper.showPrevious();
			//��ȡ��ӦԪ��������ʾ������ͼ
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
		//һ��Ҫ�������¼���������ʶ����ȥ����(�Լ��������鷳��)
		return m_GestureDetector.onTouchEvent(event);
	}
	
	
	
    //��ѡ��������3
    class RadioClickListener implements OnClickListener {  
	  @Override  
	  public void onClick(View v) {  
	   AlertDialog ad =new AlertDialog.Builder(Main.this).setTitle("ѡ��ģʽ")  
	   .setSingleChoiceItems(areas,radioOnClick.getIndex(),radioOnClick).create();  
	   RadioListView=ad.getListView();  
	   ad.show();  
    }  
    }  
    
    /** 
     * �����ѡ���¼� 
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
   // Toast.makeText(Main.this, "��ѡ���ˣ� " + areas[index], Toast.LENGTH_LONG).show();  
    switch (index)
    {
   //һ��ģʽ�£�
      case  0: 
    	  
      { 
    	//��һ���ӽڵ�����ȣ�
    	send(0x01,0x5a);    	 
      
      //�ڶ����ӽڵ�����ȣ�
      	send(0x02,0x5a);
     
      //�������ӽڵ�����ȣ�
      	send(0x03,0x5a);
      	
     //���ĸ��ӽڵ�����ȣ�
      	send(0x04,0x5a);
    	Toast.makeText(Main.this, "��ѡ���ˣ� " + areas[index], Toast.LENGTH_LONG).show();  
    	 dialog.dismiss(); 
    }   
    break;
    
    
   // ����ģʽ�£�
      case  1: 
      { 
    	  //��һ·�ӽڵ㣻
    	  send(0x01,0x23);
   	  
    	  //�ڶ�·�ӽڵ㣻
    	  send(0x02,0x23);
    	  
    	 //����·�ӽڵ㣻 
    	  send(0x03,0x23);
    	  
    	  //����·�ӽڵ㣻
    	  send(0x04,0x23);
    	  Toast.makeText(Main.this, "��ѡ���ˣ� " + areas[index], Toast.LENGTH_LONG).show();  
    	  dialog.dismiss(); 
    }   break;
    
    
    //��Ƶģʽ�£�
      case  2: 
      { 
    	  //��һ·�ӽڵ㣻
    	  send(0x01,0xc8);
    	
    	  //�ڶ�·�ӽڵ㣻
    	  send(0x02,0xc8);
    	  
    	 //����·�ӽڵ㣻 
    	  send(0x03,0xc8);
    	  
    	  //����·�ӽڵ㣻
    	  send(0x04,0xc8);
    	  
    	  Toast.makeText(Main.this, "��ѡ���ˣ� " + areas[index], Toast.LENGTH_LONG).show();  
    	  dialog.dismiss();  
    }   break;
    
    
    //ӭ��ģʽ��
      case  3: 
      { 
    	  //��һ·�ӽڵ㣻
    	  send(0x01,0x23);
    
    	  //�ڶ�·�ӽڵ㣻
    	  TimerTask timerTask = new TimerTask() {              
              @Override
              public void run() 
              {
                      // ��Ҫ�ɵĻ�
            	  send(0x02,0x23);
             }
      };
      timer.schedule(timerTask, 1000 * 3);
       //����·�ӽڵ㣺
	  TimerTask timerTask1 = new TimerTask() {              
          @Override
          public void run() {
        	  
                  // ��Ҫ�ɵĻ�
        	  send(0x03,0x23);
        	  
          }
      };
        	 timer.schedule(timerTask1, 1000 * 6); //2���ִ��
    	  
    	  //����·�ӽڵ㣻
       TimerTask timerTask2 = new TimerTask() {              
            @Override
            public void run() {
                         // ��Ҫ�ɵĻ�
            	send(0x04,0x23);
    	 	
            }};	            
            timer.schedule(timerTask2, 1000 * 9);
    	  Toast.makeText(Main.this, "��ѡ���ˣ� " + areas[index], Toast.LENGTH_LONG).show();  
    	   dialog.dismiss();  
    }   break;
    
    //����
      case 4:
    	  
      {//Toast.makeText(Main.this, "��ѡ���ˣ� " + areas[index], Toast.LENGTH_LONG).show();  
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
    