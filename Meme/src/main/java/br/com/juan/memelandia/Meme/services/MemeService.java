package br.com.juan.memelandia.Meme.services;

import br.com.juan.memelandia.Meme.dto.CategoriaDTO;
import br.com.juan.memelandia.Meme.dto.UsuarioDTO;
import br.com.juan.memelandia.Meme.entities.Meme;
import br.com.juan.memelandia.Meme.repositories.IMemeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemeService {

    @Autowired
    IMemeRepository memeRepository;

    @Autowired
    UsuarioFeign usuarioFeign;

    @Autowired
    CategoriaFeign categoriaFeign;


    @Transactional
    public Meme novoMeme(Meme meme) {
        if (meme.getIdUsuario() != null) {
            UsuarioDTO usuario = usuarioFeign.buscarUsuarioPorId(meme.getIdUsuario()).getBody();
            if (usuario == null) {
                throw new IllegalArgumentException("Usuário não encontrado");
            }
        } else {
            throw new IllegalArgumentException("ID do usuário não pode ser nulo");
        }

        if (meme.getIdCategoriaMeme() != null) {
            CategoriaDTO categoria = categoriaFeign.buscarCategoriaPorId(meme.getIdCategoriaMeme()).getBody();
            if (categoria == null) {
                throw new IllegalArgumentException("Categoria não encontrada");
            }
        } else {
            throw new IllegalArgumentException("ID da categoria não pode ser nulo");
        }

        return memeRepository.save(meme);
    }


    public List<Meme> listaMeme() {
        return memeRepository.findAll();
    }
}
