package apirest;

import javax.ws.rs.Path;
import javax.ws.rs.GET;

// I have proved  without annotations and it doesn't work.
@Path("WithoutAnnotationsResource")
public class WithoutAnnotationsResource {
    
    @GET @Path("getString")
    public String getString() {           
        return "It works";
    }
    
}
