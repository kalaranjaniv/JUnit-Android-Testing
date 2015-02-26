package com.example.circlearea.test;

import com.example.circlearea.AreaCircle;
import com.jayway.android.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;
import android.text.format.Time;

public class InitialLoadTest extends
		ActivityInstrumentationTestCase2<AreaCircle> {
private Solo solo;
	
	public InitialLoadTest()
	{
		super("com.example.circlearea",AreaCircle.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		this.solo=new Solo(getInstrumentation(),getActivity());
	}
	protected void tearDown() throws Exception {
		getActivity().finish();
		super.tearDown();
	}
	public void testFSM01()
	{	
		solo.enterText(0,"");
		solo.enterText(0,"12.5");
		solo.enterText(1,"");
		solo.enterText(1,"1");
		solo.clickOnButton("Calculate");
		String text1=solo.getText(7).getText().toString();
		String text2=solo.getText(6).getText().toString();
		boolean expected=true;
		boolean actual=false;
		if(text2.equals("484.375") && text1.equals("77.5"))
				{
			
	          actual=true;
				}	
		assertEquals("Calculation is not working properly-FSM01",expected,actual);
	}
	public void testFSM02()
	{
		solo.enterText(0, "");
		solo.clickOnButton("Calculate");
		boolean expected=true;
		boolean actual=solo.searchText("radius should not be empty");		
		assertEquals("Error message not displayed-FSM02",expected,actual);	
	
	}
	public void testACT01()
	{
		solo.enterText(0,"");
		solo.enterText(0,"12.555555");
		solo.enterText(1,"");
		solo.enterText(1,"4");
		solo.clickOnButton("Calculate");
		String text1=solo.getText(6).getText().toString();
		boolean expected=true;
		boolean actual=false;
		if(text1.equals("495.45292035"))
				{
			actual=true;
				}
				assertEquals("No: of digits displayed in area is not exactly equal to 8 after decimal point-ACT01",expected,actual);
	}
	public void testACT02()
	{
		solo.enterText(0,"");
		solo.enterText(0,"12.555555");
		solo.enterText(1,"");
		solo.enterText(1,"4");
		solo.clickOnButton("Calculate");
		String text2=solo.getText(7).getText().toString();
		boolean expected=true;
		boolean actual=false;
		if(text2.equals("78.92170762"))
				{
			
			actual=true;
				}
				assertEquals("No: of digits displayed in circumference is not exactly equal to 8 after decimal point-ACT02",expected,actual);
				
	}
	public void testFSM03()
	{   
		solo.enterText(0, "");
	    solo.enterText(0,"12.5");
		solo.enterText(1,"");		
		solo.clickOnButton("Calculate");
		boolean expected=true;
		boolean actual=solo.searchText("Precision length should not be empty");
		assertEquals("Error message not displayed-FSM03",expected,actual);	
		
	}
	public void testACT03()
	{
		solo.enterText(0, "");
		solo.enterText(0, "12.5555555");
		solo.enterText(1, "");
		solo.enterText(1, "12");		
		solo.clickOnButton("Calculate");
		String text1=solo.getText(6).getText().toString();
		boolean expected=true;
		boolean actual=false;
		if(text1.equals("495.44620373"))
				{
			actual=true;
				}		
				assertEquals("Calculation is not working properly-ACT03",expected,actual);
	}
	public void testACT04()
	{
		solo.enterText(0, "");
		solo.enterText(0, "12.5555555");
		solo.enterText(1, "");
		solo.enterText(1, "12");		
		solo.clickOnButton("Calculate");
		String text2=solo.getText(7).getText().toString();
		boolean expected=true;
		boolean actual=false;
		if(text2.equals("78.92063457"))
				{
			actual=true;
				}		
				assertEquals("Calculation is not working properly-ACT04",expected,actual);
	}
	public void testSQ01()
	{		
		solo.clickOnButton("Calculate");
		String text1=solo.getText(7).getText().toString();
		String text2=solo.getText(6).getText().toString();
		boolean expected=true;
		boolean actual=false;
		if(text1.equals("0") && text2.equals("0"))
				{
			actual=true;
				}		
		assertEquals("Calculate button not working-SQ01",expected,actual);
	}
	public void testSQ02()
	{
		solo.clickOnButton("Clear");
		String text1=solo.getEditText(0).getText().toString();
		String text2=solo.getEditText(1).getText().toString();
		String text3=solo.getText(6).getText().toString();
		String text4=solo.getText(7).getText().toString();
		boolean actual=false;
		if(text3.equals("0.00000000") && text4.equals("0.00000000") && text1.equals("0.0") && text2.equals("0"))
		{
		actual=true;
		}
		boolean expected=true;
		assertEquals("Clear button not working-SQ02",expected,actual);
		
	}
	public void testFSM04()
	{
		solo.enterText(0,"");
		solo.enterText(1,"");
		solo.enterText(1,"5");
		solo.clickOnButton("Calculate");
		solo.clickOnButton("Clear");
		String text1=solo.getEditText(0).getText().toString();
		String text2=solo.getEditText(1).getText().toString();
		String text3=solo.getText(6).getText().toString();
		String text4=solo.getText(7).getText().toString();
		boolean actual=false;
		if(text3.equals("0.00000000") && text4.equals("0.00000000") && text1.equals("0.0") && text2.equals("0"))
		{
		actual=true;
		}
		boolean expected=true;
		assertEquals("Clear button not working-FSM04",expected,actual);		
	}
	public void testFSM05()
	{
		solo.enterText(0,"");
		solo.enterText(0,"12.5");
		solo.enterText(1,"");
		solo.enterText(1,"16");
		solo.clickOnButton("Calculate");
		solo.clickOnButton("Clear");
		String text1=solo.getEditText(0).getText().toString();
		String text2=solo.getEditText(1).getText().toString();
		String text3=solo.getText(6).getText().toString();
		String text4=solo.getText(7).getText().toString();
		boolean actual=false;
		if(text3.equals("0.00000000") && text4.equals("0.00000000") && text1.equals("0.0") && text2.equals("0"))
		{
		actual=true;
		}
		boolean expected=true;
		assertEquals("Clear button not working-FSM05",expected,actual);
		
	}
	
	public void testUC01()
	{
		solo.clickOnButton("Exit");
		boolean expected=true;
		boolean actual=false;
		if(solo.getActivityMonitor().getResult()==null)
		{
			actual=true;
		}
		assertEquals("Exit button not working-UC01",expected,actual);
	}
	public void testFSM06()
	{
		solo.enterText(0,"");
		solo.clickOnButton("Calculate");
		solo.clickOnButton("Exit");
		boolean expected=true;
		boolean actual=false;
		if(solo.getActivityMonitor().getResult()==null)
		{
			actual=true;
		}
		assertEquals("Exit button not working-FSM06",expected,actual);		
	}
	public void testFSM07()
	{
		solo.enterText(0, "");
		solo.enterText(0,"12.5");
		solo.enterText(1, "");
		solo.enterText(1,"1");
		solo.clickOnButton("Calculate");
		String text0=solo.getText(7).getText().toString();
		String text00=solo.getText(6).getText().toString();
		boolean expected=true;
		boolean actual=false;
		if(text00.equals("484.375") && text0.equals("77.5"))
		{
			solo.clickOnButton("Clear");
			String text1=solo.getEditText(0).getText().toString();
			String text2=solo.getEditText(1).getText().toString();
			String text3=solo.getText(6).getText().toString();
			String text4=solo.getText(7).getText().toString();
			if(text3.equals("0.00000000") && text4.equals("0.00000000") && text1.equals("0.0") && text2.equals("0"))
			{
			actual=true;
			}
		}
		assertEquals("FSM07-Flow is not working properly",expected,actual);
		
	}
	public void testFSM08()
	{
		solo.enterText(0, "");
		solo.enterText(0,"12.5");
		solo.enterText(1, "");
		solo.enterText(1,"1");
		solo.clickOnButton("Calculate");
		String text0=solo.getText(7).getText().toString();
		String text00=solo.getText(6).getText().toString();
		boolean expected=true;
		boolean actual=false;
		if(text00.equals("484.375") && text0.equals("77.5"))
		{
			solo.clickOnButton("Exit");	
			if(solo.getActivityMonitor().getResult()==null)
			{
				actual=true;
			}
		}
		assertEquals("FSM08-Flow is not working properly",expected,actual);
		
	}
	public void testFSM09()
	{
		solo.enterText(0, "");
		solo.enterText(0,"12.5");
		solo.enterText(1, "");
		solo.enterText(1,"1");
		solo.clickOnButton("Calculate");
		String text0=solo.getText(7).getText().toString();
		String text00=solo.getText(6).getText().toString();
		boolean expected=true;
		boolean actual=false;
		if(text00.equals("484.375") && text0.equals("77.5"))
		{
			solo.clickOnButton("Clear");
			String text1=solo.getEditText(0).getText().toString();
			String text2=solo.getEditText(1).getText().toString();
			String text3=solo.getText(6).getText().toString();
			String text4=solo.getText(7).getText().toString();
			if(text3.equals("0.00000000") && text4.equals("0.00000000") && text1.equals("0.0") && text2.equals("0"))
			{
				solo.clickOnButton("Exit");	
				if(solo.getActivityMonitor().getResult()==null)
				{
					actual=true;
				}
			}
			
		}
		assertEquals("FSM09-Flow is not working properly",expected,actual);
		
	}
	public void testFSM10()
	{
		solo.enterText(0, "");
		solo.clickOnButton("Calculate");
		boolean expected=true;
		boolean actual=solo.searchText("radius should not be empty");
		if(actual==true)
		{
			actual=false;
			solo.clickOnButton("Clear");
			String text1=solo.getEditText(0).getText().toString();
			String text2=solo.getEditText(1).getText().toString();
			String text3=solo.getText(6).getText().toString();
			String text4=solo.getText(7).getText().toString();
			if(text3.equals("0.00000000") && text4.equals("0.00000000") && text1.equals("0.0") && text2.equals("0"))
			{
				solo.clickOnButton("Exit");	
				if(solo.getActivityMonitor().getResult()==null)
				{
					actual=true;
				}
		}
			
			
		}
		assertEquals("FSM10-Flow is not working properly",expected,actual);
		
	}
	public void testUC02()
	{			
		Time now=new Time();
		now.setToNow();
		String text1=solo.getText(17).getText().toString();
		String[] separated=text1.split(":");
		String hrs1=String.valueOf(now.hour);
		String mins1=String.valueOf(now.minute);
		boolean actual=false;
		boolean expected=true;
		if(hrs1.equals(separated[0]) & mins1.equals(separated[1]))
		{
			 actual=true;
		}
		assertEquals("Current system time is not displayed-UC02",expected,actual);
	}

	public void testACT06()
	{			
		Time now=new Time();
		now.setToNow();
		String text1=solo.getText(16).getText().toString();
		String[] separated=text1.split(":");
		String hrs=String.valueOf(now.hour);
		String mins=String.valueOf(now.minute);
		String hrs1=String.valueOf(Integer.parseInt(hrs)-2);
		if(Integer.parseInt(hrs1)<0)
		{
			hrs1 = String.valueOf(Integer.parseInt(hrs1) + 24);
		}
		boolean actual=false;
		boolean expected=true;
		if(hrs1.equals(separated[0]) & mins.equals(separated[1]))
		{
			 actual=true;
		}
		assertEquals("Current california time is not displayed-ACT06",expected,actual);
	}
	public void testACT05()
	{	
	Time now=new Time();
		now.setToNow();
		String text1=solo.getText(15).getText().toString();
		String[] separated=text1.split(":");
		String hrs=String.valueOf(now.hour);
		String mins=String.valueOf(now.minute);
		String hrs1=String.valueOf(Integer.parseInt(hrs)+10);
		String mins1=String.valueOf(Integer.parseInt(mins)+30);
		if(Integer.parseInt(hrs1)>=24)
		{
			hrs1 = String.valueOf(Integer.parseInt(hrs1) - 24);
		}
		if(Integer.parseInt(mins1)>=60)
		{			
			mins1=String.valueOf((Integer.parseInt(mins1)-60));
			hrs1=String.valueOf(Integer.parseInt(hrs1)+1);
			if(Integer.parseInt(hrs1)>=24)
			{
				hrs1=String.valueOf(Integer.parseInt(hrs1)-24);				
			}
			
		}
		boolean actual=false;
		boolean expected=true;
		if(hrs1.equals(separated[0]) & mins1.equals(separated[1]))
		{
			 actual=true;
		}
		assertEquals("Current India time is not displayed-ACT05",expected,actual);
	}
	
	
	

}
