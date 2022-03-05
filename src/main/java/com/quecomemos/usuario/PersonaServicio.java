/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quecomemos.usuario;

import com.quecomemos.Errores.ErrorServicio;

/**
 *
 * @author Sergio
 */
public interface PersonaServicio {
    
    public Persona validarPersona(Persona persona, String contrasena2) throws ErrorServicio;
    
    public Persona guardar(Persona persona, String contrasena2) throws ErrorServicio;
    
     public Persona findByNombre(String nombre); 
}
