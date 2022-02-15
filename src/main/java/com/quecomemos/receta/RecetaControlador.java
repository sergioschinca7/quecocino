/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quecomemos.receta;

import com.quecomemos.Ingredientes.IngredienteServicio;
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
@RequestMapping("/receta")
public class RecetaControlador {
    
    @Autowired
    private RecetaServicio recetaServicio;
    
    @Autowired
    private IngredienteServicio ingredienteServicio;
    
    @GetMapping("/mostrar-receta")
    public String mostrarReceta(Model model){
        
        model.addAttribute("receta", recetaServicio.listarReceta());
        
        return "receta-lista.html";
        
    }
    
    @GetMapping("/crear-receta")
    public String toGuardarReceta(Model model){
        model.addAttribute("lista", ingredienteServicio.listar());
        model.addAttribute("receta",new Receta());
        
        return "crear-receta.html"; 
    }
    
    
    
    @PostMapping("/guardar-receta")
    public String guardarIngrediente(Receta receta){
        
        recetaServicio.crearReceta(receta);
        
        return "redirect:/receta/mostrar-receta";
        
    }
    
}
