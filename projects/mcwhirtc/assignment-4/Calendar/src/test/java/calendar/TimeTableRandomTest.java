package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

/*
** Random Test Generator  for TimeTable class.
*/

public class TimeTableRandomTest {
    /*
    ** Generate Random Tests that tests TimeTable Class.
    */

	@Test
	public void randomTest() throws Throwable {
		long randomseed = System.currentTimeMillis(); //10
		//System.out.println(" Seed:"+randomseed );
		Random random = new Random(randomseed);
		
		int maxTests = ValuesGenerator.getRandomIntBetween(random, 1024, 2048);
		
		for(int testIndex = 0; testIndex < maxTests; testIndex++) {
			GregorianCalendar day = new GregorianCalendar(2015, 8, 25);
			CalDay myCalDay = new CalDay(day);
			TimeTable ttDuo	= new TimeTable();
			ttDuo.deleteAppt(null, null);
			ttDuo.deleteAppt(myCalDay.appts, null);
			
			Appt badAppt = new Appt(4, 100, 4, 4, 2015, "meme", "gag");
			ttDuo.deleteAppt(myCalDay.appts, badAppt);
			
			for(int i = 0; i < 5; i++) {
				int startHour =		ValuesGenerator.getRandomIntBetween(random, 0, 23);
				int startMinute =	ValuesGenerator.getRandomIntBetween(random, 0, 59);
				int startDay =		ValuesGenerator.getRandomIntBetween(random, 1, 28);
				int startMonth =	ValuesGenerator.getRandomIntBetween(random, 0, 11);
				int startYear =		ValuesGenerator.RandInt(random);
				String title =		"Birthday Party";
				String description ="This is my birthday party.";
				
				Appt appt = new Appt(
					startHour,
					startMinute,
					startDay,
					startMonth,
					startYear,
					title,
					description
				);
				
				ttDuo.deleteAppt(null, appt);
				myCalDay.addAppt(appt);
				ttDuo.deleteAppt(myCalDay.appts, appt);
			}
			
			LinkedList<Appt> badAppts = new LinkedList<Appt>();
			badAppts.add(badAppt);
			
			GregorianCalendar lastDay = new GregorianCalendar(10, 8, 25);
			GregorianCalendar firstDay = new GregorianCalendar(1, 8, 25);
			//ttDuo.getApptRange(myCalDay.appts, lastDay, firstDay);
			ttDuo.getApptRange(badAppts, firstDay, lastDay);
			ttDuo.getApptRange(myCalDay.appts, firstDay, lastDay);
		}
	}
}
