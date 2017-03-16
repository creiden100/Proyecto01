/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import entidades.Factura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author raar
 */
public class FacturaDAO {
     
    
    private static RandomAccessFile FacturaDB;
   
           public FacturaDAO() throws FileNotFoundException{
            this.FacturaDB = new RandomAccessFile("Factura.txt", "rw");
            File file = new File("Factura.txt");
            System.out.println(file.getAbsolutePath());
            
    } 
           
           public static boolean insertar(Factura factura) throws IOException{
        System.out.println("--------------------------------------------------");
       long posicionMemoria=0;
      
       if(FacturaDB!=null){
           System.out.println("2------------------------------------------");
        posicionMemoria = FacturaDAO.FacturaDB.length();
        
     }else{
            FacturaDB = new RandomAccessFile("Factura.txt", "rw");
            File file = new File("Factura.txt");
            System.out.println(file.getAbsolutePath());
       
       }
        
        System.out.println("pos memo"+FacturaDAO.FacturaDB.length());
        System.out.println(factura);
        FacturaDAO.FacturaDB.seek(posicionMemoria);
       
        
        FacturaDAO.FacturaDB.writeInt(factura.getAbono());
        FacturaDAO.FacturaDB.writeInt(factura.getValorTotal());

        return true;
    }
           
    public Map<Integer, Factura> listarTodo() throws IOException{
        Map<Integer,Factura> facturas  = new HashMap<>();
                        
        for(long i = 0; i< this.FacturaDB.length();i= i + 86){
            
           this.FacturaDB.seek(i);
           int id=this.FacturaDB.readInt();
           System.out.println("id "+id);
           
           
           
           /*
         PROBLEMA 2 NO ESTABAN  GARANTIZANDO QUE SE LEÍA SIEMPRE LA MISMA CANTIDAD DE BYTES. OJO
        SI NO LO GARANTIZAN SE DESCUADRA. DADO QUE EL CONTEO DE BYTES NO FUNCIONARÍA
        */
           
           int abono =this.FacturaDB.readInt();
           int valorTotal =this.FacturaDB.readInt();
           
          
           System.out.println("creando Factura");
           Factura p=new Factura(abono, valorTotal);
           facturas.put(id, p);
           
         
       }
       return facturas;
    }
    
    public void destructor() throws IOException{
      this.FacturaDB.close();
    }

}
