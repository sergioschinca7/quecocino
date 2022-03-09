/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quecomemos.Ingredientes;

import com.quecomemos.Errores.ErrorServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sergio
 */
@Service
public class IngredienteServicioImpl implements IngredienteServicio {

    @Autowired
    private IngredienteRepositorio ingredienteRepositorio;

    @Override
    public List<Ingrediente> listar() {

        return ingredienteRepositorio.findAll();
    }

    @Override
    public List<Ingrediente> listarAlfabeticamente() {
        
        return ingredienteRepositorio.findByOrderByNombreIngrediente();
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

    @Override
    public Ingrediente encontrarPorNombre(String nombre) throws ErrorServicio {

        return ingredienteRepositorio.buscarIngredientePorNombre(nombre);
    }

    @Override
    public Ingrediente validarIngrediente(Ingrediente ingrediente) throws ErrorServicio {

        if (ingrediente.getNombreIngrediente().isEmpty()) {
            throw new ErrorServicio("El nombre del ingrediente no puede estar vacio.");
        }
        String nombre = ingrediente.getNombreIngrediente().toUpperCase();
        Ingrediente baseDeDatos = encontrarPorNombre(nombre);

        if (baseDeDatos == null) {

            ingrediente.setNombreIngrediente(nombre);

        } else if (baseDeDatos.getNombreIngrediente().equalsIgnoreCase(ingrediente.getNombreIngrediente())) {
            throw new ErrorServicio("El ingrediente ya existe.");
        }
        return ingrediente;

    }

}
