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

public class CalendarMainTest {
	//@Test
	/*public void test01() throws Throwable {
		CalendarMain.diagnose = true;
		CalendarMain.main(null);
		assertEquals(true, CalendarMain.diagnose);
		
		CalendarMain.diagnose = false;
		assertEquals(false, CalendarMain.diagnose);
		CalendarMain.main(null);
		assertEquals(false, CalendarMain.diagnose);
	}*/
	
	@Test
	public void test02() throws Throwable {
		CalendarMain.main(null);
	}
}