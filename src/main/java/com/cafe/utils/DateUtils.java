package com.cafe.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static String getNowDate() {
		DateFormat format = new SimpleDateFormat("yyyyMMdd");
		return format.format(new Date());
	}
	
	public static String getNowTime() {
		DateFormat format = new SimpleDateFormat("HHmm");
		return format.format(new Date());
	}
}
