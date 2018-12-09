/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Helper.DokterHelper;
import Helper.KlinikHelper;
import Helper.PasienHelper;
import Pojos.Dokter;
import Pojos.Klinik;
import Pojos.Pasien;
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
@Path("Dokter")
public class DokterResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LocationResource
     */
    public DokterResource() {
    }

    /**
     * Retrieves representation of an instance of Service.LocationResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        //TODO return proper representation object
        DokterHelper dokter = new DokterHelper();
        List<Dokter> list = dokter.bacaSemuaDokter();
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
     * PUT method for updating or creating an instance of LocationResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    @POST
    @Path("addDokter")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewDokter(String data) {
        Gson gson = new Gson();
        Dokter dokter = gson.fromJson(data, Dokter.class);
        DokterHelper dok = new DokterHelper();
        dok.addNewDokter(dokter.getNama(), dokter.getSpesialis());

        return Response.status(200)//penting
                .entity(dokter)
                .build();//penting

    }
}
