package br.com.juan.memelandia.Categoria.services;

import br.com.juan.memelandia.Categoria.dto.UsuarioDTO;
import br.com.juan.memelandia.Categoria.entities.Categoria;
import br.com.juan.memelandia.Categoria.repositories.ICategoriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    ICategoriaRepository categoriaRepository;

    @Autowired
    UsuarioFeign usuarioFeign;


    @Transactional
    public Categoria novaCategoria(Categoria categoria) {
        if (categoria.getUsuarioId() != null) {
            UsuarioDTO usuario = usuarioFeign.buscarUsuarioPorId(categoria.getUsuarioId());
            if (usuario == null) {
                throw new IllegalArgumentException("Usuário não encontrado");
            }
        } else {
            throw new IllegalArgumentException("ID não pode ser nulo");
        }
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listaCategorias() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscarCategoriaPorId(Long id) {
        return categoriaRepository.findById(id);
    }

}
