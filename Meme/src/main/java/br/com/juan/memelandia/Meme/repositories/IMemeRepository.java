package br.com.juan.memelandia.Meme.repositories;

import br.com.juan.memelandia.Meme.entities.Meme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMemeRepository extends JpaRepository<Meme, Long> {

}
