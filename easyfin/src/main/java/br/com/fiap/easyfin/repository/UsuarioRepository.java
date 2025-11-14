package br.com.fiap.easyfin.repository;

import br.com.fiap.easyfin.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
}
