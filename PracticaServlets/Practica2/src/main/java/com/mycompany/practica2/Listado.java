/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
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
@WebServlet(name = "Listado", urlPatterns = {"/Listado"})
public class Listado extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Listado</title>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js' ></script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<div class='mb-3'>");
            out.println("<div class='card'");
            out.println("<div class='card-header text-center text-primary'>");
            out.println("<h1 class='card-title'>Listado de Categorias</h1>");
            out.println("</div>");
            out.println("<div class='card-body text-primary'>");
            out.println("<table class='table table-striped'>");
            out.println("<tr>");
            out.println("<td>ID CATEGORIA</td>");
            out.println("<td>CATEGORIA</td>");
            out.println("<td>DESCRIPCIÓN</td>");
            out.println("<td colspan='2'>ACCIONES</td>");
            out.println("</tr>");
            CategoriaDAO dao = new CategoriaDAO();
            List lista;
            try {
                lista = dao.mostrarTodo();
                for (int i = 0; i < lista.size(); i++) {
                Categoria c = (Categoria) lista.get(i);
               //     System.out.println(c);
                out.println("<tr>");
                   // out.println("<td><a href='MostrarCarrera?id="+c.getIdCarrera()+"' class='btn btn-info'>Eliminar</a>"+c.getIdCarrera()+"</td>");
                   out.println("<td><a href='ListadoUno?id="+c.getIdCategoria()+"' class='btn btn-warning'>"+c.getIdCategoria()+"</td>");
                   out.println("<td>"+c.getCategoria()+"</td>");
                   out.println("<td>"+c.getDescripcionCategoria()+"</td>");
                   out.println("<td><a href='EliminarCategoria?id="+c.getIdCategoria()+"' class='btn btn-danger'>Eliminar</a></td>");
                   out.println("<td><a href='ActualizarCategoria?id="+c.getIdCategoria()+"' class='btn btn-success'>Actualizar</a></td>");
                   out.println("</tr>");
            }
                
            Iterator it = lista.iterator();
           /* while(it.hasNext())
            {
                out.println("<tr>");
                out.println("<td>1</td>");
                out.println("</tr>");
                
            }*/
           // out.println(dao.mostrarTodo());
            } catch (SQLException ex) {
                Logger.getLogger(Listado.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            out.println("</table>");
            out.println("<a href='AgregarCategoria' class='btn btn-primary'>Agregar categoría</a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
           // out.println("<h1>Servlet Listado at " + request.getContextPath() + "</h1>");
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
