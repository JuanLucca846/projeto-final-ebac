package br.com.juan.memelandia.Usuario.services;

import br.com.juan.memelandia.Usuario.entities.Usuario;
import br.com.juan.memelandia.Usuario.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    IUsuarioRepository usuarioRepository;

    public Usuario novoUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listaUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }
}
