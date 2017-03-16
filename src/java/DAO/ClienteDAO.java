/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import entidades.Cliente;
/**
 *
 * @author GAEA
 */
public class ClienteDAO {
    
    private static RandomAccessFile ClienteDB;
   
           public ClienteDAO() throws FileNotFoundException{
            this.ClienteDB = new RandomAccessFile("Cliente.txt", "rw");
            File file = new File("Cliente.txt");
            System.out.println(file.getAbsolutePath());
            
    } 
           
           public static boolean insertar(Cliente cliente) throws IOException{
        System.out.println("--------------------------------------------------");
       long posicionMemoria=0;
      
       if(ClienteDB!=null){
           System.out.println("2------------------------------------------");
        posicionMemoria = ClienteDAO.ClienteDB.length();
        
     }else{
            ClienteDB = new RandomAccessFile("Cliente.txt", "rw");
            File file = new File("Cliente.txt");
            System.out.println(file.getAbsolutePath());
       
       }
        
        System.out.println("pos memo"+ClienteDAO.ClienteDB.length());
        System.out.println(cliente);
        ClienteDAO.ClienteDB.seek(posicionMemoria);
       //reservado para nombre 
        //char letra[] = {'a','e','i','a','e','i','a','e','i','j'};
        if(cliente.getNombre().length<10){
           for(int i = 0;i <cliente.getNombre().length ; i++){
            
          char letra = cliente.getNombre()[i];
          ClienteDAO.ClienteDB.writeChar(letra);
        }
             for(int i = cliente.getNombre().length;i <10 ; i++){
            
          
          ClienteDAO.ClienteDB.writeChar(' ');
        }
           
       }else{
        for(int i = 0;i <10 ; i++){
            
          char letra = cliente.getNombre()[i];
          ClienteDAO.ClienteDB.writeChar(letra);
        }
       }
        
        if(cliente.getDireccion().length<30){
           for(int i = 0;i <cliente.getNombre().length ; i++){
            
          char letra = cliente.getNombre()[i];
          ClienteDAO.ClienteDB.writeChar(letra);
        }
             for(int i = cliente.getDireccion().length;i <30 ; i++){
            
          
          ClienteDAO.ClienteDB.writeChar(' ');
        }
           
       }else{
        for(int i = 0;i <10 ; i++){
            
          char letra = cliente.getNombre()[i];
          ClienteDAO.ClienteDB.writeChar(letra);
        }
       }
       
        //reservado para direccion
        for (int i = 0; i < cliente.getTelefono().length; i++) {
            ClienteDAO.ClienteDB.writeInt(cliente.getTelefono()[i]); 
        }
        for (int i = 0; i < cliente.getCelular().length; i++) {
            ClienteDAO.ClienteDB.writeInt(cliente.getCelular()[i]); 
        }
        
        ClienteDAO.ClienteDB.writeInt(cliente.getSaldo());

        return true;
    }
           
    public Map<Integer, Cliente> listarTodo() throws IOException{
        Map<Integer,Cliente> clientes  = new HashMap<>();
                        
        for(long i = 0; i< this.ClienteDB.length();i= i + 86){
            
           this.ClienteDB.seek(i);
           int id=this.ClienteDB.readInt();
           System.out.println("id "+id);
           char Nombre[] = new char[30];
           for(int j = 0;j <Nombre.length ; j++){
              Nombre[j] = ClienteDAO.ClienteDB.readChar();
           }
           char direccion[] = new char[10];
           for(int j = 0;j <direccion.length ; j++){
              direccion[j] = ClienteDAO.ClienteDB.readChar();
           }
           
           /*
         PROBLEMA 2 NO ESTABAN  GARANTIZANDO QUE SE LEÍA SIEMPRE LA MISMA CANTIDAD DE BYTES. OJO
        SI NO LO GARANTIZAN SE DESCUADRA. DADO QUE EL CONTEO DE BYTES NO FUNCIONARÍA
        */
           int telefono[] = new int[7];
           for(int j = 0;j <telefono.length ; j++){
              telefono[j] = ClienteDAO.ClienteDB.readChar();
           }
           int celular[] = new int[10];
           for(int j = 0;j <telefono.length ; j++){
              celular[j] = ClienteDAO.ClienteDB.readInt();
           }
           int saldo =this.ClienteDB.readInt();
          
           System.out.println("creando Cliente");
           Cliente p=new Cliente(Nombre,direccion,telefono,celular,saldo);
           clientes.put(id, p);
           
         
       }
       return clientes;
    }
    
    public void destructor() throws IOException{
      this.ClienteDB.close();
    }
    
}
