package com.kosta.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataUtil
{
	public static Date convertToDate(String strdate)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		//oracle �� : mi
		//�ڹ��� ���� mm
		//�ڹ��� ���� MM
		
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
