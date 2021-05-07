# Date_Time_Tranformations

This repo has project which transform the dataTime (String) in different formats and time zones.

First Requirement -  Input DateTime as a string and transform it in different formats and time zones like PST, IST, GMT, CST.

Additional Requirement - Add day of the week to the date time format.

Second Requirement - The second requirement change is to add a daylight-saving mode which allows adding the daylight-saving starting date time and daylight-saving ending date time. All time zones will share the same starting / ending date time. 

The also includes Junit cases to test_runner.java class to run the junit test cases TestRunner.java

testTransformDateTime.java - Java class for project code.

# Steps to Compile and run code.
1.import code from git repo to Eclipse.
2.Run the TransformDateTime.java (to format the date and time. Convert that into different time zones) as Java application.
3.Output will come in console.

#Libraries used in the programe

1. import java.text.DateFormat;
2. import java.text.ParseException;
3. import java.text.SimpleDateFormat;
4. import java.util.Calendar;
5. import java.util.Date;
6. import java.util.TimeZone;
