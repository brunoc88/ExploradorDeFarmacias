package com.softulp.exploradordefarmacias.modelo;

public class Farmacia {
    private String nombre;
    private String direccion;
    private int foto;
    private String horario;

    public Farmacia(String nombre, int foto, String horario, String direccion) {
        this.nombre = nombre;
        this.foto = foto;
        this.horario = horario;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }


    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
