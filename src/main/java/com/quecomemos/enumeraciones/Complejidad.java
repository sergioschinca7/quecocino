/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.quecomemos.enumeraciones;

<<<<<<< HEAD
=======
/**
 *
 * @author Sergio
 */

>>>>>>> sergio
import lombok.Getter;

public enum Complejidad {
    
    SENCILLA("Sencilla"), MEDIA("Media"), DIFICIL("Difícil");
    
    @Getter
    private String displayName;

    Complejidad(String displayName) {
        this.displayName = displayName;
    }
    
}
