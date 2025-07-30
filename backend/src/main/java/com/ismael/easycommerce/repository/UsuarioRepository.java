package com.ismael.easycommerce.repository;

import com.ismael.easycommerce.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);

    @Query("SELECT u.id FROM Usuario u WHERE u.username =:username")
    Long buscarIdPorUsername(@Param("username") String username);

}
