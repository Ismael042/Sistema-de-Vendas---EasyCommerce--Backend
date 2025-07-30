package com.ismael.easycommerce.controller;

import com.ismael.easycommerce.model.Usuario;
import com.ismael.easycommerce.repository.UsuarioRepository;
import com.ismael.easycommerce.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasAnyRole('ADMIN')")
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
        Usuario novousuario = usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novousuario);
    }


    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deletar(@PathVariable String username){
        usuarioService.deletarByUsername(username);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Usuario> listarTodos(){
        return usuarioService.listarTudo();
    }
}
