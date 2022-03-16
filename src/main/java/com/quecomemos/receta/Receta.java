package com.quecomemos.receta;

import com.quecomemos.Ingredientes.Ingrediente;
import com.quecomemos.foto.Foto;

import com.quecomemos.enumeraciones.Categoria;
import com.quecomemos.enumeraciones.Complejidad;
import com.quecomemos.enumeraciones.ValorCalorico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

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

    @OneToOne
    private Foto foto;

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + Objects.hashCode(this.procedimiento);
        hash = 79 * hash + Objects.hashCode(this.duracion);
        hash = 79 * hash + Objects.hashCode(this.complejidad);
        hash = 79 * hash + Objects.hashCode(this.categoria);
        hash = 79 * hash + Objects.hashCode(this.valorCalorico);
        hash = 79 * hash + Objects.hashCode(this.ingredientes);
        hash = 79 * hash + Objects.hashCode(this.cantidad);
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
        final Receta other = (Receta) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.procedimiento, other.procedimiento)) {
            return false;
        }
        if (!Objects.equals(this.duracion, other.duracion)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.complejidad != other.complejidad) {
            return false;
        }
        if (this.categoria != other.categoria) {
            return false;
        }
        if (this.valorCalorico != other.valorCalorico) {
            return false;
        }
        if (!Objects.equals(this.ingredientes, other.ingredientes)) {
            return false;
        }
        return Objects.equals(this.cantidad, other.cantidad);
    }
    
    

}
