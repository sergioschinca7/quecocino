/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quecomemos.receta;

import com.quecomemos.Errores.ErrorServicio;
import com.quecomemos.Ingredientes.Ingrediente;
import java.util.List;

/**
 *
 * @author Sergio
 */
public interface RecetaServicio {

    public List<Receta> listarReceta();

    public void eliminarReceta(Integer id);

    public void crearReceta(Receta receta);

    public Receta encontrarRecetaPorId(Integer id);

    public Receta validarReceta(Receta receta) throws ErrorServicio;

    public Receta buscarRecetaPorNombre(String nombre) throws ErrorServicio;
    
    public String[] separarCantidades(String cantidad);

}
