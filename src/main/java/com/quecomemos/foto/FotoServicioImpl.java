package com.quecomemos.foto;

import com.quecomemos.Errores.ErrorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FotoServicioImpl implements FotoServicio{

    @Autowired
    private FotoRepositorio fotoRepositorio;

    @Override
    public Foto guardar(MultipartFile archivo) throws ErrorServicio {
        if (archivo!=null){
            try {
                Foto foto = new Foto();
                foto.setMime(archivo.getContentType());
                foto.setNombreFoto(archivo.getName());
                foto.setContenido(archivo.getBytes());
                return fotoRepositorio.save(foto);
            }catch (Exception e){
                System.err.println((e.getMessage()));
            }
        }
        return null;
    }
}
