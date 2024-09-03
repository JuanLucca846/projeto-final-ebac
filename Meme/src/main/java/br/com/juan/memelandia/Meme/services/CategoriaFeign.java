package br.com.juan.memelandia.Meme.services;

import br.com.juan.memelandia.Meme.dto.CategoriaDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CATEGORIA", url = "http://localhost:8081")
public interface CategoriaFeign {
    @GetMapping("/categoria/{id}")
    ResponseEntity<CategoriaDTO> buscarCategoriaPorId(@PathVariable Long id);
}
