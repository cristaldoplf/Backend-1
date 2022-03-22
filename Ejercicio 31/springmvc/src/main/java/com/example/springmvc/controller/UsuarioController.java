package com.example.springmvc.controller;

import com.example.springmvc.dominio.Usuario;
import com.example.springmvc.services.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    private UsuarioService usuarioServicie = new UsuarioService();

    @GetMapping("/")
    public Usuario crearUsuario() {
        return usuarioServicie.crearUsuario();
    }

    @GetMapping("crear2")
    public Usuario crearUsuario2() {
        Usuario usuario = new Usuario("Leonel",88);
        return usuario;
    }
}
