/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Cliente;
import entidades.Pedido;
import entidades.Producto;
import java.util.List;

/**
 *
 * @author tonyd
 */
public interface IFachadaPersistencia {
    public Pedido getPedidoById(int id);
    public List<Pedido> getPedidos();
    public void deletePedido(Pedido pedido);
    public Pedido actualizarPedido(Pedido p);
    public Pedido addPedido(Pedido p);
    public Cliente getCliente(int id);
    public List<Cliente> getClientes();
    public Producto getProducto(int id);
    public List<Producto> getProductos();
}
