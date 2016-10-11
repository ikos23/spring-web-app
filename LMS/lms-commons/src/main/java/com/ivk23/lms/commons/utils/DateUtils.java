package com.ivk23.lms.commons.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	
	private static final SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
	
	public static Date convert(String input) throws ParseException {
		return formatter.parse(input);
	}
	
}
