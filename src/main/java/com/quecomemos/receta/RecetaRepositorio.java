/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quecomemos.receta;

import com.quecomemos.Ingredientes.Ingrediente;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sergio
 */
@Repository
public interface RecetaRepositorio extends JpaRepository<Receta, Integer>{
    
     @Query("SELECT r FROM Receta r WHERE r.nombre = :nombre ORDER BY r.nombre")
    public Receta buscarRecetaPorNombre(@Param("nombre") String nombre);
    
    
//    @Query("SELECT r FROM Receta r JOIN r.ingredientes ri ON"
//            + " ri.=r.id JOIN ingredientes i ON i.ingrediente_id=ri.ingrediente_id"
//            + "AND i.nombre_ingrediente IN (':ingrediente1') GROUP BY r.nombre")
//    public ArrayList<Receta> recetasPorIngredientes(@Param("ingrediente1") String ingrediente1);
    
    
    
    
    
}
