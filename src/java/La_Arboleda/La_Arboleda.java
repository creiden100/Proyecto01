/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package La_Arboleda;

import entidades.Cliente;
import entidades.Factura;
import entidades.Producto;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author raar
 */
public class La_Arboleda {
private ArrayList<Producto> productos=new ArrayList();
private ArrayList<Cliente> clientes=new ArrayList();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    private boolean CrearCliente(){
        return false;
    }
    private boolean CrearCliente(String datos){
        return false;
    }
    private boolean Crearproducto(){
        return false;
    }
    private boolean Crearproducto(String daots){
        return false;
    }
    private int GananciaFecha(Date fecha_inicial,Date fecha_final){
   ArrayList<Factura> facturas=new ArrayList();
        for(int i=0;i<clientes.size();i++){
            facturas.addAll(clientes.get(i).getfacturas(fecha_inicial,fecha_final));
         }
        int ganancia=0;
        for(int j=0;j<facturas.size();j++){
            ganancia+=facturas.get(j).GetGanancia();
        }
        return ganancia;
    }
    
    private boolean EditarCliente(String Cliente){
    return false;
    }
    private boolean EditarProducto(String producto){
    return false;
    }
    private boolean EliminarCliente(String Cliente){
    return false;
    }
    private boolean EliminarProducto(String producto){
    return false;
    }
    private Cliente BuscarCliente(String Cliente){
    return null;
    }
    private Producto BuscarProducto(String Producto){
    return null;
    }
    private char[] BuscarDireccion(String cliente){
    return BuscarCliente(cliente).getDireccion();
    }
}
