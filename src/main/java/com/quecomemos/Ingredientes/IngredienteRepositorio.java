/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quecomemos.Ingredientes;

import com.quecomemos.receta.Receta;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sergio
 */
@Repository
public interface IngredienteRepositorio extends JpaRepository<Ingrediente, Integer>{
    
    @Query("SELECT i FROM Ingrediente i WHERE i.nombreIngrediente = :nombre")
    public Ingrediente buscarIngredientePorNombre(@Param("nombre") String nombre);
    
    
    
    
}
