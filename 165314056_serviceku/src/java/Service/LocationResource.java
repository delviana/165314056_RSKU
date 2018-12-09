package Service;

import com.google.gson.Gson;
import Helper.LocationHelper;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import Pojos.Location;

/**
 * REST Web Service
 *
 * @author basisa06
 */
@Path("Location")
public class LocationResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserResource
     */
    public LocationResource() {
    }

    /**
     * Retrieves representation of an instance of User.UserResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of UserResource
     *
     * @param content representation for the resource
     */
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void putJson(String content) {
//    }
    @GET
    @Path("getLocation")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLocation() {
        LocationHelper helper = new LocationHelper();
        List<Location> list = helper.getLocation();
        Gson gson = new Gson();
        return Response.status(200)
                .entity(gson.toJson(list))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods",
                        "GET,POST,HEAD,OPTIONS,PUT")
                .header("Access-Control-Allow-Headers",
                        "Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers")
                .header("Access-Exposed-Headers",
                        "Access-Control-Allow-Origin,Access-Control-Allow-Credentials")
                .header("Access-Support-Credentials",
                        "true")
                .header("Access-Control-Max-Age", "2")
                .header("Access-Preflight-Maxage", "2")
                .build();
    }

    @POST
    @Path("addLocation")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewLocation(String data) {
        Gson gson = new Gson();
        Location location = gson.fromJson(data, Location.class);
        LocationHelper helper = new LocationHelper();
        helper.addNewLocation(location.getLat(),
                location.getLng(),
                location.getName());

        return Response
                .status(200)
                .entity(location)
                .build();
    }
}
