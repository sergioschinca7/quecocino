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
import org.springframework.web.bind.annotation.RequestParam;
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

        //model.addAttribute("persona", new Persona());
        return "crear-persona.html";
    }

    @GetMapping("/index-persona")
    public String indexPersona() {

        return "index-persona.html";
    }

    @PostMapping("/guardar-persona")
    public String guardarPersona(ModelMap model, RedirectAttributes redirect, @RequestParam String nombre,
            @RequestParam String apellido, @RequestParam String contrasena, @RequestParam String contrasena2) throws ErrorServicio {
        try {
            Persona persona = new Persona();
            persona.setNombre(nombre);
            persona.setApellido(apellido);
            persona.setContrasena(contrasena);
            persona.setAlta(Boolean.TRUE);

            personaServicio.guardar(persona, contrasena2);

        } catch (ErrorServicio e) {
            model.put("error", e.getMessage());
            model.put("nombre", nombre);
            model.put("apellido", apellido);

            return "crear-persona.html";
        }
        return "login.html";
    }
}
