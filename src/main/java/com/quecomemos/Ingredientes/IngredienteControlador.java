package com.quecomemos.Ingredientes;

import com.quecomemos.Errores.ErrorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ingrediente")
public class IngredienteControlador {

    @Autowired
    private IngredienteServicio ingredienteServicio;

    @GetMapping("/lista")
    public String crearIngrediente(Model model) {
        model.addAttribute("lista", ingredienteServicio.listarAlfabeticamente());

        return "ingrediente-lista.html";

    }

    @GetMapping("/crear")
    public String toGuardar(Model model) {

        model.addAttribute("ingrediente", new Ingrediente());

        return "ingrediente-form.html";
    }

    @PostMapping("/guardar")
    public String guardarIngrediente(Ingrediente ingrediente, ModelMap model) {

        try {
            Ingrediente aPersistir = ingredienteServicio.validarIngrediente(ingrediente);
            ingredienteServicio.crear(aPersistir);

        } catch (ErrorServicio e) {
            model.put("error", e.getMessage());
            return "ingrediente-form.html";
        }
        return "redirect:/ingrediente/crear";
    }

}
