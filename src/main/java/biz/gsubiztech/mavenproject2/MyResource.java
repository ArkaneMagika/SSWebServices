package biz.gsubiztech.mavenproject2;

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
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putIt(String email, String phone){
        String user_email = email;
        String user_phone = phone;
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public void getEmail(){
        String email = "";
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public void getPhone(){
        String phone = "";
    }
}
