/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quecomemos.receta;

import com.quecomemos.Errores.ErrorServicio;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sergio
 */
@Service
public class RecetaServicioImpl implements RecetaServicio {

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

    @Override
    public Receta validarReceta(Receta receta) throws ErrorServicio {
               
        if (receta.getNombre().isEmpty()) {
            throw new ErrorServicio("El nombre no puede estar vacio.");
        }
        if (receta.getProcedimiento().isEmpty()) {
            throw new ErrorServicio("El procedimiento no puede estar vacio.");
        }
        if (receta.getDuracion().isEmpty()) {
            throw new ErrorServicio("La duración no puede estar vacia.");
        }
        if (receta.getCantidad().isEmpty()) {
            throw new ErrorServicio("Las cantidades no pueden estar vacias.");
        }

        String nombreReceta = receta.getNombre().toUpperCase();
        Receta baseDeDatos = buscarRecetaPorNombre(nombreReceta);

        if (baseDeDatos == null) {

            receta.setNombre(nombreReceta);

        } else if (baseDeDatos.getNombre().equalsIgnoreCase(receta.getNombre())) {
            throw new ErrorServicio("La receta ya existe.");
        }
        return receta;

    }

    @Override
    public Receta buscarRecetaPorNombre(String nombre) throws ErrorServicio {

        return recetaRepositorio.buscarRecetaPorNombre(nombre);
    }

    @Override
    public String[] separarCantidades(String cantidad) {
        String delimiter = ",";
        Pattern pattern = Pattern.compile(
                delimiter, Pattern.CASE_INSENSITIVE);

        // Used to perform case insensitive search of the
        // string
        String[] result = pattern.split(cantidad);
        
        return result;
    }

    @Override
    public Receta buscarNombre(String nombreReceta) throws ErrorServicio {
        
        String nombre = nombreReceta.toUpperCase();
        
        Receta receta = recetaRepositorio.buscarRecetaPorNombre(nombre);
        
        if (receta==null) {
            throw new ErrorServicio("La receta no existe");
        }
        
        return receta;
        


    }

    @Override
    public List<Receta> findAllByIngredientesNombreIngrediente(List<String> ingrediente1) {
        
        return recetaRepositorio.findAllByIngredientesNombreIngredienteIn(ingrediente1);

    }

    @Override
    public Receta buscarPorId(Integer id) {
        
        Optional<Receta> respuesta =  recetaRepositorio.findById(id);
        
        Receta receta = respuesta.get();
        
        return receta;


    }
    

}
