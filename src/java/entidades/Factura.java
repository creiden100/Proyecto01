/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author raar
 */
public class Factura {
    private Date fecha_compra;
    private ArrayList<Producto> productos=new ArrayList();
    private int abono;
    private int valorTotal;

    public Factura(int abono, int valorTotal) {
        this.abono = abono;
        this.valorTotal = valorTotal;
    }
    
    

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

   

    public int getAbono() {
        return abono;
    }

    public void setAbono(int abono) {
        this.abono = abono;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }
    public int GetGanancia(){
    int valor=0;
    for(int i=0; i<productos.size();i++){
    valor+=(productos.get(i).getGanancia()*productos.get(i).getCantidad());
    
    }
        return valor;
    }

    boolean entre(Date fecha_inicial, Date fecha_final) {
        boolean van=false;
        if ((fecha_compra.getYear()>=fecha_inicial.getYear())&&(fecha_compra.getYear()<=fecha_final.getYear())){
            if ((fecha_compra.getMonth()>=fecha_inicial.getMonth())&&(fecha_compra.getMonth()<=fecha_final.getMonth())){
                if ((fecha_compra.getDay()>=fecha_inicial.getDay())&&(fecha_compra.getDay()<=fecha_final.getDay())){
                    van=true;
                }
            }
        }
        return van;
    }
}
