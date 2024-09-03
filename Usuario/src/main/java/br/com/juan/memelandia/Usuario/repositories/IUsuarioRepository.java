package br.com.juan.memelandia.Usuario.repositories;

import br.com.juan.memelandia.Usuario.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
}
