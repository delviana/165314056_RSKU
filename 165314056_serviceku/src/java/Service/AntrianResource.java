/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Helper.AntrianHelper;
import Pojos.Antrian;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Acer
 */
@Path("Antrian")
public class AntrianResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AntrianResource
     */
    public AntrianResource() {
    }

    /**
     * Retrieves representation of an instance of Service.AntrianResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        //TODO return proper representation object
        AntrianHelper antrian = new AntrianHelper();
        List<Antrian> list = antrian.bacaSemuaAntrian();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
        return Response.status(Response.Status.OK)//penting utama
                .entity(json)//utama
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
                .build();//penting utama
    }

    /**
     * PUT method for updating or creating an instance of AntrianResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    @POST
    @Path("addAntrian")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewAntrian(String data) {
        Gson gson = new Gson();
        Antrian antrian = gson.fromJson(data, Antrian.class);
        AntrianHelper antri = new AntrianHelper();
        antri.addNewAntrian(antrian.getId(), antrian.getTanggal(), antrian.getNoRm(), antrian.getNama(), antrian.getAlamat(),
                antrian.getNamaKlinik());

        return Response.status(200)//penting
                .entity(antrian)
                .build();//penting

    }
}
