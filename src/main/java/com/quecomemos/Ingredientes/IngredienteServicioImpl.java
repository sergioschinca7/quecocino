/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quecomemos.Ingredientes;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sergio
 */
@Service
public class IngredienteServicioImpl implements IngredienteServicio{

    @Autowired
    private IngredienteRepositorio ingredienteRepositorio;


    @Override
    public List<Ingrediente> listar() {
        
       return ingredienteRepositorio.findAll();
    }

    @Override
    public void eliminar(Integer id) {
        ingredienteRepositorio.deleteById(id);
        
    }

    @Override
    public void crear(Ingrediente ingrediente) {
    ingredienteRepositorio.save(ingrediente);
    }

    @Override
    public Ingrediente encontrarPorId(Integer id) {
        
        return ingredienteRepositorio.findById(id).orElse(null);
    }
    
}
