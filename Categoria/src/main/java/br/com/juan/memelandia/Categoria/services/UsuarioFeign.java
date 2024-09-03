package br.com.juan.memelandia.Categoria.services;

import br.com.juan.memelandia.Categoria.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USUARIO", url = "http://localhost:8080/")
public interface UsuarioFeign {

    @GetMapping("/usuarios/{id}")
    UsuarioDTO buscarUsuarioPorId(@PathVariable Long id);
}
