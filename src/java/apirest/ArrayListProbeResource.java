
package apirest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;

@Path("ArrayListProbe") 
public class ArrayListProbeResource {
    @GET @Path("stream")
    @Produces(MediaType.TEXT_PLAIN)
    public String probe() {
        ArrayList<StringNumber> myArray = new ArrayList<>();
        
        myArray.add(new StringNumber(1, "Uno"));
        myArray.add(new StringNumber(2, "Dos"));
        myArray.add(new StringNumber(3, "Tres"));
        
        StringNumber myStringNumber = myArray
                .stream()
                .filter((StringNumber stringNumber) -> stringNumber.getNumber() == 2)
                .findAny()
                .orElse(null);
        
        System.out.print(myStringNumber);
        
        return "Succes";
    }
    
}
