package com.qxw.music;


import java.io.IOException;

import java.io.OutputStream;
import com.qxw.music.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
//import android.view.MotionEvent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class Firstpage extends Activity {
	private ImageButton imagebutton;
	private ImageButton ibutton1_o,ibutton1_c,ibutton2_o,ibutton2_c,ibutton3_o,
	ibutton3_c,ibutton4_o,ibutton4_c,btnallop,btnallcl;
	RadioGroup radiogroup0,radiogroup1,radiogroup2,radiogroup3;  
	RadioButton radio1,radio2,radio3,radio4,radio5,radio6; 
	RadioButton radio11,radio12,radio13,radio14,radio15,radio16;
	RadioButton radio21,radio22,radio23,radio24,radio25,radio26;
	RadioButton radio31,radio32,radio33,radio34,radio35,radio36;
	OutputStream tmpOut = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.first);
		//全开按钮
		btnallop=(ImageButton) findViewById(R.id.btnopen);
		btnallop.setOnClickListener(new Button.OnClickListener(){
		      @Override
		      public void onClick(View v)
		      {
		    	  //第一路灯亮
		    	  send(0x01,0x23);
		    	  
		    	
		    	 //第二路灯亮 
		    	  send(0x02,0x23);
		    	  
		    	//第三路灯亮  
		    	  send(0x03,0x23);
		    	 
		    	//第四路灯亮  
		    	  send(0x04,0x23);
		    	
		      
		      }});
		
		//全关按钮
		
		btnallcl=(ImageButton) findViewById(R.id.btnclose);
		btnallcl.setOnClickListener(new Button.OnClickListener(){
		      @Override
		      public void onClick(View v)
		      {
		    	  //第一路灯亮
		    	  send(0x01,0xff);
		    	
		    	 //第二路灯亮 
		    	  send(0x02,0xff);
		    	  
		    	  send(0x03,0xff);
		    	  
		    	  send(0x04,0xff);
		    	  
		      }
		      });
		//产品介绍按钮
		imagebutton=(ImageButton) findViewById(R.id.imageButton1);
		imagebutton.setOnClickListener(new Button.OnClickListener(){
		      @Override
		      public void onClick(View v)
		      {
		    	   LayoutInflater inflater = getLayoutInflater();
		    	  View layout = inflater.inflate(R.layout.dialog,
		    	  (ViewGroup) findViewById(R.id.dialog));

		    	   new AlertDialog.Builder(Firstpage.this)
		    	   .setTitle("Introduce")
		    	   .setView(layout)
		    	   .setPositiveButton("Return", null)
		    	   //.setNegativeButton("取消", null)
		    	   .show();	   
		      } });
	
	//第一子节点的占空比；	
		radiogroup0=(RadioGroup)findViewById(R.id.radioGroup2);  
        radio1=(RadioButton)findViewById(R.id.radio11);   
        radio2=(RadioButton)findViewById(R.id.radio12);   
        radio3=(RadioButton)findViewById(R.id.radio13);   
        radio4=(RadioButton)findViewById(R.id.radio14);  
        radio5=(RadioButton)findViewById(R.id.radio15);
        radio6=(RadioButton)findViewById(R.id.radio16);
        radiogroup0.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {   
            
            @Override  
            public void onCheckedChanged(RadioGroup group, int checkedId) {   
                // TODO Auto-generated method stub   
            
            	switch (checkedId)
            	{
            	case R.id.radio11:
            		  /*DisplayToast("灯光亮度0%！");*/
            		Toast.makeText(Firstpage.this, "第一路灯光亮度为0%！",
       				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x01,0xff);
            		
     		} 
            	    break;
            	case R.id.radio12:
          		 // DisplayToast("灯光亮度20%！");
            		Toast.makeText(Firstpage.this, "第一路灯光亮度为20%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x01,0xc8);
            		
      		} 
          	    break;    
            	case R.id.radio13:
          		 //DisplayToast("灯光亮度40%！");
            		Toast.makeText(Firstpage.this, "第一路灯光亮度为40%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x01,0x91);
            		
       		} 
          	    break; 
            	case R.id.radio14:
          		  //DisplayToast("灯光亮度60%！");
            		Toast.makeText(Firstpage.this, "第一路灯光亮度为60%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x01,0x5a);
            		
       		} 
          	    break;
            	case R.id.radio15:
          		 // DisplayToast("灯光亮度80%！");
            		Toast.makeText(Firstpage.this, "第一路灯光亮度为80%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x01,0x23);
            		
       		} 
          	    break;
            	default:
          		 // DisplayToast("灯光亮度100%！");
            		Toast.makeText(Firstpage.this, "第一路灯光亮度为100%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x01,0x00);
            		
       		} 
          	    break;
            	}
            	
            }   
        });   
      //第二子节点的占空比；
        radiogroup1=(RadioGroup)findViewById(R.id.radioGroup3);  
        radio11=(RadioButton)findViewById(R.id.radio21);   
        radio12=(RadioButton)findViewById(R.id.radio22);   
        radio13=(RadioButton)findViewById(R.id.radio23);   
        radio14=(RadioButton)findViewById(R.id.radio24);  
        radio15=(RadioButton)findViewById(R.id.radio25);
        radio16=(RadioButton)findViewById(R.id.radio26);
        radiogroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {   
            
            @Override  
            public void onCheckedChanged(RadioGroup group, int checkedId) {   
                // TODO Auto-generated method stub   
            
            	switch (checkedId)
            	{
            	case R.id.radio21:
            		  /*DisplayToast("灯光亮度0%！");*/
            		Toast.makeText(Firstpage.this, "第二路灯光亮度为0%！",
       				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x02,0xff);
            		
     		} 
            	    break;
            	case R.id.radio22:
          		 // DisplayToast("灯光亮度20%！");
            		Toast.makeText(Firstpage.this, "第二路灯光亮度为20%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x02,0xc8);
            		
      		} 
          	    break;    
            	case R.id.radio23:
          		 //DisplayToast("灯光亮度40%！");
            		Toast.makeText(Firstpage.this, "第二路灯光亮度为40%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x02,0x91);
            		
       		} 
          	    break; 
            	case R.id.radio24:
          		  //DisplayToast("灯光亮度60%！");
            		Toast.makeText(Firstpage.this, "第二路灯光亮度为60%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x02,0x5a);
            		
       		} 
          	    break;
            	case R.id.radio25:
          		 // DisplayToast("灯光亮度80%！");
            		Toast.makeText(Firstpage.this, "第二路灯光亮度为80%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x02,0x23);
            		
       		} 
          	    break;
            	default:
          		 // DisplayToast("灯光亮度100%！");
            		Toast.makeText(Firstpage.this, "第二路灯光亮度为100%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x02,0x00);
            		
       		} 
          	    break;
            	}
            	
            }   
        });   
        
      //第三子节点的占空比；
        radiogroup2=(RadioGroup)findViewById(R.id.radioGroup4);  
        radio21=(RadioButton)findViewById(R.id.radio31);   
        radio22=(RadioButton)findViewById(R.id.radio32);   
        radio23=(RadioButton)findViewById(R.id.radio33);   
        radio24=(RadioButton)findViewById(R.id.radio34);  
        radio25=(RadioButton)findViewById(R.id.radio35);
        radio26=(RadioButton)findViewById(R.id.radio36);
        radiogroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {   
            
            @Override  
            public void onCheckedChanged(RadioGroup group, int checkedId) {   
                // TODO Auto-generated method stub   
            
            	switch (checkedId)
            	{
            	case R.id.radio31:
            		  /*DisplayToast("灯光亮度0%！");*/
            		Toast.makeText(Firstpage.this, "第三路灯光亮度为0%！",
       				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x03,0xff);
            		
     		} 
            	    break;
            	case R.id.radio32:
          		 // DisplayToast("灯光亮度20%！");
            		Toast.makeText(Firstpage.this, "第三路灯光亮度为20%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x03,0xc8);
            		
      		} 
          	    break;    
            	case R.id.radio33:
          		 //DisplayToast("灯光亮度40%！");
            		Toast.makeText(Firstpage.this, "第三路灯光亮度为40%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x03,0x91);
            		
       		} 
          	    break; 
            	case R.id.radio34:
          		  //DisplayToast("灯光亮度60%！");
            		Toast.makeText(Firstpage.this, "第三路灯光亮度为60%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x03,0x5a);
            		
       		} 
          	    break;
            	case R.id.radio35:
          		 // DisplayToast("灯光亮度80%！");
            		Toast.makeText(Firstpage.this, "第三路灯光亮度为80%！",
          				     Toast.LENGTH_SHORT).show();
            	{
            		send(0x03,0x23);
            		
       		} 
          	    break;
            	default:
          		 // DisplayToast("灯光亮度100%！");
            		Toast.makeText(Firstpage.this, "第三路灯光亮度为100%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x03,0x00);
            		
       		} 
          	    break;
            	}
            	
            }   
        });   //第四路
        
      //第四子节点的占空比；  
        radiogroup3=(RadioGroup)findViewById(R.id.radioGroup5);  
        radio31=(RadioButton)findViewById(R.id.radio41);   
        radio32=(RadioButton)findViewById(R.id.radio42);   
        radio33=(RadioButton)findViewById(R.id.radio43);   
        radio34=(RadioButton)findViewById(R.id.radio44);  
        radio35=(RadioButton)findViewById(R.id.radio45);
        radio36=(RadioButton)findViewById(R.id.radio46);
        radiogroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {   
            
            @Override  
            public void onCheckedChanged(RadioGroup group, int checkedId) {   
                // TODO Auto-generated method stub   
            
            	switch (checkedId)
            	{
            	case R.id.radio41:
            		  /*DisplayToast("灯光亮度0%！");*/
            		Toast.makeText(Firstpage.this, "第四路灯光亮度为0%！",
       				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x04,0xff);
            		
     		} 
            	    break;
            	case R.id.radio42:
          		 // DisplayToast("灯光亮度20%！");
            		Toast.makeText(Firstpage.this, "第四路灯光亮度为20%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x04,0xc8);
            		
      		} 
          	    break;    
            	case R.id.radio43:
          		 //DisplayToast("灯光亮度40%！");
            		Toast.makeText(Firstpage.this, "第四路灯光亮度为40%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x04,0x91);
            		
       		} 
          	    break; 
            	case R.id.radio44:
          		  //DisplayToast("灯光亮度60%！");
            		Toast.makeText(Firstpage.this, "第四路灯光亮度为60%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x04,0x5a);
            		
       		} 
          	    break;
            	case R.id.radio45:
          		 // DisplayToast("灯光亮度80%！");
            		Toast.makeText(Firstpage.this, "第四路灯光亮度为80%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x04,0x23);
            		
       		} 
          	    break;
            	default:
          		 // DisplayToast("灯光亮度100%！");
            		Toast.makeText(Firstpage.this, "第四路灯光亮度为100%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x04,0x00);
            		
       		} 
          	    break;
            	}
            	
            }   
        });  
		
		
		
		ibutton1_o=(ImageButton) findViewById(R.id.imageButton2);
		ibutton1_o.setOnClickListener(new ClickEventKey());
		ibutton1_c=(ImageButton) findViewById(R.id.imageButton3);
		ibutton1_c.setOnClickListener(new ClickEventKey());
		ibutton2_o=(ImageButton) findViewById(R.id.imageButton4);
		ibutton2_o.setOnClickListener(new ClickEventKey());
		ibutton2_c=(ImageButton) findViewById(R.id.imageButton5);
		ibutton2_c.setOnClickListener(new ClickEventKey());
		ibutton3_o=(ImageButton) findViewById(R.id.imageButton6);
		ibutton3_o.setOnClickListener(new ClickEventKey());
		ibutton3_c=(ImageButton) findViewById(R.id.imageButton7);
		ibutton3_c.setOnClickListener(new ClickEventKey());
		ibutton4_o=(ImageButton) findViewById(R.id.imageButton8);
		ibutton4_o.setOnClickListener(new ClickEventKey());
		ibutton4_c=(ImageButton) findViewById(R.id.imageButton9);
		ibutton4_c.setOnClickListener(new ClickEventKey());
	}
	
	
	
	
    class ClickEventKey implements View.OnClickListener {
    	@Override
    	public void onClick(View v) {
    	//	if (v == ibutton1_o)
    		switch (v.getId())
    	
    		{
    		case R.id.imageButton2:
    		{ 
    			send(0x01,0x23);
    		} 
    		
    		break;
    		case R.id.imageButton3:
    		
    		{ 
    			send(0x01,0xff);
    		}  
    		
    		break;
    		case R.id.imageButton4:
    		{ 
    			send(0x02,0x23);
    		} 
    		
    		break;
    		case R.id.imageButton5:
    		{ 
    			send(0x02,0xff);
    		} 
    		
    		break;
     		case R.id.imageButton6:
    		{ 
    		    send(0x03,0x23);
    		} 
    			
    		break;
     		case R.id.imageButton7:
    		{ 
    			send(0x03,0xff);
    		}  
    		
    		break;
     		case R.id.imageButton8:
    		{ 
    			send(0x04,0x23);
    		} 
    		
    		break;
     		case R.id.imageButton9:
    		{ 
    			send(0x04,0xff);
    		}  
    		
    		break;
    	}
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
		}
