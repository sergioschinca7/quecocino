/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quecomemos.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sergio
 */
@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Integer>{
    
    public Persona findByNombre(String nombre);

    @Query("SELECT u FROM Persona u WHERE u.nombreUsuario = :nombreUsuario")
    public Persona findByNombreUsuario(@Param("nombreUsuario") String nombreUsuario);



}
