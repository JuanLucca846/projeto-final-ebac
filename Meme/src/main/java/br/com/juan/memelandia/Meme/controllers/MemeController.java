package br.com.juan.memelandia.Meme.controllers;

import br.com.juan.memelandia.Meme.entities.Meme;
import br.com.juan.memelandia.Meme.services.MemeService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/meme")
public class MemeController {

    private static final Logger logger = LoggerFactory.getLogger(MemeController.class)

    @Autowired
    private MemeService memeService;

    @PostMapping("/criar")
    public ResponseEntity<Meme> criarMeme(@RequestBody @Valid Meme meme) {
        logger.info("Criando um novo meme com dados: {}", meme);
        meme.setDataCadastro(LocalDateTime.now());
        Meme novoMeme = memeService.novoMeme(meme);
        logger.info("Meme criado com sucesso: {}", novoMeme);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoMeme);
    }

    @GetMapping("/listarmemes")
    public ResponseEntity<List<Meme>> listarMemes() {
        logger.info("Listando todos os memes");
        List<Meme> memes = memeService.listaMeme();
        logger.info("Número de memes encontrados: {}", memes.size());
        return ResponseEntity.status(HttpStatus.OK).body(memes);
    }
}
