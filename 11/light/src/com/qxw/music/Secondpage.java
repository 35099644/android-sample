package com.qxw.music;


import java.io.IOException;
import java.io.OutputStream;
import com.qxw.music.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.content.SharedPreferences;
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

public class Secondpage extends Activity {
	private ImageButton imagebutton;
	private ImageButton ibutton5_o,ibutton5_c,ibutton6_o,ibutton6_c,ibutton7_o,
	ibutton7_c,ibutton8_o,ibutton8_c;
	RadioGroup radiogroup0,radiogroup1,radiogroup2,radiogroup3;  
	RadioButton radio1,radio2,radio3,radio4,radio5,radio6; 
	RadioButton radio11,radio12,radio13,radio14,radio15,radio16;
	RadioButton radio21,radio22,radio23,radio24,radio25,radio26;
	RadioButton radio31,radio32,radio33,radio34,radio35,radio36;
	OutputStream tmpOut = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.second);
		imagebutton=(ImageButton) findViewById(R.id.imageButton1);
		imagebutton.setOnClickListener(new Button.OnClickListener(){
		      @Override
		      public void onClick(View v)
		      {
		    	  LayoutInflater inflater = getLayoutInflater();
		    	  View layout = inflater.inflate(R.layout.dialog,
		    	  (ViewGroup) findViewById(R.id.dialog));

		    	   new AlertDialog.Builder(Secondpage.this)
		    	   .setTitle("Introduce")
		    	   .setView(layout)
		    	   .setPositiveButton("Return", null)
		    	   //.setNegativeButton("取消", null)
		    	   .show();	   
		    	   } });
		
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
            		Toast.makeText(Secondpage.this, "第五路灯光亮度为0%！",
       				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x05,0xff);
        		} 
            	    break;
            	case R.id.radio12:
          		 // DisplayToast("灯光亮度20%！");
            		Toast.makeText(Secondpage.this, "第五路灯光亮度为20%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x05,0xc8);
        		} 
          	    break;    
            	case R.id.radio13:
          		 //DisplayToast("灯光亮度40%！");
            		Toast.makeText(Secondpage.this, "第五路灯光亮度为40%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x05,0x91);
         		} 
          	    break; 
            	case R.id.radio14:
          		  //DisplayToast("灯光亮度60%！");
            		Toast.makeText(Secondpage.this, "第五路灯光亮度为60%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x05,0x5a);
        		} 
          	    break;
            	case R.id.radio15:
          		 // DisplayToast("灯光亮度80%！");
            		Toast.makeText(Secondpage.this, "第五路灯光亮度为80%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x05,0x23);
        		} 
          	    break;
            	default:
          		 // DisplayToast("灯光亮度100%！");
            		Toast.makeText(Secondpage.this, "第一路灯光亮度为100%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x05,0x00);
        		} 
          	    break;
            	}
            	
            }   
        });   
		
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
            		Toast.makeText(Secondpage.this, "第六路灯光亮度为0%！",
       				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x06,0xff);
           		} 
            	    break;
            	case R.id.radio22:
          		 // DisplayToast("灯光亮度20%！");
            		Toast.makeText(Secondpage.this, "第六路灯光亮度为20%！",
          				     Toast.LENGTH_SHORT).show();
            	{
            		send(0x06,0xc8);
           		} 
          	    break;    
            	case R.id.radio23:
          		 //DisplayToast("灯光亮度40%！");
            		Toast.makeText(Secondpage.this, "第六路灯光亮度为40%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x06,0x91);
           		} 
          	    break; 
            	case R.id.radio24:
          		  //DisplayToast("灯光亮度60%！");
            		Toast.makeText(Secondpage.this, "第六路灯光亮度为60%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x06,0x5a);
           		} 
          	    break;
            	case R.id.radio25:
          		 // DisplayToast("灯光亮度80%！");
            		Toast.makeText(Secondpage.this, "第六路灯光亮度为80%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x06,0x23);
        		} 
          	    break;
            	default:
          		 // DisplayToast("灯光亮度100%！");
            		Toast.makeText(Secondpage.this, "第六路灯光亮度为100%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x06,0x00);
            	} 
          	    break;
            	}
            	
            }   
        });   
        
        
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
            		Toast.makeText(Secondpage.this, "第七路灯光亮度为0%！",
       				     Toast.LENGTH_SHORT).show();
            	{ 
            		
            		send(0x07,0xff);
           		} 
            	    break;
            	case R.id.radio32:
          		 // DisplayToast("灯光亮度20%！");
            		Toast.makeText(Secondpage.this, "第七路灯光亮度为20%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x07,0xc8);
           		} 
          	    break;    
            	case R.id.radio33:
          		 //DisplayToast("灯光亮度40%！");
            		Toast.makeText(Secondpage.this, "第七路灯光亮度为40%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x07,0x91);
           		} 
          	    break; 
            	case R.id.radio34:
          		  //DisplayToast("灯光亮度60%！");
            		Toast.makeText(Secondpage.this, "第七路灯光亮度为60%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x07,0x5a);
           		} 
          	    break;
            	case R.id.radio35:
          		 // DisplayToast("灯光亮度80%！");
            		Toast.makeText(Secondpage.this, "第七路灯光亮度为80%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x07,0x23);
           		} 
          	    break;
            	default:
          		 // DisplayToast("灯光亮度100%！");
            		Toast.makeText(Secondpage.this, "第七路灯光亮度为100%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x07,0x00);
            	} 
          	    break;
            	}
            	
            }   
        });   //第四路
        
        
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
            		Toast.makeText(Secondpage.this, "第八路灯光亮度为0%！",
       				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x08,0xff);
        		} 
            	    break;
            	case R.id.radio42:
          		 // DisplayToast("灯光亮度20%！");
            		Toast.makeText(Secondpage.this, "第八路灯光亮度为20%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x08,0xc8);
           		} 
          	    break;    
            	case R.id.radio43:
          		 //DisplayToast("灯光亮度40%！");
            		Toast.makeText(Secondpage.this, "第八路灯光亮度为40%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x08,0x91);
           		} 
          	    break; 
            	case R.id.radio44:
          		  //DisplayToast("灯光亮度60%！");
            		Toast.makeText(Secondpage.this, "第八路灯光亮度为60%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x08,0x5a);
           		} 
          	    break;
            	case R.id.radio45:
          		 // DisplayToast("灯光亮度80%！");
            		Toast.makeText(Secondpage.this, "第八路灯光亮度为80%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x08,0x23);
           		} 
          	    break;
            	default:
          		 // DisplayToast("灯光亮度100%！");
            		Toast.makeText(Secondpage.this, "第八路灯光亮度为100%！",
          				     Toast.LENGTH_SHORT).show();
            	{ 
            		send(0x08,0x00);
           		} 
          	    break;
            	}
            	
            }   
        });  
		
		ibutton5_o=(ImageButton) findViewById(R.id.imageButton2);
		ibutton5_o.setOnClickListener(new ClickEventKey());
		ibutton5_c=(ImageButton) findViewById(R.id.imageButton3);
		ibutton5_c.setOnClickListener(new ClickEventKey());
		ibutton6_o=(ImageButton) findViewById(R.id.imageButton4);
		ibutton6_o.setOnClickListener(new ClickEventKey());
		ibutton6_c=(ImageButton) findViewById(R.id.imageButton5);
		ibutton6_c.setOnClickListener(new ClickEventKey());
		ibutton7_o=(ImageButton) findViewById(R.id.imageButton6);
		ibutton7_o.setOnClickListener(new ClickEventKey());
		ibutton7_c=(ImageButton) findViewById(R.id.imageButton7);
		ibutton7_c.setOnClickListener(new ClickEventKey());
		ibutton8_o=(ImageButton) findViewById(R.id.imageButton8);
		ibutton8_o.setOnClickListener(new ClickEventKey());
		ibutton8_c=(ImageButton) findViewById(R.id.imageButton9);
		ibutton8_c.setOnClickListener(new ClickEventKey());
	}
	
    class ClickEventKey implements View.OnClickListener {
    	@Override
    	public void onClick(View v) {
    	//	if (v == ibutton1_o)
    		switch (v.getId())
    	
    		{
    		case R.id.imageButton2:
    		{ 
    			send(0x05,0x23);
       		}  
    		
    		break;
    		case R.id.imageButton3:
       		{ 
    			send(0x05,0xff);
    		}  
    		
    		break;
    		case R.id.imageButton4:
    		{ 
    			send(0x06,0x23);
     		}  
    			
    		break;
    		case R.id.imageButton5:
    		{ 
    			send(0x06,0xff);
    		}  
 
    		break;
     		case R.id.imageButton6:
    		{ 
    			send(0x07,0x23);
    		} 
 
    		break;
     		case R.id.imageButton7:
    		{ 
    			send(0x07,0xff);
    		} 
   
    		break;
     		case R.id.imageButton8:
    		{ 
    			send(0x08,0x23);
    		} 
    
    		break;
     		case R.id.imageButton9:
    		{ 
    			send(0x08,0xff);
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
