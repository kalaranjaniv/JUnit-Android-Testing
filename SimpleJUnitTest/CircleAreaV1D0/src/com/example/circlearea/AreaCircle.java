package com.example.circlearea;


import java.text.DecimalFormat;
import java.util.StringTokenizer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.text.format.Time;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AreaCircle extends Activity {

	//@Override
	
	 String hours,minutes,seconds,hours1,minutes1;
	 int hrs,mins,secs;
	 TextView totaltime,indiatime,result,result1,californiatime;
	 EditText radius;
	 EditText pilength;
	 String localtimemsg;
	 String areastr1;
	 String circumfstr1;
	 double pi,temp,pif,radius1;
	 Handler hr=new Handler();	
	 String s2,s3;
	 private Thread workingthread=null;
	   final Handler mHandler=new Handler()
       {
      public void handleMessage(Message msg)
      {
   	   Bundle b;
   	   String s1;    	      	   
   	   if(msg.what==1)
   	   {
   		b=msg.getData();
   		s1=b.getString("localtime"); 
   		StringTokenizer tokens=new StringTokenizer(s1,":");
   		hrs=Integer.parseInt(tokens.nextToken().toString());
   		mins=Integer.parseInt(tokens.nextToken().toString());
   		secs=Integer.parseInt(tokens.nextToken().toString());
   		indiaTimeThread t1=new indiaTimeThread();
   		californiaTimeThread t2=new californiaTimeThread();
   		totaltime.setText(s1); 
   		String minutesnew,hoursnew,secondsnew;
   		
   		t1.start();   
   		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hoursnew=Integer.toString(hrs);
		minutesnew=Integer.toString(mins);
		secondsnew=Integer.toString(secs);
   		s2=hoursnew+":"+minutesnew+":"+secondsnew; 
   	
   		t2.start();
   		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hoursnew=Integer.toString(hrs);
		minutesnew=Integer.toString(mins);
		secondsnew=Integer.toString(secs);
   		s3=hoursnew+":"+minutesnew+":"+secondsnew;
   	
   		indiatime.setText(s2);
   		californiatime.setText(s3);
   	   }
   	   super.handleMessage(msg);
   	   }
       };	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_area_circle);
		final Button calculatevalue = (Button) findViewById(R.id.calculate);
        final Button close = (Button) findViewById(R.id.exit);
        final Button clear = (Button) findViewById(R.id.clear);
        radius=(EditText) findViewById(R.id.editText1);  
        pilength =(EditText) findViewById(R.id.editText2);
        result = (TextView) findViewById(R.id.textView1);
        result1 = (TextView) findViewById(R.id.result1);
        totaltime=(TextView)findViewById(R.id.totaltime);
        indiatime=(TextView)findViewById(R.id.indiatime);
        californiatime=(TextView)findViewById(R.id.californiatime);
        workingthread = new JobThread(mHandler);
        workingthread.start();
       
            calculatevalue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {   
            	if("".equals(radius.getText().toString()))
            	{
            		radius.setError("radius should not be empty");
            	}
            	else
            	{
            		if("".equals(pilength.getText().toString()))
            		{
            			pilength.setError("Precision length should not be empty");
            		}
            		else
            		{
            			if((Integer.parseInt(pilength.getText().toString()))>16)
                		{
                	pilength.setError("Please enter the value as less than 16");
                	pilength.setText("0");
                	result.setText("0.00000000");
                	result1.setText("0.00000000");
                		}
                else
                {	
                pi=(double)22/(double)7;       
                temp = (double) Math.pow(10,Double.parseDouble((pilength.getText().toString())));          
                pif=(double)Math.round(pi*temp)/temp;             
                radius1 = Double.parseDouble(radius.getText().toString()); 
    	         	areaThread a1=new areaThread(radius1,pif);
    	         	circumThread c1=new circumThread(radius1,pif); 	         
    	         	a1.start();	         	        	
    	        	c1.start();
    	        	try {
    					Thread.sleep(100);
    				} catch (InterruptedException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    	        	result1.setText(circumfstr1);
    	        	result.setText(areastr1);
                }
                      
            			
            		}
            	}
            	
            
            }
              // Perform action on click
            }
        ); 
     
        
        close.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	finish();       	       	
             // Perform action on click
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	result1.setText("0.00000000");
            	result.setText("0.00000000");
            	pilength.setText("0");
            	radius.setText("0.0");  
            	pilength.setError(null);
            	radius.setError(null);
             // Perform action on click
            }
        });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_area_circle, menu);
		return true;		
	}
	
public class JobThread extends Thread {
	private Handler hd;
	public JobThread(Handler msgHandler)
	{
		hd=msgHandler;
	}
	public void run()
	{
		Bundle b=new Bundle();
		String key1="localtime";
		Time now = new Time();
		now.setToNow();
		hours=String.valueOf(now.hour);
		minutes = String.valueOf(now.minute);
		seconds =String.valueOf(now.second);
		String str1=hours+":"+minutes+":"+seconds;	
		b.putString(key1,str1);
		Message msg=hd.obtainMessage();
		msg.what=1;		
		msg.setData(b);
		hd.sendMessage(msg);
		hr.postDelayed(this,4000);					
	}
}
class indiaTimeThread extends Thread
{

	public void run()
	{
		if(hrs+10>24)
		{
			hrs=((hrs+10)-24);
		}
			
		else
			{
				hrs=hrs+10;
			}
		if((mins+30)>=60)
		{
			mins=((mins+30)-60);
			hrs=hrs+1;
			if(hrs>=24)
			{
				hrs=hrs-24;
			}
		}
		else
		{
			mins=mins+30;
		}
   		
		
	}
}
class californiaTimeThread extends Thread 
{

	public void run()
	{
		if(hrs-12<0)
		{
			hrs=((hrs-12)+24);
		}
			
		else
			{
				hrs=hrs-12;
			}
		if((mins-30)<0)
		{
			mins=((mins-30)+60);
			hrs=hrs-1;
			if(hrs<0)
			{
				hrs=hrs+24;
			}
		}
		else
		{
			mins=mins-30;
		}


	}
}
class areaThread extends Thread
{
	double locradius,locpi,area;
	areaThread(double radius,double pi)
	{
		locradius=radius;
		locpi=pi;
	}
	public void run()
	{
	 area = (double) locradius*locradius*locpi;
	 DecimalFormat df = new DecimalFormat("##.########");
	 areastr1=df.format(area); 
	}
}
class circumThread extends Thread
{
	double locradius,locpi,area;
	circumThread(double radius,double pi)
	{
		locradius=radius;
		locpi=pi;
	}
	public void run()
	{
	double circumference=(double)2*locpi*locradius;
	 DecimalFormat df = new DecimalFormat("##.########");
	 circumfstr1=df.format(circumference);
	}
}


}
							




