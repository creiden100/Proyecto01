/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author raar
 */
public class Producto {
    
    private int cantidad;
    private int tamano;
    private char[] unidadMedida=new char[2];
    private char[] tipo=new char[10];
    private int precio_compra;
    private int precio_venta;
    private char[] nombre=new char[10];

 
    public Producto(char[] Nombre, char[] tipo, char[] UnidadMedida, int tamano, int cantidad, int precioCompra, int PrecioVenta, int Ganancia) {
        this.nombre = Nombre;
        this.tipo = tipo;
        this.unidadMedida = UnidadMedida;
        this.tamano = tamano;
        this.cantidad = cantidad;
        this.precio_compra = precioCompra;
        this.precio_venta = PrecioVenta;
        
    }
    
    public Producto(char[] Nombre, char[] tipo, char[] UnidadMedida, int Cantidad, int Tamano, int Precio_compra, int Precio_venta) {
        this.nombre=Nombre;
        this.tipo=tipo;
        this.cantidad = Cantidad;
        this.unidadMedida=UnidadMedida;
        this.tamano = Tamano;
        this.precio_compra = Precio_compra;
        this.precio_venta = Precio_venta;
    }
    
    

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

   

    public int getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(int precio_compra) {
        this.precio_compra = precio_compra;
    }

    public int getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(int precio_venta) {
        this.precio_venta = precio_venta;
    }

    
    public int getGanancia() {
        return precio_compra-precio_venta;
    }

    public char[] getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(char[] unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public char[] getTipo() {
        return tipo;
    }

    public void setTipo(char[] tipo) {
        this.tipo = tipo;
    }

    public char[] getNombre() {
        return nombre;
    }

    public void setNombre(char[] nombre) {
        this.nombre = nombre;
    }
    
    
    
}
