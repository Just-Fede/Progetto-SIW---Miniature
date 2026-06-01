package it.uniroma3.siw.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.uniroma3.siw.model.Post;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

@Query("""
    select distinct p
    from Post p
    left join fetch p.immagini
    left join fetch p.upVotes
    left join fetch p.utente
""")
List<Post> findAll();
}
