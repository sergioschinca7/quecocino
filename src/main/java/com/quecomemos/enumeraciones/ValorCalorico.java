/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.quecomemos.enumeraciones;

/**
 *
 * @author Sergio
 */
import lombok.Getter;

public enum ValorCalorico {
    
    BAJO("Bajo"), MEDIO("Medio"), ALTO("Alto");
    
    @Getter
    private String nombre;

    ValorCalorico(String nombre) {
        this.nombre = nombre;
    }
    
}
