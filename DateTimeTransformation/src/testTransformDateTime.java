import static org.junit.Assert.assertEquals;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class testTransformDateTime {
   String test1;
   String test2;
   DateFormat df2;
   DateFormat df1;
   TransformDateTime testTransform= new TransformDateTime();
 String actualTest1;
 String actualTest2;
 String actualTest3;
 String start;
 String end;
 String actualAdd;
	@Before
	 public void init() {
		 test1= "05/06/2021 22:00:00";
		  df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		 df1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		  actualTest1= "06/05/2021 Saturday 10:00:00";
		  test2="14-03-2021 15:00:50";
		  actualTest2="14 Mar 2021 01:00:50 PM";
		  actualTest3="15 Mar 2021 01:30:50 AM";
		   start = "10-03-2019 03:00:00";
		  end="03-11-2019 02:00:00";
		  actualAdd="Sun Feb 13 05:00:00 CST 4039";
		
		
	}
	@Test
	public void testFormatDateandTimezone() throws ParseException
	{
		Date date2=df2.parse(test2);
		
		String test2=testTransform.FormatDateandTimezone(date2, "dd MMM yyyy hh:mm:ss a", "PST");
		assertEquals(actualTest2, test2);
		String test3=testTransform.FormatDateandTimezone(date2, "dd MMM yyyy hh:mm:ss a", "IST");
		assertEquals(actualTest3, test3);
		
	}
	
	@Test
	public void testGetWeekOfDay() throws ParseException
	{
		Date date1=df1.parse(test1);
		String testWeek= testTransform.getWeekOfDay(date1);
		assertEquals(actualTest1, testWeek);
		
		
		
	}

	@Test
	public void testAddDayLightSavingStartAndEnd() throws ParseException
	{
		Date testStart=df2.parse(start);
		Date testEnd = df2.parse(end);
		String addTest=testTransform.addDayLightSavingStartAndEnd(testStart, testEnd);
		assertEquals(actualAdd, addTest);
		
	}
}
