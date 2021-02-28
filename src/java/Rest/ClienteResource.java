/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Controller.ControllerRestCliente;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 * 
 * @author Giancarlo
 */
@Path("Cliente")
public class ClienteResource {

    @Context
    private UriInfo context;
    private ControllerRestCliente controller;

    /**
     * Creates a new instance of ClienteResource
     */
    public ClienteResource() {
        controller = new ControllerRestCliente();
    }

    /**
     * Retrieves representation of an instance of Rest.ClienteResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
       return controller.getClientes();
    }
    /**
     * valida Cpf
     */
    @GET
    @Path("{CPF}")
    @Produces(MediaType.APPLICATION_JSON)
    public String ValidaCpf(@PathParam("CPF") String cpf) {
       return (Componente.Utils.isCpfValido(cpf))? "{\"valido\":true}" : "{\"valido\":false}";
    }

    /**
     * PUT method for updating or creating an instance of ClienteResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
        controller.addCliente(content);
    }
}
