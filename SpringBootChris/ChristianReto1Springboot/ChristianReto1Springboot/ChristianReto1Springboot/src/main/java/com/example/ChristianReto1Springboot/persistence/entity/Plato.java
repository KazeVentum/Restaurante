package com.example.ChristianReto1Springboot.persistence.entity;

import jakarta.persistence.*;

@Entity
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombrePlato;

    @Column(name = "descripcion", nullable = false)
    private String descripcionPlato;

    @Column(name = "menu", nullable = false)
    private String menuPlato;

    @Column(name = "precio", nullable = false)
    private double precioPlato;

    public Plato() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public String getDescripcionPlato() {
        return descripcionPlato;
    }

    public void setDescripcionPlato(String descripcionPlato) {
        this.descripcionPlato = descripcionPlato;
    }

    public String getMenuPlato() {
        return menuPlato;
    }

    public void setMenuPlato(String menuPlato) {
        this.menuPlato = menuPlato;
    }

    public double getPrecioPlato() {
        return precioPlato;
    }

    public void setPrecioPlato(double precioPlato) {
        this.precioPlato = precioPlato;
    }

    @Override
    public String toString() {
        return "Plato{" +
                "id=" + id +
                ", nombrePlato='" + nombrePlato + '\'' +
                ", descripcionPlato='" + descripcionPlato + '\'' +
                ", menuPlato='" + menuPlato + '\'' +
                ", precioPlato=" + precioPlato +
                '}';
    }
}
