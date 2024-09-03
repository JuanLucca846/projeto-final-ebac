package br.com.juan.memelandia.Meme.services;

import br.com.juan.memelandia.Meme.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USUARIO", url = "http://localhost:8080")
public interface UsuarioFeign {
    @GetMapping("/usuarios/{id}")
    ResponseEntity<UsuarioDTO> buscarUsuarioPorId(@PathVariable Long id);
}
