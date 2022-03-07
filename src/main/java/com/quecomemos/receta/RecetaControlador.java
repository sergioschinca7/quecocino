package com.quecomemos.receta;

import com.quecomemos.Errores.ErrorServicio;
import com.quecomemos.Ingredientes.Ingrediente;
import com.quecomemos.Ingredientes.IngredienteServicio;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/receta")
public class RecetaControlador {

    @Autowired
    private RecetaServicio recetaServicio;

    @Autowired
    private IngredienteServicio ingredienteServicio;

    @GetMapping("/mostrar-receta")
    public String mostrarReceta(Model model) {

        model.addAttribute("lista", recetaServicio.listarReceta());

        return "mostrar-receta.html";

    }

    @GetMapping("/crear-receta")
    public String toGuardarReceta(Model model) {

        model.addAttribute("lista", ingredienteServicio.listar());
        Receta receta = new Receta();

        for (int i = 0; i < 50; i++) {
            Ingrediente ing = null;
            receta.getIngredientes().add(ing);
        }

        model.addAttribute("recetas", receta);
        return "crear-receta.html";
    }

    @PostMapping("/guardar-receta")
    public String guardarReceta(@ModelAttribute Receta receta, RedirectAttributes redirect,
            ModelMap model) throws ErrorServicio {

        ArrayList<Ingrediente> seleccionados = new ArrayList();
        Iterator<Ingrediente> it = receta.getIngredientes().iterator();

        while (it.hasNext()) {
            Ingrediente next = it.next();
            if (next.getNombreIngrediente() == null || next.getNombreIngrediente().isEmpty()) {
                it.remove();
            }
        }

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

            recetaServicio.crearReceta(aPersistir);

        } catch (ErrorServicio e) {
            redirect.addFlashAttribute("error", e.getMessage());
            return "redirect:/receta/crear-receta";
        }

        return "redirect:/receta/mostrar-receta";

    }

    @GetMapping("/receta-detalle")
    public String recetaParticular(Model model, Integer id) {

        Receta rece = recetaServicio.encontrarRecetaPorId(id);
        model.addAttribute("receta", rece);

        return "receta-detalle.html";
    }

    @GetMapping("/buscar-receta")
    public String buscarReceta() {

        return "buscar-receta.html";
    }

    @GetMapping("/receta-por-nombre")
    public String recetaPorNombre(ModelMap model, String nombreReceta) {

        try {
            Receta receta = recetaServicio.buscarNombre(nombreReceta);
            model.addAttribute("receta", receta);

            return "receta-por-nombre.html";

        } catch (ErrorServicio e) {
            model.put("error", e.getMessage());
            return "buscar-receta.html";
        }
    }

    @GetMapping("/por-ingrediente")
    public String decimeQueComer(Model model) {

        model.addAttribute("lista", ingredienteServicio.listar());

        return "por-ingrediente.html";
    }

    @GetMapping("/decime-que-comer")
    public String recetaPorIngrediente(ModelMap model,
            @RequestParam(required = false) String ingrediente1,
            @RequestParam(required = false) String ingrediente2,
            @RequestParam(required = false) String ingrediente3) {

        System.out.println(ingrediente1 + " " + ingrediente2 + " " + ingrediente3 + " " + "estos son los ingredientes");
        List<String> ingredientes = Arrays.asList(ingrediente1, ingrediente2, ingrediente3);
        
        List<Receta> lista = recetaServicio.findAllByIngredientesNombreIngrediente(ingredientes);
        
        HashSet<Receta> lista1 = new HashSet(lista);
        
        for (Receta receta : lista1) {
            
            System.out.println("recetas " + receta.getNombre());
            
            
        }
        return "buscar-receta.html";

    }

}
