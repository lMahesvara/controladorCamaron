/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package ws;

import entidades.Pedido;
import entidades.Producto;
import interfaces.IFachadaPersistencia;
import interfaces.IModeloPedido;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import logica.FachadaPersistencia;
import modelos.ModeloPedido;

/**
 * REST Web Service
 *
 * @author Usuario
 */
@Path("pedido")
public class PedidoResource {
    IFachadaPersistencia fp;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PedidoResource
     */
    public PedidoResource() {
        fp = new FachadaPersistencia();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPedidos() {
        
        List<Pedido> pedidos = fp.getPedidos();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(pedidos.toArray(new Pedido[pedidos.size()])).build();
    }  
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPedido(@PathParam("id") int id) {
        Pedido p = fp.getPedidoById(id);
        return Response.status(200).entity(p).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPedido(Pedido pedido){
        Pedido p = fp.addPedido(pedido);
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(p).build();
    }
    
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePedido(@PathParam("id") int id) {
        //TODO return proper representation object
        Pedido p = fp.getPedidoById(id);
        
        
        if(p != null){
            fp.deletePedido(p);
           return Response.status(204).header("Access-Control-Allow-Origin", "*").entity("Pedido eliminado").build();
        } else {
            return Response.status(404).build();
        }
    } 
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePedido(Pedido pedido) {        
        System.out.println(pedido);
        
        fp.actualizarPedido(pedido);
        return Response.status(200).entity(pedido).build();
        
    }
}
