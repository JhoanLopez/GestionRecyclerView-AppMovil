package com.jhoanlopez.gestiondecontactos;

import java.io.Serializable;

public class ListElement implements Serializable {
    public String color;
    public String nombre;
    public String ciudad;
    public String status;


    public ListElement(String color, String nombre, String ciudad, String status) {
        this.color = color;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
