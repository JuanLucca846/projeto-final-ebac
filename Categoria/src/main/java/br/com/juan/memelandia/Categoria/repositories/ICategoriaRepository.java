package br.com.juan.memelandia.Categoria.repositories;

import br.com.juan.memelandia.Categoria.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Long> {
}
