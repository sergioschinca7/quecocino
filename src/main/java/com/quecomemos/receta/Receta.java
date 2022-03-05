/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quecomemos.receta;

import com.quecomemos.Ingredientes.Ingrediente;
import com.quecomemos.enumeraciones.Categoria;
import com.quecomemos.enumeraciones.Complejidad;
import com.quecomemos.enumeraciones.ValorCalorico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Sergio
 */
@Entity
@Table(name = "recetas")
public class Receta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    @Column(length = 4000)
    private String procedimiento;

    private String duracion;

    @Enumerated(EnumType.STRING)
    private Complejidad complejidad;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    private ValorCalorico valorCalorico;

    @ManyToMany
    @JoinTable(name = "receta_ingredientes", joinColumns = {
        @JoinColumn(name = "receta_id")}, inverseJoinColumns = {
        @JoinColumn(name = "ingrediente_id")
    }
    )
    private List<Ingrediente> ingredientes = new ArrayList<>();

    @Column(name = "cantidad", columnDefinition = "LONGBLOB")
    private ArrayList<String> cantidad = new ArrayList();

    public Ingrediente getIngrediente(int i) {
        return this.ingredientes.get(i);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProcedimiento() {
        return procedimiento;
    }

    public ValorCalorico getValorCalorico() {
        return valorCalorico;
    }

    public void setValorCalorico(ValorCalorico valorCalorico) {
        this.valorCalorico = valorCalorico;
    }

    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Complejidad getComplejidad() {
        return complejidad;
    }

    public void setComplejidad(Complejidad complejidad) {
        this.complejidad = complejidad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public ArrayList<String> getCantidad() {
        return cantidad;
    }

    public void setCantidad(ArrayList<String> cantidad) {
        this.cantidad = cantidad;
    }

    public void setearCantidad(String cant) {

        cantidad.add(cant);

    }

}
