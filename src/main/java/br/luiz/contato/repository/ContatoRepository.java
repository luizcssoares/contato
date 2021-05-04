package br.luiz.contato.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.luiz.contato.entity.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{
	
	@Query(value="Select * from Contato e Where e.nome LIKE %:search", nativeQuery=true)
	public List<Contato> findBySearch(@Param("search") String search);
	
	@Query(value="Select * from Contato", nativeQuery=true)
	public List<Contato> findAll();

}
