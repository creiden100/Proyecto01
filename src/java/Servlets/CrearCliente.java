/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import entidades.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GAEA
 */
public class CrearCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CrearCliente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cliente No #1</h1>");
            out.println("<h5>Nombre: " + request.getParameter("nombre") + "</h5>");
            out.println("<h5>Direccion: " + request.getParameter("Direccion") + "</h5>");
            out.println("<h5>Telefono: " + request.getParameter("telefono") + "</h5>");
            out.println("<h5>Celular: " + request.getParameter("celular") + "</h5>");
            out.println("<h5>saldo: " + request.getParameter("saldo") + "</h5>");
            out.println("<a href=\"ListarProductos.jsp\">Lista de Productos</a>");
            out.println("<a href=\"index.html\">Volver Index</a>");
            out.println("</body>");
            out.println("</html>");
            char[] Nombre = (request.getParameter("nombre")).toCharArray();
            char[] direccion = (request.getParameter("Direccion")).toCharArray();
            int[] telefono = new int[7];
            int[] celular = new int[10];
            for (int i = 0; i < request.getParameter("telefono").length(); i++) {
                telefono[i]=Integer.parseInt(request.getParameter("telefono").substring(i, i++));
            }
            for (int i = 0; i < request.getParameter("celular").length(); i++) {
                celular[i]=Integer.parseInt(request.getParameter("celular").substring(i, i++));
            }
            int saldo =Integer.parseInt(request.getParameter("saldo"));
            Cliente cliente = new Cliente(Nombre,direccion,telefono,celular,saldo);
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    

    

}
