
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
}
