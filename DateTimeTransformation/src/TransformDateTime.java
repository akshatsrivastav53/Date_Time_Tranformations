import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TransformDateTime {

        
        public static String FormatDateandTimezone(Date dateTime, String format,
                        String timeZone) {
                // check null 
                if (dateTime == null) return null;
                // create SimpleDateFormat object with input format
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                // default system timezone if passed null or empty
                if (timeZone == null || "".equalsIgnoreCase(timeZone.trim())) {
                        timeZone = Calendar.getInstance().getTimeZone().getID();
                }
                // set timezone to SimpleDateFormat
                sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
                // return Date in required format with timezone as String
                return sdf.format(dateTime);
        }

        public static void main(String[] args) throws ParseException {
                //Test FormatDateandTimezone method
        	    String testDateString1="03/03/2021 08:00:00";
        	    String testDateString2 = "24-03-2021 23:37:50";
        	    DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        	    DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        	    Date dateTime = df2.parse(testDateString2);
        	    Date dateTime1= df1.parse(testDateString1);
                System.out.println("Date: " + dateTime);
                System.out.println("Date in dd-MM-yyyy HH:mm:ss format is: "+df2.format(dateTime));
                //Date dateTime = new Date();
                System.out.println("Default Date:"+dateTime.toString());
                System.out.println("System Date:"+FormatDateandTimezone(dateTime, "dd MMM yyyy hh:mm:ss a", null));
                System.out.println("System Date in PST:"+FormatDateandTimezone(dateTime, "dd MMM yyyy hh:mm:ss a", "PST"));
                System.out.println("System Date in IST:"+FormatDateandTimezone(dateTime, "dd MMM yyyy hh:mm:ss a", "IST"));
                System.out.println("System Date in GMT:"+FormatDateandTimezone(dateTime, "dd MMM yyyy hh:mm:ss a", "GMT"));
                System.out.println("System Date in CST:"+FormatDateandTimezone(dateTime, "dd MMM yyyy hh:mm:ss a", "CST"));
                System.out.println("getting week with Date time :"+getWeekOfDay(dateTime1));
        }
// The below code is the part of new requirement to get week.
		private static String getWeekOfDay(Date dateTime1) {
			// TODO Auto-generated method stub
			
			Calendar cal = Calendar.getInstance();
		    cal.setTime(dateTime1);
		    String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		    String week =days[cal.get(Calendar.DAY_OF_WEEK) - 1];
		  
		    DateFormat date = new SimpleDateFormat("MM/dd/yyyy");
	        DateFormat time = new SimpleDateFormat("hh:mm:ss");
	        
	        String timeOnly = time.format(dateTime1);
	        String dateOnly = date.format(dateTime1);
	        
	        String getWeek = dateOnly+" "+ week +" "+timeOnly;
	       
	        return getWeek;
		}

}
