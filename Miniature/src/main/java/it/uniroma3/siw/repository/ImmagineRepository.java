package it.uniroma3.siw.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Immagine;
import it.uniroma3.siw.model.Post;

public interface ImmagineRepository extends CrudRepository<Immagine, Long> {

	void deleteByPost(Post post);
    
}
