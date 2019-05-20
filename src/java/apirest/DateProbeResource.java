/*
    Date
    The class Date represents a specific instant in time, with millisecond precision.

    Prior to JDK 1.1, the class Date had two additional functions. It allowed the interpretation of dates as year, 
    month, day, hour, minute, and second values. It also allowed the formatting and parsing of date strings. 
    Unfortunately, the API for these functions was not amenable to internationalization. As of JDK 1.1, the Calendar 
    class should be used to convert between dates and time fields and the DateFormat class should be used to format and 
    parse date strings. The corresponding methods in Date are deprecated.
    Extracted from: https://docs.oracle.com/javase/8/docs/api/java/util/Date.html

    SimpleDateFormat
    SimpleDateFormat allows you to start by choosing any user-defined patterns for date-time formatting.
    Extracted from: https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html


*/
package apirest;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Calendar;
import java.time.Duration;


@Path("DateProbe") 
public class DateProbeResource {
    
    @GET @Path("probe")
    @Produces(MediaType.TEXT_PLAIN)
    public String probe() {
        String response;
        
        try {
            String format = "yyyy/MM/dd";
            SimpleDateFormat df = new SimpleDateFormat(format);
            String strToParse = "2019/05/13";
            Date myDate = df.parse(strToParse);
            
            response = "I was parsable: " + myDate.toString();
            
        } catch (ParseException e) {
            response = "It was not parsable";
        }
        
        return response;
        
    }
    
    @GET @Path("dateFormat")
    @Produces(MediaType.TEXT_PLAIN)
    public String dateFormat() {
        String response;
        
        try {
            String format = "yyyy/MM/dd";
            SimpleDateFormat df = new SimpleDateFormat(format);
            String strToParse = "2019/05/13";
            Date myDate = df.parse(strToParse);
            
            String anotherFormat = "yyyy/MM/dd";
            SimpleDateFormat anotherDf = new SimpleDateFormat(anotherFormat);
            String strGotFromDate = anotherDf.format(myDate);
            String strMaxValue = anotherDf.format(new Date(Long.MAX_VALUE));
            String strMinValue = anotherDf.format(new Date(0));
            
            response = "This is the format string that I´ve got: " + strGotFromDate;
            response = response + "     This is the max value: " + strMaxValue;
            response = response + "     This is the min value: " + strMinValue;
            
            
        } catch (ParseException e) {
            response = "Fail";
        }
        
        return response;   
    }
    
    @GET @Path("calendar")
    @Produces(MediaType.TEXT_PLAIN)
    public String calendar() {
        String response;
        
        try {
            String format = "yyyy/MM/dd-HH-mm-ss";
            SimpleDateFormat df = new SimpleDateFormat(format);
            
            Date d1 = df.parse("2019/05/13-04-15-45");
            Date d2 = df.parse("2019/05/13-01-45-12");
            
            System.out.print(d1);
            System.out.print(d2);
            
            /* This is the process to reset the time * /
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
                        
            c1.setTime(d1);
            c2.setTime(d2);
            
            c1.set(Calendar.HOUR, 0);
            c1.set(Calendar.MINUTE, 0);
            c1.set(Calendar.SECOND, 0);
            
            c2.set(Calendar.HOUR, 0);
            c2.set(Calendar.MINUTE, 0);
            c2.set(Calendar.SECOND, 0);
            /* */
            
            d1 = DateProbeResource.dateDate(d1);
            d2 = DateProbeResource.dateDate(d2);
              
            System.out.print(d1);
            System.out.print(d2);
            
            if (d1.equals(d2)) {
                response = "True";
            } else {
                response = "false";
            }
            
        } catch (ParseException e) {
            response = "It was problem";
        }
        
        return response;
        
    }
    
    public static Date dateDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        
        return cal.getTime();
    }
    
    @GET @Path("duration")
    @Produces(MediaType.TEXT_PLAIN)
    public String duration() {
        String response;
        
        try {
            String format = "yyyy/MM/dd-HH-mm-ss";
            SimpleDateFormat df = new SimpleDateFormat(format);
            
            Date d1 = df.parse("2019/05/10-00-45-12");
            Date d2 = df.parse("2019/05/13-00-45-12");
            
            System.out.print("This is date 1: " + d1);
            System.out.print("This is date 2: " + d2);
            
            Duration duration = Duration.between(d1.toInstant(), d2.toInstant());
            
            System.out.print("The duration between both dates in minutes: " + duration.toMinutes());
            
            response = "Succesful.";
            
        } catch (ParseException e) {
            response = "It was problem.";
        }
        
        return response;
    }
}
