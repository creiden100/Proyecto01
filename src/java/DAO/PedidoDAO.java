
package DAO;



import entidades.Pedido;
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
public class PedidoDAO {
     
    private static RandomAccessFile pedidoDB;
           public PedidoDAO() throws FileNotFoundException{
            this.pedidoDB = new RandomAccessFile("Pedido.txt", "rw");
            File file = new File("Pedido.txt");
            System.out.println(file.getAbsolutePath());
            
    } 
           
           public static boolean insertar(Pedido pedido) throws IOException{
        System.out.println("--------------------------------------------------");
       long posicionMemoria=0;
      
       if(pedidoDB!=null){
           System.out.println("2------------------------------------------");
        posicionMemoria = PedidoDAO.pedidoDB.length();
        
     }else{
            pedidoDB = new RandomAccessFile("Pedido.txt", "rw");
            File file = new File("Pedido.txt");
            System.out.println(file.getAbsolutePath());
       
       }
        
        System.out.println("pos memo"+PedidoDAO.pedidoDB.length());
        System.out.println(pedido);
        PedidoDAO.pedidoDB.seek(posicionMemoria);
       
        for (int i = 0; i < pedido.getCliente().getNombre().length; i++) {
            PedidoDAO.pedidoDB.writeInt(pedido.getCliente().getNombre()[i]); 
        }
        for (int i = 0; i < pedido.getProductos().size(); i++) {
           for (int j = 0; j < pedido.getProductos().get(i).getNombre().length; j++) {
            PedidoDAO.pedidoDB.writeInt(pedido.getProductos().get(i).getNombre()[j]); 
        }
        }
        
        

        return true;
    }
           
    public Map<Integer, Pedido> listarTodo() throws IOException{
        Map<Integer,Pedido> pedidos  = new HashMap<>();
                        
        for(long i = 0; i< this.pedidoDB.length();i= i + 40){
            
           this.pedidoDB.seek(i);
           int id=this.pedidoDB.readInt();
           System.out.println("id "+id);
           char NombreCliente[] = new char[30];
           for(int j = 0;j <NombreCliente.length ; j++){
              NombreCliente[j] = PedidoDAO.pedidoDB.readChar();
           }
           
      //--- error 2
          
           System.out.println("creando pedido");
           Pedido p=new Pedido(NombreCliente);
           pedidos.put(id, p);
           
         
       }
       return pedidos;
    }
    
    public void destructor() throws IOException{
      this.pedidoDB.close();
    }
    
}
