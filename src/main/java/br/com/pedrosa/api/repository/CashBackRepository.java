package br.com.pedrosa.api.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pedrosa.api.domain.CashBack;

public interface CashBackRepository extends JpaRepository<CashBack, Long> {
	
	Set<CashBack> findByIdVenda(Long idVenda);
}
