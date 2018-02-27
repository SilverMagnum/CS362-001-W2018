package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
    /*
    ** Generate Random Tests that tests CalDay Class.
    **/
	@Test
	public void randomTest() throws Throwable {
		long randomseed = System.currentTimeMillis(); //10
		//System.out.println(" Seed:"+randomseed );
		Random random = new Random(randomseed);
		
		int maxTests = ValuesGenerator.getRandomIntBetween(random, 1024, 2048);
		
		for(int testIndex = 0; testIndex < maxTests; testIndex++) {
			int startHour =		ValuesGenerator.getRandomIntBetween(random, -1, 25);
			int startMinute =	ValuesGenerator.getRandomIntBetween(random, -1, 61);
			int startDay =		ValuesGenerator.getRandomIntBetween(random, -1, 32);
			int startMonth =	ValuesGenerator.getRandomIntBetween(random, 0, 11);
			int startYear =		ValuesGenerator.RandInt(random);
			String title =		"Birthday Party";
			String description ="This is my birthday party.";
			
			//Construct a new Appointment object with the initial data	 
			Appt appt = new Appt(
				startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description
			);
			GregorianCalendar day = new GregorianCalendar(2015, 8, 25);
			CalDay myCalDay = new CalDay(day);
		
			myCalDay.addAppt(appt);
		}
		
		for(int testIndex = 0; testIndex < maxTests; testIndex++) {
			GregorianCalendar day = new GregorianCalendar(2015, 8, 25);
			CalDay myCalDay = new CalDay(day);
			
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
				
				myCalDay.addAppt(appt);
			}
		}
	}
}
