<%-- 
    Document   : ListarProductos
    Created on : 12/03/2017, 09:36:24 PM
    Author     : GAEA
--%>
<%@page import="DAO.ProductoDAO"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.ClienteDAO"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entidades.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <td>Nombre</td>
                <td>tipo</td>
                <td>UnidadMedida</td>
                <td>Tamaño</td>
                <td>Cantidad</td>
                <td>Precio Compra</td>
                <td>PrecioVenta</td>
                <td>Ganancia</td>
                
            </tr>
            <%
                Map<Integer,Producto> lista = new ProductoDAO().listarTodo();
                if(lista!=null){
                      /*
         PROBLEMA 3 NO ESTAN RECORRIENDO CORRECTAMENTE UN MAP. NO PUEDEN GARANTIZAR QUE EL ID QUE INGRES EL USUARIO CORRESPONDERA 
                    CON EL ITERADOR DEL CICLO
        */
                      
                    for (Producto producto : lista.values()) {
  
                        
               %>
                    <td><%=producto.getNombre()%> </td>
                    <td><%=producto.getTipo()%> </td>
                    <td><%=producto.getUnidadMedida()%></td>
                    <td><%=producto.getTamano()%></td>
                    <td><%=producto.getCantidad()%></td>
                    <td><%=producto.getPrecio_compra()%></td>
                    <td><%=producto.getPrecio_venta()%></td>
                    <td><%=producto.getGanancia()%></td>
                    
          <%
                }

}
                %>
                </table>
    </body>
</html>
