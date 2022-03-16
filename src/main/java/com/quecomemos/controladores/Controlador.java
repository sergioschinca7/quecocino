/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quecomemos.controladores;

import com.quecomemos.Ingredientes.IngredienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Sergio
 */
@Controller
public class Controlador {

    @Autowired
    private IngredienteServicio ingredienteServicio;
    @GetMapping("/")
    public String index(Model model) {

<<<<<<< HEAD


=======
    model.addAttribute("lista", ingredienteServicio.listarAlfabeticamente());
>>>>>>> jose
        return "index.html";
    }
}
