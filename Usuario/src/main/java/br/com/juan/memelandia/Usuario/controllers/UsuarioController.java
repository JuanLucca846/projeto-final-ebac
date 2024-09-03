package br.com.juan.memelandia.Usuario.controllers;

import br.com.juan.memelandia.Usuario.entities.Usuario;
import br.com.juan.memelandia.Usuario.services.UsuarioService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/criar")
    public ResponseEntity<Usuario> novoUsuario(@RequestBody @Valid Usuario usuario) {
        logger.info("Criando novo usuário: {}", usuario);
        Usuario novoUsuario = usuarioService.novoUsuario(usuario);
        logger.info("Usuário criado com sucesso: {}", novoUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @GetMapping("/listarusuarios")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        logger.info("Listando todos os usuários");
        List<Usuario> usuarios = usuarioService.listaUsuarios();
        logger.info("Usuários listados com sucesso, total {}", usuarios.size());
        return ResponseEntity.status(HttpStatus.OK).body(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> buscarUsuarioPorId(@PathVariable Long id) {
        logger.info("Buscando usuário com ID: {}", id);

        Optional<Usuario> pessoa = usuarioService.buscarUsuarioPorId(id);
        if (pessoa.isEmpty()) {
            logger.warn("Usuário com ID {} não encontrado", id);
            return ResponseEntity.notFound().build();
        }

        logger.info("Usuário com ID {} encontrado", id);
        return ResponseEntity.ok(pessoa);
    }


}
