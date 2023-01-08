/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "AgregarCategoria", urlPatterns = {"/AgregarCategoria"})
public class AgregarCategoria extends HttpServlet {

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
            out.println("<title>Hola mundo</title>");            
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js' ></script>");
            out.println("<title>Servlet AgregarCategoria</title>");            
            out.println("</head>");
            out.println("<body>");
          out.println("<form method=\"post\" class=\"form-group\">");
          
          out.println("<div class=\"card\">");
           out.println("<div class='card-header text-center text-primary'>");
            out.println("<h1 class='card-title'>Agregar categoria...</h1>");
           out.println("</div>");
           
           out.println("<div class='card-body text-center text-primary'>");
            out.println("<h2>Nombre de la categoria</h2>");
            out.println("<input name=\"Nombre\" id=\"Nombre\" TYPE=\"TEXT\" SIZE=\"50\" MAXLENGTH=\"50\">");
            out.println("<h2>Descripcion de la categoria</h2>");
            out.println("<input name=\"Descripcion\" id=\"Descripcion\" TYPE=\"TEXT\" SIZE=\"50\" MAXLENGTH=\"50\">");
            out.println("</div>");          
            out.println("<div class='card-footer text-center'>");
            out.println("<input type=\"submit\" value=\"Enviar\" class='btn btn-success'>");
            out.println("<a href='Listado' class='btn btn-info'>Regresar al listado</a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
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
        CategoriaDAO dao = new CategoriaDAO();
            Categoria c = new Categoria();
        String Nombre = request.getParameter("Nombre");
            String Descripcion = request.getParameter("Descripcion");
            c.setCategoria(Nombre);
            c.setDescripcionCategoria(Descripcion);
            try {
                dao.insertarCategoria(c);
            } catch (SQLException ex) {
                Logger.getLogger(EliminarCategoria.class.getName()).log(Level.SEVERE, null, ex);
            }
       processRequest(request, response);
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
