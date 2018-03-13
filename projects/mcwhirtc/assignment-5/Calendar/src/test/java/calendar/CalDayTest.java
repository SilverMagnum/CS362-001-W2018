package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalDayTest {
	@Test
	public void test01() throws Throwable {
		CalDay badCalDay = new CalDay();
		GregorianCalendar today = new GregorianCalendar(2018, 1, 15);
		CalDay calDay = new CalDay(today);
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		
		assertTrue(calDay.isValid());
		assertEquals(null, badCalDay.iterator());
		assertEquals(listAppts, calDay.getAppts());
		assertEquals(0, calDay.getSizeAppts());
		assertEquals(15, calDay.getDay());
		assertEquals(1, calDay.getMonth());
		assertEquals(2018, calDay.getYear());
	}
	
	@Test
	public void test02() throws Throwable {
		GregorianCalendar today = new GregorianCalendar(2018, 1, 15);
		CalDay calDay = new CalDay(today);
		Appt appt = new Appt(
			21,							//Hour
			30,							//Minute
		    16,							//Day
		    1,							//Month
		    2018,						//Year
		    "Birthday Party",			//Title
		    "This is my birthday party"	//Description
		);
		
		calDay.addAppt(appt);
	}
	
	@Test
	public void test03() throws Throwable {
		GregorianCalendar today = new GregorianCalendar(2018, 1, 15);
		CalDay calDay = new CalDay(today);
		
		calDay.toString();
	}
}