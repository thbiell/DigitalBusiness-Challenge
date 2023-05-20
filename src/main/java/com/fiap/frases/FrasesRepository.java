

package com.fiap.frases;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface FrasesRepository extends JpaRepository<Frase, Long>{
	
	Page<Frase> findAllByAtivoTrue(Pageable paginacao);
	
}
