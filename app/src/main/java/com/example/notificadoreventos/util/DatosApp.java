package com.example.notificadoreventos.util;

import com.example.notificadoreventos.clases.Evento;
import com.example.notificadoreventos.clases.Usuario;

import java.util.*;

public class DatosApp {
    private static DatosApp instancia;
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Evento> eventos = new ArrayList<>();
    private Usuario usuarioActual;

    public static DatosApp getInstancia() {
        if (instancia == null) instancia = new DatosApp();
        return instancia;
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public boolean iniciarSesion(String nombre, String pass) {
        for (Usuario u : usuarios) {
            if (u.getNombre().equals(nombre) && u.getContrasena().equals(pass)) {
                usuarioActual = u;
                return true;
            }
        }
        return false;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void crearEvento(Evento evento) {
        eventos.add(evento);
    }

    public List<String> listarEventosTexto() {
        List<String> lista = new ArrayList<>();
        for (Evento e : eventos) {
            lista.add(e.toString() + "\n");
        }
        return lista;
    }

    public List<String> getEventosInteres() {
        List<String> lista = new ArrayList<>();
        for (Evento e : eventos) {
            if (usuarioActual.getCategoriasInteres().contains(e.getCategoria())) {
                lista.add(e.toString() + "\n");
            }
        }
        return lista;
    }
}
