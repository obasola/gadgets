package com.kumasi;

import java.sql.Timestamp;
import java.util.Calendar;

public class DateUtil {
	public static Timestamp currentTimestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
}
