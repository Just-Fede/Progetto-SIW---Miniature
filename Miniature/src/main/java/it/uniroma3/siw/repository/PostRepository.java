package it.uniroma3.siw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.uniroma3.siw.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("""
    select distinct p
    from Post p
    left join fetch p.immagini
    left join fetch p.upVotes
    left join fetch p.utente
""")
    @Override
    List<Post> findAll();
}
