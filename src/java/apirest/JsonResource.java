/*
    Jakarta API for JSON Processing provides portable APIs to parse, generate, transform, and query JSON documents. The 
    project is an evolution of JSR-374 under Jakarta EE umbrella and contains API and a compatible implementation.
    Extracted from: https://github.com/eclipse-ee4j/jsonp
    
    Jakarta API for JSON Processin is a component of Eclipse GlassFish:
    https://wiki.eclipse.org/Eclipse_GlassFish_5.1_Components_Release_Tracker

    This Resource was based on the demos of the jsonp project: 
    https://github.com/eclipse-ee4j/jsonp/tree/master/demos/jaxrs/src/main/java/org/glassfish/jsondemos/jaxrs

    I have tasted this Resource with the next JSON in postman:
    {
        "strId":"Ivan",
        "strName":"Ivancito",
	"strDateStart":"2019/05/13"
    }
*/

package apirest;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.json.JsonObject;

import javax.ws.rs.core.MediaType;

@Path("JsonResource")
public class JsonResource {
    
    @POST
    @Path("json")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String test( //
            JsonObject json
            ) {
        System.out.print("You've just received the next JSON");
        
        if(!json.containsKey("strId")) {
            System.out.print("strId: null");
        }
        if(json.containsKey("strName")) {
            System.out.print("strName: " + json.getString("strName"));
        }
        if(json.containsKey("strDateStart")) {
            System.out.print("strDateStart: " + json.getString("strDateStart"));
        }
        
        return "Probe JSON";
    }
    
}
