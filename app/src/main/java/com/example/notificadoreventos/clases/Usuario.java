package com.example.notificadoreventos.clases;

import java.util.*;

public class Usuario {
    private String nombre, contrasena;
    private List<String> categoriasInteres;

    public Usuario(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.categoriasInteres = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public String getContrasena() { return contrasena; }

    public void agregarCategoria(String categoria) {
        if (!categoriasInteres.contains(categoria)) categoriasInteres.add(categoria);
    }

    public List<String> getCategoriasInteres() {
        return categoriasInteres;
    }
}
