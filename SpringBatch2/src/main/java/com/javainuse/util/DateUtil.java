package com.javainuse.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateUtil {
	public Date convertFromString(String date) {
		SimpleDateFormat as = new SimpleDateFormat("dd-MMM-yy");
		Date da = new Date();
		try {
			da = as.parse(date);
			System.out.println(da);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return da;
	}
//	public static void main(String[] args) {
//		DateUtil obj = new DateUtil();
//		
//		System.out.println(obj.convertFromString("22-May-20"));
//	}
}
