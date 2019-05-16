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
            
            String anotherFormat = "yyyyMMdd";
            SimpleDateFormat anotherDf = new SimpleDateFormat(anotherFormat);
            String strGotFromDate = anotherDf.format(myDate);
            
            response = "This is the format string that I´ve got: " + strGotFromDate;
            
        } catch (ParseException e) {
            response = "Fail";
        }
        
        return response;
        
    }
}
