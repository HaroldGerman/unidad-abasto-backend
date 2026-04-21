package pe.edu.uni.abasto.unidad_abasto_backend.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.uni.abasto.unidad_abasto_backend.entities.Usuario;

@Repository

public interface  UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
