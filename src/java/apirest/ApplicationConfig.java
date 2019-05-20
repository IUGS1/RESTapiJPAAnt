/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apirest;

import java.util.Set;
import javax.ws.rs.core.Application;


/**
 *
 * @author Ivan Guzman
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
    
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(apirest.ArrayListProbeResource.class);
        resources.add(apirest.DateProbeResource.class);
        resources.add(apirest.GenericResource.class);
        resources.add(apirest.JsonResource.class);
        resources.add(apirest.ResponseResource.class);
        resources.add(apirest.WithoutAnnotationsResource.class);
        
    }
    
}
