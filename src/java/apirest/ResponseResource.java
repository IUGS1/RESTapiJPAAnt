/*
    Methods decorated with request method designators must return void, a Java programming language type, or a 
    javax.ws.rs.core.Response object. Multiple parameters may be extracted from the URI by using the PathParam or 
    QueryParam annotations.
    Extracte from: https://docs.oracle.com/cd/E19798-01/821-1841/gipys/index.html

    This code was followed at: https://www.baeldung.com/jax-rs-response

    To verify the api I use curl command like:
    http://localhost:8080/RESTapiJPAAnt/webresources/Response/pojo
    
*/
package apirest;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;

@Path("Response")
public class ResponseResource {
    
    @GET @Path("/ok")
    public Response getOkResponse() {
        String message = "This is a text response.";
        
        return Response
                .status(Response.Status.OK)
                .entity(message)
                .build();
        
    }
    
    @GET @Path("/not_ok")
    public Response getNOkTextResponse() {
        String message = "There was an internal server error.";
        
        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(message)
                .build();
    }
    
    @GET @Path("/text_plain")
    public Response getTextResponseTypeDefined() {
        String message = "This is a plain text response";
        
        return Response
                .status(Response.Status.OK)
                .entity(message)
                .type(MediaType.TEXT_PLAIN)
                .build();
    }
    
    @GET @Path("/text_plain_annotation")
    @Produces({MediaType.TEXT_PLAIN})
    public Response getTextResponseTypeAnnotated() {
        String message = "This is a plain text response via annotation";
        return Response
                .status(Response.Status.OK)
                .entity(message)
                .build();
    }
    
    /*
        At this particular case the pojo attributes needed to be its respectevely getters methods
    */
    @GET @Path("/pojo")
    public Response getPojoResponse() {
        Person person = new Person();
        
        return Response
                .status(Response.Status.OK)
                .entity(person)
                .build();
    }
    
    @GET @Path("/json")
    public Response getJsonResponse() {
        String message = "{\"hello\": \"This is a JSON response\"}";
        
        return Response
                .status(Response.Status.OK)
                .entity(message)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
}
