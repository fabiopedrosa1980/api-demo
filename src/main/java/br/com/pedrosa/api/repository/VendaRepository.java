package br.com.pedrosa.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.pedrosa.api.domain.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
	
	@Query(value = "SELECT * FROM Venda v WHERE v.data_venda BETWEEN ?1 AND ?2 ORDER BY v.data_venda DESC",
		   countQuery = "SELECT count(*) FROM Venda v WHERE v.data_venda BETWEEN :startDate AND :endDate",
	       nativeQuery = true)
	Page<Venda> findAllSallesByPeriod(String startDate, String endDate, Pageable page);
	
}
