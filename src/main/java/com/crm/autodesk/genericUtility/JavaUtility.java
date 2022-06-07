package com.crm.autodesk.genericUtility;

import java.util.Date;
import java.util.Random;



/**
 * this class contains some java based methods which you can use them in scripts as and when required
 * @author mrinm
 *
 */
public class JavaUtility {
	/**
	 * Used to generate random number
	 * @return
	 */
	public int getRandomNumber()
	{
		Random random=new Random();
		int ranNum=random.nextInt(1000);
		return ranNum;
	}
	
	/**
	 * used to get system date and time in IST format
	 * @return
	 */
	public String getSystemDateAndTime()
	{
		Date date= new Date();
		return date.toString();
	}
	
	/**
	 * used to get system date in yyyy-mm-dd format
	 * @return
	 */
	public String getSystemDateWithFormat()
	{
		Date date= new Date();
		String dateAndTime=date.toString();
		
		int month = date.getMonth()+1;
		String year=dateAndTime.split(" ")[5];
		String dateorg=dateAndTime.split(" ")[2];
		String ddMMyyDate=year+"-"+month+"-"+dateorg;
		return ddMMyyDate;
	}

}
