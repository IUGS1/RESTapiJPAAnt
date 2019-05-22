/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apirest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 * @author Ivan Guzman
 */
@Path("generic")
public class GenericResource {
    
    @Context
    private UriInfo context;
    
    public GenericResource() {
    }
    
    @GET @Path("getHtml")
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {   
        
        JPAExample example = new JPAExample();
        Student student1 = example.saveStudent("David");
        Student student2 = example.saveStudent("Reyna");
        
        return "<html><body><h1>After Sucessfully insertion</body></h1></html>";
    }
    
    @GET @Path("queryStudentNames")
    @Produces(MediaType.TEXT_PLAIN)
    public String queryStudentNames() {   
        
        JPAExample example = new JPAExample();
        List<String> studentNames = example.queryStudentsWithSameName("David");
        System.out.print("The number of students with the same name is: " + studentNames.size());
        
        return "After Sucessfully query.";
    }
    
    @GET @Path("getHtmlAnother")
    @Produces(MediaType.TEXT_HTML)
    public String getHtmlAnother() {           
        return "<html><body><h1>getHtmlAnother</body></h1></html>";
    }
    
    @GET @Path("getHtmlAnotherAgain")
    @Produces(MediaType.TEXT_HTML)
    public String getHtmlAnotherAgain() {           
        return "<html><body><h1>getHtmlAnotherAgain</body></h1> </html>";
    }
    
}
