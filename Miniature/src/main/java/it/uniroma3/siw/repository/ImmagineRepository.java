package it.uniroma3.siw.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Immagine;

@Repository
public interface ImmagineRepository extends CrudRepository<Immagine, Long> {
    
}
