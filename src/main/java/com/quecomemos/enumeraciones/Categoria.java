/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.quecomemos.enumeraciones;

import lombok.Getter;

/**
 *
 * @author Sergio
 */
public enum Categoria {
    
        DESAYUNO("Desayuno"), ALMUERZO("Almuerzo"), MERIENDA("Merienda"),
        CENA("Cena"), POSTRE("Postre"), PASTAS("Pastas"), ENSALADAS("Ensalada"),
        CARNES("Carnes"), PESCADO("Pescados"),VEGETARIANO("Vegetariano"), VEGANO("Vegano");
    
    @Getter
    private String displayName;

    Categoria(String displayName) {
        this.displayName = displayName;
    }
    
}
