package br.com.fiap.easyfin.repository;

import br.com.fiap.easyfin.model.InvestimentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestimentosRepository extends JpaRepository<InvestimentoModel, Long> {
}
