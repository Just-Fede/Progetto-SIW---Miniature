package it.uniroma3.siw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.siw.model.Post;

@Repository
public interface PostRepository extends CrudRepository<Post,Long> {

}
