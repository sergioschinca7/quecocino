package com.quecomemos.foto;

import com.quecomemos.Errores.ErrorServicio;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;

public interface FotoServicio {

    public Foto guardar(MultipartFile archivo) throws ErrorServicio;
}
