/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quecomemos.Ingredientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Sergio
 */
@Controller
@RequestMapping("/ingrediente")
public class IngredienteControlador {
    
    @Autowired
    private IngredienteServicio ingredienteServicio;
    
    @GetMapping("/lista")
    public String crearIngrediente(Model model){
        model.addAttribute("lista",ingredienteServicio.listar());
      
        return "ingrediente-lista.html"; 
        
    }
    
    @GetMapping("/crear")
    public String toGuardar(Model model){
        model.addAttribute("ingrediente",new Ingrediente());
        
        return "ingrediente-form.html"; 
    }
    
    @PostMapping("/guardar")
    public String guardarIngrediente(Ingrediente ingrediente){
        
        ingredienteServicio.crear(ingrediente);
        
        return "redirect:/ingrediente/lista";
        
    }
    
    
    
}