package br.com.fiap.easyfin.repository;

import br.com.fiap.easyfin.model.MetaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaRepository extends JpaRepository<MetaModel, Long> {
}
