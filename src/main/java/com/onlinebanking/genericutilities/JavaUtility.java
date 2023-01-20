package com.onlinebanking.genericutilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility
{
	public int getRandomno()
	{
		Random ran=new Random();
		int random=ran.nextInt(500);
		return random;
	}
	public String getSystemDate()
	{
		Date dt=new Date();
		 String date = dt.toString();
		 return date;
	}
	public String getSysDateAndTime()
	{
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date systemdate=new Date();
		String getDateAndTime=dateformat.format(systemdate);
		
		System.out.println(getDateAndTime);
		return getDateAndTime.replaceAll(":", "-");
		
		/*String YYYY=dateAndTime.split(" ")[5];
		String DD=dateAndTime.split(" ")[2];
		int MM=dt.getMonth()+1;
		
		String finalformat=YYYY+"-"+MM+"-"+DD;
		return finalformat;*/
	}
	
	public String getApplication(String text)
	{
		char ch[]=text.toCharArray();
		char ch1[]=new char[9];
		int j=0;
		for(int i=0;i<ch.length;i++)
		{
			if(ch[i]>='0'&&ch[i]<='9')
			{
				ch1[j]=(ch[i]);
				j++;
			}
		}
		String str = new String(ch1);
		return str;
	}
	
	public String getAccountNum(String text2)
	{
		char ch3[]=text2.toCharArray();
		char ch4[]=new char[13];
		 int j=0;
		for(int i=0;i<ch3.length;i++)
		{
			if(ch3[i]>='0'&&ch3[i]<='9')
			{
				ch4[j]=(ch3[i]);
				j++;
			}
		}
		String str1 = new String(ch4);
		return str1;
	}
	
	public String getDebitNum(String text3)
	{
		char ch5[]=text3.toCharArray();
		String st1 = " ";
		String st2 = " ";
		int count1=0;
		for(int i=0;i<ch5.length;i++)
		{
			if(ch5[i]>='0'&&ch5[i]<='9')
			{
				if(count1<12)
				{
					st1=st1+ch5[i];
				    count1++;
				}
				else {
					st2=st2+ch5[i];
				}
			}
		}
		return st1;
	}
	public String getDebitPin(String text3)
	{
		char ch5[]=text3.toCharArray();
		String st1 = " ";
		String st2 = " ";
		int count1=0;
		for(int i=0;i<ch5.length;i++)
		{
			if(ch5[i]>='0'&&ch5[i]<='9')
			{
				if(count1<12)
				{
					st1=st1+ch5[i];
				    count1++;
				}
				else {
					st2=st2+ch5[i];
				}
			}
		}
		return st2;
	}
	
	public String getCustomerId(String text4)
	{
		char ch7[]=text4.toCharArray();
		char ch8[]=new char[7];
		int j=0;
		for(int i=0;i<ch7.length;i++)
		{
			if(ch7[i]>='0'&&ch7[i]<='9')
				
			{
				ch8[j]=(ch7[i]);
				j++;
			}
		}
		String st4 = new String(ch8);
		return st4;
	}
	
	public String getOtp(String Otp)
	{
		char chh[]=Otp.toCharArray();
		String st13 = " ";
		int count2=0;
		for(int i=chh.length-1;i>=0;i--)
		{
			if(chh[i]>='0'&&chh[i]<='9')
			{
				if(count2<6)
				{
					st13=st13+chh[i];
				    count2++;
				}
				else {
					
				}
			}
		}
		
		return st13;
	}
}
