/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quecomemos.receta;

import com.quecomemos.Errores.ErrorServicio;
import java.util.List;

/**
 *
 * @author Sergio
 */
public interface RecetaServicio {

    public List<Receta> listarReceta();

    public void eliminarReceta(Integer id);

    public void crearReceta(Receta receta);
    
    public Receta buscarPorId(Integer id);

    public Receta encontrarRecetaPorId(Integer id);

    public Receta validarReceta(Receta receta) throws ErrorServicio;

    public Receta buscarRecetaPorNombre(String nombre) throws ErrorServicio;
    
    public String[] separarCantidades(String cantidad);
    
    public Receta buscarNombre(String nombreReceta) throws ErrorServicio;
    
    public List<Receta> findAllByIngredientesNombreIngrediente(List<String> ingrediente1) throws ErrorServicio;
    
    public List<Receta> buscar(String nombreReceta)throws ErrorServicio;
    
    public List<Receta> busquedaPorIng(List<String> ingredientes) throws ErrorServicio;
    
    public Receta buscarNombreSinExcepcion(String nombreReceta);
    

}
