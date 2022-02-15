/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quecomemos.receta;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sergio
 */
@Service
public class RecetaServicioImpl implements RecetaServicio{
    
    @Autowired
    private RecetaRepositorio recetaRepositorio;
    
    @Override
    public List<Receta> listarReceta() {
        
        return recetaRepositorio.findAll();
        
    }

    @Override
    public void eliminarReceta(Integer id) {
        recetaRepositorio.deleteById(id);

    }

    @Override
    public void crearReceta(Receta receta) {
        recetaRepositorio.save(receta);

    }

    @Override
    public Receta encontrarRecetaPorId(Integer id) {
        return recetaRepositorio.findById(id).orElse(null);

    }
    
}
