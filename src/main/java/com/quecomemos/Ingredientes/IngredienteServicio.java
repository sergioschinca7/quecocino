/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quecomemos.Ingredientes;

import java.util.List;
/**
 *
 * @author Sergio
 */

public interface IngredienteServicio {
    
    public List<Ingrediente> listar();
    
    public void eliminar(Integer id);
    
    public void crear(Ingrediente ingrediente);
    
    public Ingrediente encontrarPorId(Integer id);
    
    
}