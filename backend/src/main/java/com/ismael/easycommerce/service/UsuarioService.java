package com.ismael.easycommerce.service;

import com.ismael.easycommerce.model.Usuario;
import com.ismael.easycommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario salvar(Usuario usuario){
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));

        if (!usuario.getRole().startsWith("ROLE_")){
            usuario.setRole("ROLE_" + usuario.getRole().toUpperCase());
        }

        return usuarioRepository.save(usuario);
    }

    public void deletarByUsername(String username){
        Long idDoUsuario = usuarioRepository.buscarIdPorUsername(username);
        usuarioRepository.deleteById(idDoUsuario);
    }

    public List<Usuario> listarTudo(){
        return usuarioRepository.findAll();
    }
}
