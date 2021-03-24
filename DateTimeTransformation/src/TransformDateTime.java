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
        	    String testDateString2 = "24-03-2021 23:37:50";
        	    DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        	    Date dateTime = df2.parse(testDateString2);
                System.out.println("Date: " + dateTime);
                System.out.println("Date in dd-MM-yyyy HH:mm:ss format is: "+df2.format(dateTime));
                //Date dateTime = new Date();
                System.out.println("Default Date:"+dateTime.toString());
                System.out.println("System Date:"+FormatDateandTimezone(dateTime, "dd MMM yyyy hh:mm:ss a", null));
                System.out.println("System Date in PST:"+FormatDateandTimezone(dateTime, "dd MMM yyyy hh:mm:ss a", "PST"));
                System.out.println("System Date in IST:"+FormatDateandTimezone(dateTime, "dd MMM yyyy hh:mm:ss a", "IST"));
                System.out.println("System Date in GMT:"+FormatDateandTimezone(dateTime, "dd MMM yyyy hh:mm:ss a", "GMT"));
                System.out.println("System Date in CST:"+FormatDateandTimezone(dateTime, "dd MMM yyyy hh:mm:ss a", "CST"));
        }

}