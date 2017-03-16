<%-- 
    Document   : Listar
    Created on : 12/03/2017, 06:21:54 PM
    Author     : GAEA
--%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.ClienteDAO"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entidades.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
    </head>
    <body>
        <table>
            <tr>
                <td>Nombre</td>
                <td>Direccion</td>
                <td>Telefono</td>
                <td>Celular</td>
                <td>Saldo</td>
            </tr>
            <%
                Map<Integer,Cliente> lista = new ClienteDAO().listarTodo();
                if(lista!=null){
                      /*
         PROBLEMA 3 NO ESTAN RECORRIENDO CORRECTAMENTE UN MAP. NO PUEDEN GARANTIZAR QUE EL ID QUE INGRES EL USUARIO CORRESPONDERA 
                    CON EL ITERADOR DEL CICLO
        */
                      
                    for (Cliente cliente : lista.values()) {
  
                        
               %>
                 <tr>
                     <td><%=cliente.getNombre()%> </td>
                    <td><%=cliente.getDireccion()%> </td>
                    <td><%=cliente.getTelefono()%></td>
                    <td><%=cliente.getCelular()%></td>
                    <td><%=cliente.getSaldo()%></td>
                    </tr>
               <%
                }

}
                %>
                </table>
    </body>
</html>
