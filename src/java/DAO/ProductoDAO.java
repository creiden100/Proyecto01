/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.Cliente;
import entidades.Producto;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author GAEA
 */
public class ProductoDAO {
    
    private static RandomAccessFile ProductoDB;
   
           public ProductoDAO() throws FileNotFoundException{
            this.ProductoDB = new RandomAccessFile("Producto.txt", "rw");
            File file = new File("Producto.txt");
            System.out.println(file.getAbsolutePath());
            
    } 
           
           public static boolean insertar(Producto producto) throws IOException{
        System.out.println("--------------------------------------------------");
       long posicionMemoria=0;
      
       if(ProductoDB!=null){
           System.out.println("2------------------------------------------");
        posicionMemoria = ProductoDAO.ProductoDB.length();
        
     }else{
            ProductoDB = new RandomAccessFile("Producto.txt", "rw");
            File file = new File("Producto.txt");
            System.out.println(file.getAbsolutePath());
       
       }
        
        System.out.println("pos memo"+ProductoDAO.ProductoDB.length());
        System.out.println(producto);
        ProductoDAO.ProductoDB.seek(posicionMemoria);
       //reservado para nombre 
       
       if(producto.getNombre().length<10){
           for(int i = 0;i <producto.getNombre().length ; i++){
            
          char letra = producto.getNombre()[i];
          ProductoDAO.ProductoDB.writeChar(letra);
        }
             for(int i = producto.getNombre().length;i <10 ; i++){
            
          
          ProductoDAO.ProductoDB.writeChar(' ');
        }
           
       }else{
        for(int i = 0;i <10 ; i++){
            
          char letra = producto.getNombre()[i];
          ProductoDAO.ProductoDB.writeChar(letra);
        }
       }
       
        //reservado para tipo
        if(producto.getTipo().length<10){
           for(int i = 0;i <producto.getTipo().length ; i++){
            
          char letra = producto.getTipo()[i];
          ProductoDAO.ProductoDB.writeChar(letra);
        }
             for(int i = producto.getTipo().length;i <10 ; i++){
            
          
          ProductoDAO.ProductoDB.writeChar(' ');
        }
           
       }else{
        for(int i = 0;i <10 ; i++){
            
          char letra = producto.getTipo()[i];
          ProductoDAO.ProductoDB.writeChar(letra);
        }
       }
        
        //reservado para UnidadMedida
        if(producto.getUnidadMedida().length<2){
           for(int i = 0;i <producto.getTipo().length ; i++){
            
          char letra = producto.getUnidadMedida()[i];
          ProductoDAO.ProductoDB.writeChar(letra);
        }
             for(int i = producto.getUnidadMedida().length;i <2 ; i++){
            
          
          ProductoDAO.ProductoDB.writeChar(' ');
        }
           
       }else{
        for(int i = 0;i <2 ; i++){
            
          char letra = producto.getUnidadMedida()[i];
          ProductoDAO.ProductoDB.writeChar(letra);
        }
       }
      
        ProductoDAO.ProductoDB.writeInt(producto.getCantidad());
        ProductoDAO.ProductoDB.writeInt(producto.getTamano());
        ProductoDAO.ProductoDB.writeInt(producto.getPrecio_compra());
        ProductoDAO.ProductoDB.writeInt(producto.getPrecio_venta());
        ProductoDAO.ProductoDB.writeInt(producto.getGanancia());

        return true;
    }
           
    public Map<Integer, Producto> listarTodo() throws IOException{
        Map<Integer,Producto> productos  = new HashMap<>();
                        
        for(long i = 0; i< this.ProductoDB.length();i= i + 64){
            
           this.ProductoDB.seek(i);
           int id=this.ProductoDB.readInt();
           System.out.println("id "+id);
           char Nombre[] = new char[10];
           for(int j = 0;j <Nombre.length ; j++){
              Nombre[j] = ProductoDAO.ProductoDB.readChar();
           }
           char tipo[] = new char[10];
           for(int j = 0;j <tipo.length ; j++){
              tipo[j] = ProductoDAO.ProductoDB.readChar();
           }
           char UnidadMedida[] = new char[2];
           for(int j = 0;j <UnidadMedida.length ; j++){
              tipo[j] = ProductoDAO.ProductoDB.readChar();
           }
           
           /*
         PROBLEMA 2 NO ESTABAN  GARANTIZANDO QUE SE LEÍA SIEMPRE LA MISMA CANTIDAD DE BYTES. OJO
        SI NO LO GARANTIZAN SE DESCUADRA. DADO QUE EL CONTEO DE BYTES NO FUNCIONARÍA
        */
           
           int tamaño =this.ProductoDB.readInt();
           int cantidad =this.ProductoDB.readInt();
           int precioCompra =this.ProductoDB.readInt();
           int PrecioVenta =this.ProductoDB.readInt();
           int Ganancia =this.ProductoDB.readInt();
          
           System.out.println("creando Producto");
           Producto p=new Producto(Nombre,tipo,UnidadMedida,tamaño,cantidad,precioCompra,PrecioVenta,Ganancia);
           productos.put(id, p);
           
         
       }
       return productos;
    }
    
    public void destructor() throws IOException{
      this.ProductoDB.close();
    }
}
