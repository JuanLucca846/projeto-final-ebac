package br.com.juan.memelandia.Categoria.controllers;

import br.com.juan.memelandia.Categoria.entities.Categoria;
import br.com.juan.memelandia.Categoria.services.CategoriaService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private static final Logger logger = LoggerFactory.getLogger(CategoriaController.class);


    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/criar")
    public ResponseEntity<Categoria> novaCategoria(@RequestBody @Valid Categoria categoria) {
        categoria.setDataCadastro(LocalDateTime.now());
        logger.info("Criando nova categoria: {}", categoria);
        Categoria novaCategoria = categoriaService.novaCategoria(categoria);
        logger.info("Categoria criada com sucesso {}", novaCategoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCategoria);
    }

    @GetMapping("/listarcategorias")
    public ResponseEntity<List<Categoria>> listarCategorias() {
        logger.info("Listando todas as categorias");
        List<Categoria> categorias = categoriaService.listaCategorias();
        logger.info("Categorias listadas com sucesso, total {}", categorias.size());
        return ResponseEntity.status(HttpStatus.OK).body(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Categoria>> buscarCategoriaPorId(@PathVariable Long id) {
        logger.info("Buscando categoria por ID: {}", id);
        Optional<Categoria> categoria = categoriaService.buscarCategoriaPorId(id);
        if (categoria.isEmpty()) {
            logger.warn("Categoria com ID {} não encontrada", id);
            return ResponseEntity.notFound().build();
        }
        logger.info("Categoria encontrada com sucesso {}", categoria);
        return ResponseEntity.ok(categoria);
    }
}
