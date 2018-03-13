package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
 
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class TimeTableTest {
	@Test
	public void test01() throws Throwable {
		TimeTable timeTable = new TimeTable();
		
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		GregorianCalendar today = new GregorianCalendar(2018, 1, 15);
		GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH,1);
		
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);
	}

	@Test
	public void test02() throws Throwable {
		//Private function getApptOccurences
	}
	
	@Test
	public void test03() throws Throwable {
		//Private function getNextApptOccurrence
	}
	
	@Test
	public void test04() throws Throwable {
		TimeTable timeTable = new TimeTable();
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		Appt appt = new Appt(
			21,							//Hour
			30,							//Minute
		    15,							//Day
		    1,							//Month
		    2018,						//Year
		    "Birthday Party",			//Title
		    "This is my birthday party"	//Description
		);
		
		//LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		listAppts = timeTable.deleteAppt(listAppts, appt);
	}
	
	@Test
	public void test05() throws Throwable {
		TimeTable timeTable = new TimeTable();
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		int[] peeVee = new int[0];
		
		//LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		listAppts = timeTable.permute(listAppts, peeVee);
	}
}
