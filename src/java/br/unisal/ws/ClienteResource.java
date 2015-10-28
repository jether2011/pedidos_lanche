/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unisal.ws;

import br.unisal.dao.GenericDao;
import br.unisal.model.Cliente;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author JETHER
 */
@Path("cliente")
public class ClienteResource {

    @Context
    private UriInfo context;
    private GenericDao dao;

    /**
     * Creates a new instance of ClienteResource
     */
    public ClienteResource() {
    }

    /** */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientes() {        
        GenericEntity<List<Cliente>> pessoas = 
                new GenericEntity<List<Cliente>>(getDao()
                        .getAll(Cliente.class)){};       
        return Response
                .ok(pessoas)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD")
                .build();
    }
    
    /**
     * Retrieves representation of an instance of br.unisal.ws.ClienteResource
     * @param id
     * @return an instance of br.unisal.model.Cliente
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCliente(@PathParam("id") Long id) {
        Cliente p = new Cliente();
        p.setId(id);
        return Response
                .ok(getDao().getById(Cliente.class, new Long(id)))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD")
                .build();
    }
    /*public Cliente getCliente(@PathParam("id") Long id) {
        Cliente p = new Cliente();
        p.setId(id);
        return getDao().getById(p);
    }*/
    
    /**
     * DELETE method for deleting an instance of ClienteResource     * 
     * @param id
     * @return message of deleted pessoa with error or not
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCliente(@PathParam("id") Long id) {
        Cliente p = new Cliente();
        p.setId(id);        
        getDao().remove(p);
        String msg = "{\"msg\":\"Exclusão realizada com sucesso!\"}";
        return Response
                .ok(msg)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD")
                .build();
    }

    /**
     * PUT method for updating or creating an instance of ClienteResource
     * @param p representation for the resource
     * @param id
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCliente(Cliente p, 
            @PathParam("id")Long id) {
        p.setId(id);
        getDao().update(p);
        String msg = "{\"msg\":\"Atualização realizada com sucesso!\"}";
        return Response
                .ok(msg)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD")
                .build();
    }
    
    /**
     * POST method for creating an instance of ClienteResource
     * 
     * @param p
     * @return 
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCliente(Cliente p) {        
        getDao().save(p);
        String msg = "{\"msg\":\"Inserção realizada com sucesso!\"}";
        return Response
                .ok(msg)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD")
                .build();
    }

    public GenericDao getDao() {
        if(dao == null){
            dao = new GenericDao();
        }
        return dao;
    }
}
