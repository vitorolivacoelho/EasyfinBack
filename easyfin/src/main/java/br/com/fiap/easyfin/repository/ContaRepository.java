package br.com.fiap.easyfin.repository;

import br.com.fiap.easyfin.model.ContaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<ContaModel, Long> {
}
