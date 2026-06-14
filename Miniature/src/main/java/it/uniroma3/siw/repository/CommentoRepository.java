package it.uniroma3.siw.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Commento;
import it.uniroma3.siw.model.Post;

public interface CommentoRepository extends CrudRepository<Commento, Long> 
{
	void deleteByPost(Post post);
}
