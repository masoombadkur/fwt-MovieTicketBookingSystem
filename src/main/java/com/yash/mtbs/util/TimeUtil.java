package com.yash.mtbs.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {
	
	public static String calcuteEndTime(String startTime, int interval) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
		Date date = null;
		try {
			date = simpleDateFormat.parse(startTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, interval);
		simpleDateFormat.format(calendar.getTime());
		return simpleDateFormat.format(calendar.getTime());
	}
	
	public static String getTodaysDate(){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		Date todaysDate = new Date();
		return formatter.format(todaysDate);
	}

}
