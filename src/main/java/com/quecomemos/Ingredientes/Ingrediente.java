/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quecomemos.Ingredientes;

import com.quecomemos.receta.Receta;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Sergio
 */
@Entity
@Table(name = "ingredientes")
public class Ingrediente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ingrediente_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIngrediente;

    @Column(name = "nombre_ingrediente")
    private String nombreIngrediente;

    @ManyToMany(mappedBy = "ingredientes", cascade = {CascadeType.ALL})
    private List<Receta> receta;

    public Integer getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(Integer idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public void setNombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }

    public List<Receta> getReceta() {
        return receta;
    }

    public void setReceta(List<Receta> receta) {
        this.receta = receta;
    }

    @Override
    public String toString() {
        return nombreIngrediente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idIngrediente);
        hash = 97 * hash + Objects.hashCode(this.nombreIngrediente);
        hash = 97 * hash + Objects.hashCode(this.receta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ingrediente other = (Ingrediente) obj;
        if (!Objects.equals(this.nombreIngrediente, other.nombreIngrediente)) {
            return false;
        }
        if (!Objects.equals(this.idIngrediente, other.idIngrediente)) {
            return false;
        }
        return Objects.equals(this.receta, other.receta);
    }
    
    

}
