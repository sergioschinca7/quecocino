/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quecomemos.usuario;

import com.quecomemos.Errores.ErrorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Sergio
 */
@Controller
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaServicio personaServicio;

    @GetMapping("/crear-persona")
    public String crearPersona(Model model) {

        model.addAttribute("persona", new Persona());

        return "crear-persona.html";
    }

    @GetMapping("/index-persona")
    public String indexPersona() {

        return "index-persona.html";
    }

    @PostMapping("/guardar-persona")
    public String guardarPersona(ModelMap model, RedirectAttributes redirect,
            @ModelAttribute Persona persona, String contrasena2) throws ErrorServicio {
        try {
            personaServicio.guardar(persona, contrasena2);

        } catch (ErrorServicio e) {
            redirect.addFlashAttribute("error", e.getMessage());
            return "redirect:/persona/crear-persona";
        }
        return "buscar-receta.html";
    }
}
