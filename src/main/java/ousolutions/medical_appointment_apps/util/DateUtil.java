package ousolutions.medical_appointment_apps.util;

import java.sql.Date;
import java.time.LocalDate;

public class DateUtil {
	
	private final static DateUtil util = null;
	
	private DateUtil(){}
	
	public static DateUtil getInstance()
	{
		if(util == null)
		{
			return new DateUtil();
		}
		
		return util;
	}
	
	public Date getCurrentDate()
	{
		LocalDate localDate = LocalDate.now();
		return Date.valueOf(localDate);
	}
	

}
