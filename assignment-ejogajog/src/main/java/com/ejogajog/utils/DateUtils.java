package com.ejogajog.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class DateUtils {
	private final static String DATE_PATTERN_ISO8601 = "yyyy-MM-dd";
	private final static String DATE_TIME_PATTERN_ISO8601 = "yyyy-MM-dd'T'HH:mm:ss";

	public static Date parseGmtDateOrTime(final String dateOrTimeString) {
		String pattern = dateOrTimeString.length() == DATE_PATTERN_ISO8601.length() ? DATE_PATTERN_ISO8601
				: DATE_TIME_PATTERN_ISO8601;
		Date date = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(pattern);
			formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
			date = formatter.parse(dateOrTimeString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date parseDateOrTime(final String dateOrTimeString) {
		String pattern = dateOrTimeString.length() == DATE_PATTERN_ISO8601.length() ? DATE_PATTERN_ISO8601
				: DATE_TIME_PATTERN_ISO8601;
		Date date = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(pattern);
			date = formatter.parse(dateOrTimeString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Integer compareDatePart(Date date1, Date date2) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date parsedDate1 = dateFormat.parse(dateFormat.format(date1));
			Date parsedDate2 = dateFormat.parse(dateFormat.format(date2));
			return parsedDate1.compareTo(parsedDate2);
		} catch (ParseException e) {
			return null;
		}
	}

	public static Integer compareTimePart(Date date1, Date date2) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a");
		try {
			Date parsedDate1 = dateFormat.parse(dateFormat.format(date1));
			Date parsedDate2 = dateFormat.parse(dateFormat.format(date2));
			return parsedDate1.compareTo(parsedDate2);
		} catch (ParseException e) {
			return null;
		}
	}

}
