/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author raar
 */
public class Cliente {
    private int[] celular=new int[10];
    private int[] telefono=new int[7];
    private int saldo=0;
    private char[] direccion=new char[30];
    private char[] Nombre=new char[10];
    ArrayList<Factura> facturas=new ArrayList<>();

    public Cliente(char[] Nombre, char[] direccion, int[] telefono, int[] celular, int saldo) {
        this.Nombre = Nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "celular=" + celular + ", telefono=" + telefono + ", saldo=" + saldo + ", direccion=" + direccion + ", Nombre=" + Nombre + '}';
    }    

    public int[] getCelular() {
        return celular;
    }

    public void setCelular(int[] celular) {
        this.celular = celular;
    }

    public int[] getTelefono() {
        return telefono;
    }

    public void setTelefono(int[] telefono) {
        this.telefono = telefono;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public char[] getDireccion() {
        return direccion;
    }

    public void setDireccion(char[] direccion) {
        this.direccion = direccion;
    }

    public char[] getNombre() {
        return Nombre;
    }

    public void setNombre(char[] Nombre) {
        this.Nombre = Nombre;
    }

    

    public ArrayList<Factura> getPedidos() {
        return facturas;
    }

    public void setPedidos(ArrayList<Factura> pedidos) {
        this.facturas = pedidos;
    }

    public ArrayList<Factura> getfacturas(Date fecha_inicial, Date fecha_final) {
       ArrayList<Factura> f= new ArrayList();
        for(int i=0;i<facturas.size();i++){
            if(facturas.get(i).entre(fecha_inicial, fecha_final)){
            f.add(facturas.get(i));
            } 
       }
        
        
        return f;
    }
}
