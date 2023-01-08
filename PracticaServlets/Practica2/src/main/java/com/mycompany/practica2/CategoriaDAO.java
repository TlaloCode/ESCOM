/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class CategoriaDAO {
    private static final String SQL_INSERTAR="insert into Categoria(nombreCategoria, descripcion) values(?,?)";
    private static final String SQL_UPDATE = "update Categoria set nombreCategoria = ?,descripcion = ? where idCategoria = ?";
    private static final String SQL_DELETE =  "delete from Categoria where idCategoria = ?";
    private static final String SQL_SELECT = "select * from Categoria where idCategoria = ?";
    private static final String SQL_SELECT_ALL = "select * from Categoria";
    
    private Connection con;
    
    private void obtenerConexion()
    {
        String usuario = "root";
        String clave ="ulises.123";
        String url = "jdbc:mysql://localhost:3306/Practica2";
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,usuario,clave);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No se pudo conectar :c");
        }
    }
    
     public void insertarCategoria(Categoria c) throws SQLException{
        PreparedStatement ps = null; //acceso a datos
        obtenerConexion();
        try{
            ps=con.prepareStatement(SQL_INSERTAR);//PREPARAR LA CONSULTA
            ps.setString(1, c.getCategoria());
            ps.setString(2,c.getDescripcionCategoria());
            ps.executeUpdate();
  
        }finally
        {
            if(ps != null) ps.close();
            if(con != null) con.close();
        }
    }
    
    public void actualizarCategoria(Categoria c) throws SQLException
    {
        obtenerConexion();
        PreparedStatement ps = null; //Prepara las consultas;
        try
        {
            ps= con.prepareStatement(SQL_UPDATE);
            ps.setString(1, c.getCategoria());
            ps.setString(2,c.getDescripcionCategoria());
            ps.setInt(3, c.getIdCategoria());
            ps.executeUpdate();
        }finally
        {
             if(ps != null) ps.close();
            if(con != null) con.close();      
        }
    }
    
    
    public void eliminarCategoria(Categoria c) throws SQLException
    {
        obtenerConexion();
        PreparedStatement ps = null; //Prepara las consultas;
        try
        {
            ps= con.prepareStatement(SQL_DELETE);
            ps.setInt(1, c.getIdCategoria());
            ps.executeUpdate();
        }finally
        {
             if(ps != null) ps.close();
            if(con != null) con.close();      
        }
    }
    
    public List mostrarTodo() throws SQLException
    {
        obtenerConexion();
        PreparedStatement ps= null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(SQL_SELECT_ALL);
            rs= ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() >0) {
                return resultados;
            }
            else
            {
                return null;
            }
        }finally
        {
            if(rs!= null) rs.close();
            if(ps != null) ps.close();
            if(con != null) con.close();   
        }
    }
    
    
    public Categoria MostrarUno(Categoria c) throws SQLException{
        obtenerConexion();
        PreparedStatement ps= null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(SQL_SELECT);
             ps.setInt(1, c.getIdCategoria());
            rs= ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (!resultados.isEmpty()) {
                return (Categoria) resultados.get(0);
            }
            else
            {
                return null;
            }
            }
        finally{
            if(rs!= null) rs.close();
            if(ps != null) ps.close();
            if(con != null) con.close(); 
        }
  
}
    
        private List obtenerResultados(ResultSet rs) throws SQLException{
       List resultados = new ArrayList();
       while(rs.next())
       {
           Categoria c = new Categoria();
           c.setIdCategoria(rs.getInt("idCategoria"));
           c.setCategoria(rs.getString("nombreCategoria"));
           c.setDescripcionCategoria(rs.getString("descripcion"));
           resultados.add(c);
       }
       
       return resultados;
    }

    
    public static void main(String[] args) {
        Categoria c = new Categoria();
      //  c.setIdCarrera(2);
       CategoriaDAO dao = new CategoriaDAO();

        try {
          // dao.insertarCarrera(c);
          // dao.actualizarCarrera(c);
          dao.eliminarCategoria(c);
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }


 
}
