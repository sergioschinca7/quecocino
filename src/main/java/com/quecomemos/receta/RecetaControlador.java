/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quecomemos.receta;

<<<<<<< HEAD
import com.quecomemos.Errores.ErrorServicio;
import com.quecomemos.Ingredientes.Ingrediente;
import com.quecomemos.Ingredientes.IngredienteServicio;
import java.util.ArrayList;
=======
import com.quecomemos.Ingredientes.Ingrediente;
import com.quecomemos.Ingredientes.IngredienteServicio;
import java.util.ArrayList;
import java.util.List;
>>>>>>> sergio
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> sergio

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
    public String mostrarReceta(Model model) {

<<<<<<< HEAD
        model.addAttribute("lista", recetaServicio.listarReceta());

        return "mostrar-receta.html";
=======
        model.addAttribute("receta", recetaServicio.listarReceta());

        return "receta-lista.html";
>>>>>>> sergio

    }

    @GetMapping("/crear-receta")
<<<<<<< HEAD
    public String toGuardarReceta(Model model, @RequestParam(required = false) Receta rece) {

        if (rece == null) {
            model.addAttribute("lista", ingredienteServicio.listar());
            Receta receta = new Receta();

            Ingrediente ingrediente = new Ingrediente();
            Ingrediente ingrediente1 = new Ingrediente();
            Ingrediente ingrediente2 = new Ingrediente();

            receta.getIngredientes().add(ingrediente);
            receta.getIngredientes().add(ingrediente1);
            receta.getIngredientes().add(ingrediente2);

            model.addAttribute("recetas", receta);
            return "crear-receta.html";
        } else {
            model.addAttribute("recetas", rece);
        }
=======
    public String toGuardarReceta(Model model) {
        model.addAttribute("lista", ingredienteServicio.listar());
        Receta receta = new Receta();
        receta.getIngredientes().add(new Ingrediente());
        receta.getIngredientes().add(new Ingrediente());
        receta.getIngredientes().add(new Ingrediente());
        model.addAttribute("recetas", receta);
>>>>>>> sergio

        return "crear-receta.html";
    }

    @PostMapping("/guardar-receta")
<<<<<<< HEAD
    public String guardarIngrediente(@ModelAttribute Receta receta, RedirectAttributes redirect,
            @RequestParam(required = true) String cantidad, ModelMap model) throws ErrorServicio {

        ArrayList<Ingrediente> seleccionados = new ArrayList();
        ArrayList<String> cant = new ArrayList();

        try {
            Receta aPersistir = recetaServicio.validarReceta(receta);

            for (int i = 0; i < aPersistir.getIngredientes().size(); i++) {

                Ingrediente ingrediente = aPersistir.getIngredientes().get(i);
                String nombre = ingrediente.getNombreIngrediente();
                Ingrediente ingredienteBaseDatos = ingredienteServicio.encontrarPorNombre(nombre);
                Integer ibd = ingredienteBaseDatos.getIdIngrediente();
                ingrediente.setIdIngrediente(ibd);
                seleccionados.add(ingrediente);
            }

            receta.setIngredientes(seleccionados);
            for (String aux : recetaServicio.separarCantidades(cantidad)) {
                cant.add(aux);
            }
            receta.setCantidad(cant);

            recetaServicio.crearReceta(aPersistir);

        } catch (ErrorServicio e) {
            redirect.addFlashAttribute("error", e.getMessage());
            return "redirect:/receta/crear-receta";
        }

        return "redirect:/receta/mostrar-receta";

    }

    @GetMapping("/pastel-de-papa")
    public String recetaParticular(Model model, Integer id) {

        Receta rece = recetaServicio.encontrarRecetaPorId(id);
        model.addAttribute("receta", rece);

        for (String object : rece.getCantidad()) {
            System.out.println("cantidades " + object);
            System.out.println("tamaño " + rece.getCantidad().size());
        }

        return "pastel-de-papa.html";
    }
=======
    public String guardarIngrediente(@ModelAttribute Receta receta) {

        System.out.println(receta.getNombre());
        List<Ingrediente> list = receta.getIngredientes();
        for (int i = 0; i < 3; i++) {

            list.get(i).getNombreIngrediente();

        }

        recetaServicio.crearReceta(receta);

        return "redirect:/receta/mostrar-receta";

    }

>>>>>>> sergio
}
