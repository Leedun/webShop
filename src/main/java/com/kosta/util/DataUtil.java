package com.kosta.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataUtil
{
	public static Date convertToDate(String strdate)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		//oracle 분 : mi
		//자바의 분은 mm
		//자바의 월은 MM
		
		java.util.Date d;		
		Date d2 = null;
		try
		{
			d = sdf.parse(strdate);
			d2 = new Date(d.getTime());
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d2;
	}
}
