/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package ws;

import entidades.Cliente;
import entidades.Pedido;
import entidades.Producto;
import interfaces.IFachadaPersistencia;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import logica.FachadaPersistencia;

/**
 * REST Web Service
 *
 * @author Usuario
 */
@Path("producto")
public class ProductoResource {
    IFachadaPersistencia fp;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductoResource
     */
    public ProductoResource() {
        fp = new FachadaPersistencia();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductos() {
        List<Producto> productos = fp.getProductos();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(productos.toArray(new Producto[productos.size()])).build();
    }  
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducto(@PathParam("id") int id) {
        Producto p = fp.getProducto(id);
        return Response.status(200).entity(p).build();
    }
}
