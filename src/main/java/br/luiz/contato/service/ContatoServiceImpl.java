package br.luiz.contato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.luiz.contato.entity.Contato;
import br.luiz.contato.repository.ContatoRepository;

@Service
public class ContatoServiceImpl implements ContatoService{

	  @Autowired
	  private ContatoRepository repo;
	  
	  @Override
	  public List<Contato> findBySearch(String search) {
		   return repo.findBySearch(search);  
	  }
	  
	  public List<Contato> listAll() {
	        return repo.findAll();
	  }
	     
	  public void save(Contato contato) {
	        repo.save(contato);
	  }
	     
	  public Contato get(long id) {
	        return repo.findById(id).get();
	  }
	     
	  public void delete(long id) {
	        repo.deleteById(id);
	  }
}
