/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisal.ws;

import br.unisal.model.Operacao;
import java.io.Serializable;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author JETHER
 */
@Path("calc")
public class CalcResource implements Serializable {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CalcResource
     */
    public CalcResource() {
    }

    /**
     * Retrieves representation of an instance of br.unisal.ws.CalcResource
     *
     * @param v1
     * @param v2
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("soma/{v1}/{v2}")
    public Response getSoma(@PathParam("v1") String v1,
            @PathParam("v2") String v2) {
        Operacao o = new Operacao();
        o.setV1(new Double(v1));
        o.setV2(new Double(v2));
        o.soma();
        return Response.ok(o).build();
    }
    
    /**
     * Retrieves representation of an instance of br.unisal.ws.CalcResource
     *
     * @param v1
     * @param v2
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("subtracao/{v1}/{v2}")
    public Response getSubtracao(@PathParam("v1") String v1,
            @PathParam("v2") String v2) {
        Operacao o = new Operacao();
        o.setV1(new Double(v1));
        o.setV2(new Double(v2));
        o.subtracao();
        return Response.ok(o).build();
    }
    
    /**
     * Retrieves representation of an instance of br.unisal.ws.CalcResource
     *
     * @param v1
     * @param v2
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("multiplicacao/{v1}/{v2}")
    public Response getMultiplicacao(@PathParam("v1") String v1,
            @PathParam("v2") String v2) {
        Operacao o = new Operacao();
        o.setV1(new Double(v1));
        o.setV2(new Double(v2));
        o.multiplicacao();
        return Response.ok(o).build();
    }
    
    /**
     * Retrieves representation of an instance of br.unisal.ws.CalcResource
     *
     * @param v1
     * @param v2
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("divisao/{v1}/{v2}")
    public Response getDivisao(@PathParam("v1") String v1,
            @PathParam("v2") String v2) {
        Operacao o = new Operacao();
        o.setV1(new Double(v1));
        o.setV2(new Double(v2));
        o.divisao();
        return Response.ok(o).build();
    }
    
}
