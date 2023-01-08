/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica2;

/**
 *
 * @author USUARIO
 */
public class Categoria{
     
    private int idCategoria;
    private String categoria;
    private String descripcionCategoria;
    
     public Categoria()
     {
     }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descrpcionCategoria) {
        this.descripcionCategoria = descrpcionCategoria;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Clave:").append(idCategoria).append("\n");
        sb.append("nombre:").append(getCategoria()).append("\n");
        sb.append("descripcion").append(descripcionCategoria).append("\n");
        return sb.toString();
    }
     
     
     

    
}
