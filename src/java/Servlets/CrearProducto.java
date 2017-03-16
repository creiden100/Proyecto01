/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Producto;

/**
 *
 * @author GAEA
 */
public class CrearProducto extends HttpServlet {

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
            out.println("<title>Servlet CrearProducto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Producto Agregado correctamente</h1>");
            out.println("<h5>Nombre del producto " + request.getParameter("nombre") + "</h5>");
            out.println("<h5>Tipo " + request.getParameter("tipo") + "</h5>");
            out.println("<h5>Unidades  " + request.getParameter("unidad_media") + "</h5>");
            out.println("<h5>Cantidad " + request.getParameter("cantidad") + "</h5>");
            out.println("<h5>Tamaño " + request.getParameter("tamano") + "</h5>");
            out.println("<h5>Precio Compra " + request.getParameter("precio_compra") + "</h5>");
            out.println("<h5>Precio Venta " + request.getParameter("precio_venta") + "</h5>");
            out.println("<a href=\"index.html\">Volver Index</a>");
            out.println("<a href=\"Factura.html\">Factura</a>");
            out.println("<a href=\"ListarProductos.jsp\">Lista Productos</a>");
            out.println("</body>");
            out.println("</html>");
            char[] Nombre = (request.getParameter("nombre")).toCharArray();
            char[] tipo = (request.getParameter("tipo")).toCharArray();
            char[] UnidadMedida = (request.getParameter("unida_media")).toCharArray();    
            int Cantidad =Integer.parseInt(request.getParameter("cantidad"));
            int tamano =Integer.parseInt(request.getParameter("tamano"));
            int Precio_compra =Integer.parseInt(request.getParameter("precio_compra"));
            int Precio_venta =Integer.parseInt(request.getParameter("precio_venta"));
            Producto producto = new Producto(Nombre,tipo,UnidadMedida,Cantidad,tamano,Precio_compra,Precio_venta);
            
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
