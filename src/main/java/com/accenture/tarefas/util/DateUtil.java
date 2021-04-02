package com.accenture.tarefas.util;

import java.util.Calendar;
import java.util.Date;


public class DateUtil {
	
	public static Date somaDias(Date data, Integer dias) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.DAY_OF_MONTH, dias);
		return cal.getTime(); 
	}
}
