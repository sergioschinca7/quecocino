package com.quecomemos.foto;


import com.quecomemos.Errores.ErrorServicio;
import com.quecomemos.receta.Receta;
import com.quecomemos.receta.RecetaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/foto")
public class FotoControlador {

    @Autowired
    private RecetaServicio recetaServicio;

    @GetMapping("/receta")
    public ResponseEntity<byte[]> fotoReceta(@RequestParam Integer id){

        try {
            Receta receta = recetaServicio.encontrarRecetaPorId(id);
            if (receta.getFoto()==null){
                throw new ErrorServicio("La receta no tiene foto asignada");
            }
            byte[] foto = receta.getFoto().getContenido();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);

            return new ResponseEntity<>(foto, headers, HttpStatus.OK);
        }catch(ErrorServicio e){
            Logger.getLogger(FotoControlador.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
}
