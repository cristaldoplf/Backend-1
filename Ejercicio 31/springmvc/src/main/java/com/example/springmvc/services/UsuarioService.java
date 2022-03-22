package com.example.springmvc.services;

import com.example.springmvc.dominio.Usuario;

public class UsuarioService {
    public Usuario crearUsuario(){
        Usuario usuario = new Usuario("Pablo",33);
        return usuario;
    }
}
