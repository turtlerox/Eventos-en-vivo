package com.example.notificadoreventos.clases;

public class Evento {
    private String categoria, fecha, hora, lugar, descripcion;

    public Evento(String categoria, String fecha, String hora, String lugar, String descripcion) {
        this.categoria = categoria;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.descripcion = descripcion;
    }

    public String getCategoria() { return categoria; }

    @Override
    public String toString() {
        return categoria + "\n" + fecha + " " + hora + "\n" + lugar + "\n" + descripcion;
    }
}
