package calendar;
/**
**	This class provides a basic set of test cases for the
**	Appt class.
**/

import org.junit.Test;
import static org.junit.Assert.*;

public class ApptTest {
    /**
    **	Test that the gets methods work as expected.
    **/
	@Test
	public void test01() throws Throwable {
		int startHour		=	21;
		int startMinute		=	30;
		int startDay		=	15;
		int startMonth		=	01;
		int startYear		=	2018;
		String title		=	"Birthday Party";
		String description	=	"This is my birthday party.";
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
		
		//assertions
		assertTrue(appt.getValid());
		assertEquals(21, appt.getStartHour());
		assertEquals(30, appt.getStartMinute());
		assertEquals(15, appt.getStartDay());
		assertEquals(01, appt.getStartMonth());
		assertEquals(2018, appt.getStartYear());
		assertEquals("Birthday Party", appt.getTitle());
		assertEquals("This is my birthday party.", appt.getDescription());         		
	}

	@Test
	public void test02() throws Throwable {
		//Construct a new Appointment object below our bounds.	 
		Appt apptLowerHourBound = new Appt(
			-1,							//Hour
		    5,							//Minute
		    5,							//Day
		    5,							//Month
		    2018,						//Year
		    "Big Bang",					//Title
		    "Creation of everything."	//Description
		);
		
		Appt apptUpperMinuteBound = new Appt(
			5,							//Hour
		    60,							//Minute
		    5,							//Day
		    5,							//Month
		    2018,						//Year
		    "Big Bang",					//Title
		    "Creation of everything."	//Description
		);
		
		Appt apptLowerDayBound = new Appt(
			5,							//Hour
		    5,							//Minute
		    0,							//Day
		    5,							//Month
		    2018,						//Year
		    "Big Bang",					//Title
		    "Creation of everything."	//Description
		);

		assertEquals(false, apptLowerHourBound.getValid());
		assertEquals(false, apptUpperMinuteBound.getValid());
		assertEquals(false, apptLowerDayBound.getValid());
	}
	
	
	@Test
	public void test03() throws Throwable {
		int startHour		=	21;
		int startMinute		=	30;
		int startDay		=	15;
		int startMonth		=	01;
		int startYear		=	2018;
		String title		=	"Birthday Party";
		String description	=	"This is my birthday party.";

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
		
		appt.setStartHour(8);
		appt.setStartMinute(15);
		appt.setStartDay(14);
		appt.setStartMonth(2);
		appt.setStartYear(2019);
		appt.setTitle(null);
		appt.setDescription(null);

		//assertions
		assertTrue(appt.getValid());
		assertEquals(8, appt.getStartHour());
		assertEquals(15, appt.getStartMinute());
		assertEquals(14, appt.getStartDay());
		assertEquals(2, appt.getStartMonth());
		assertEquals(2019, appt.getStartYear());
		assertEquals("", appt.getTitle());
		assertEquals("", appt.getDescription());
		
		appt.setTitle("Valentine's Day");
		appt.setDescription("Saddest day of the year.");
		
		assertEquals("Valentine's Day", appt.getTitle());
		assertEquals("Saddest day of the year.", appt.getDescription());
	}
	
	@Test
	public void test04() throws Throwable {
		int startHour		=	21;
		int startMinute		=	30;
		int startDay		=	15;
		int startMonth		=	01;
		int startYear		=	2018;
		int[] meme			=	new int[0];
		int[] dream			=	{1, 2, 3};
		String title		=	"Birthday Party";
		String description	=	"This is my birthday party.";

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
		
		appt.setRecurrence(dream, 8, 9, 10);
		
		assertEquals(dream, appt.getRecurDays());
		assertEquals(8, appt.getRecurBy());
		assertEquals(9, appt.getRecurIncrement());
		assertEquals(10, appt.getRecurNumber());
		assertEquals(true, appt.isRecurring());
		
		appt.setRecurrence(dream, 8, 9, 0);
		
		assertEquals(false, appt.isRecurring());
	}
	
	@Test
	public void test05() throws Throwable {
		Appt appt = new Appt(
			21,							//Hour
			30,							//Minute
		    15,							//Day
		    1,							//Month
		    2018,						//Year
		    "Birthday Party",			//Title
		    "This is my birthday party"	//Description
		);

		String textOutput = "\t1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party\n";
		
		assertEquals(textOutput, appt.toString());
		
		Appt appt2 = new Appt(
			25,							//Hour
			30,							//Minute
		    15,							//Day
		    1,							//Month
		    2018,						//Year
		    "Birthday Party",			//Title
		    "This is my birthday party"	//Description
		);
		
		assertEquals(null, appt2.toString());
		
		Appt appt3 = new Appt(
			21,							//Hour
			100,						//Minute
		    15,							//Day
		    1,							//Month
		    2018,						//Year
		    "Birthday Party",			//Title
		    "This is my birthday party"	//Description
		);
		
		assertEquals(null, appt3.toString());
		
		Appt appt4 = new Appt(
			21,							//Hour
			30,							//Minute
		    40,							//Day
		    1,							//Month
		    2018,						//Year
		    "Birthday Party",			//Title
		    "This is my birthday party"	//Description
		);
		
		assertEquals(null, appt4.toString());
		
		Appt appt5 = new Appt(
			12,							//Hour
			30,							//Minute
		    15,							//Day
		    1,							//Month
		    2018,						//Year
		    "Birthday Party",			//Title
		    "This is my birthday party"	//Description
		);
		
		String textOutput2 = "\t1/15/2018 at 12:30pm ,Birthday Party, This is my birthday party\n";
		
		assertEquals(textOutput2, appt5.toString());
		
		Appt appt6 = new Appt(
			0,							//Hour
			30,							//Minute
		    15,							//Day
		    1,							//Month
		    2018,						//Year
		    "Birthday Party",			//Title
		    "This is my birthday party"	//Description
		);
		
		String textOutput3 = "\t1/15/2018 at 12:30am ,Birthday Party, This is my birthday party\n";
		
		assertEquals(textOutput3, appt6.toString());
	}
	
	
	@Test
	public void test06() throws Throwable {
		Appt appt = new Appt(
			21,							//Hour
			30,							//Minute
		    15,							//Day
		    1,							//Month
		    2018,						//Year
		    "Birthday Party",			//Title
		    "This is my birthday party"	//Description
		);
		
		assertEquals(0, appt.compareTo(appt));
	}
}