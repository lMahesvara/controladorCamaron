/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import conexiones.ConexionBD;
import entidades.Cliente;
import entidades.Pedido;
import entidades.Producto;
import interfaces.IFachadaPersistencia;
import interfaces.IModeloCliente;
import interfaces.IModeloPedido;
import interfaces.IModeloProducto;
import java.util.List;
import modelos.ModeloCliente;
import modelos.ModeloPedido;
import modelos.ModeloProducto;

/**
 *
 * @author tonyd
 */
public class FachadaPersistencia implements IFachadaPersistencia{
    ConexionBD conexion = new ConexionBD();
    IModeloPedido mpedido;
    IModeloCliente mcliente;
    IModeloProducto mproducto;

    public FachadaPersistencia() {
        this.mpedido = new ModeloPedido(conexion);
        this.mcliente = new ModeloCliente(conexion);
        this.mproducto = new ModeloProducto(conexion);
    }
    @Override
    public Pedido getPedidoById(int i) {
        return mpedido.consultar(i);
    }

    @Override
    public List<Pedido> getPedidos() { 
        return mpedido.consultar();
    }

    @Override
    public void deletePedido(Pedido pedido) {
        mpedido.eliminar(pedido);
    }

    @Override
    public Pedido actualizarPedido(Pedido pedido) {
        return mpedido.actualizar(pedido);
    }

    @Override
    public Pedido addPedido(Pedido pedido) {
        return mpedido.registrar(pedido);
    }

    @Override
    public Cliente getCliente(int id) {
        return mcliente.consultar(id);
    }

    @Override
    public List<Cliente> getClientes() {
        return mcliente.consultar();    
    }

    @Override
    public Producto getProducto(int id) {
        return mproducto.consultar(id);
    }

    @Override
    public List<Producto> getProductos() {
        return mproducto.consultar();
    }
    
}
