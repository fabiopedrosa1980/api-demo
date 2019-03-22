package br.com.pedrosa.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.pedrosa.api.domain.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	@Query(value = "SELECT * FROM Sale s WHERE s.date_sale BETWEEN ?1 AND ?2 ORDER BY s.date_sale DESC",
		   countQuery = "SELECT count(*) FROM Sale s WHERE s.date_sale BETWEEN :startDate AND :endDate",
	       nativeQuery = true)
	Page<Sale> findAllSallesByPeriod(String startDate, String endDate, Pageable page);
	
}
