package dev.marketo.samples.Leads;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

public class testmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 TimeZone tz = TimeZone.getTimeZone("UTC");
         DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
         df.setTimeZone(tz);
         String dateAsISO = df.format(new Date());
         String dateAsISOAppended = dateAsISO+"+07:00";
         System.out.println(dateAsISO+"+07:00");
		
	}

}
