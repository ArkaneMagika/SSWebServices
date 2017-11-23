package biz.gsubiztech.SSwebservices.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Hello, Heroku!";
    }
//    @PUT
//    @Consumes(MediaType.TEXT_PLAIN)
//    public String putEmail(String email){
//        return email;
//    }
//    
//    @PUT
//    @Consumes()
//    public String putPhone(String phone){
//        return phone;
//    }
//    
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getEmail(){
//        return "Email";
//    }
//    
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getPhone(){
//        return "Phone";
//    }
}
