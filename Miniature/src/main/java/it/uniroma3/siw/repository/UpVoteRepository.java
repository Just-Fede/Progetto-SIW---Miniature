package it.uniroma3.siw.repository;

import org.springframework.data.repository.CrudRepository;
import it.uniroma3.siw.model.Post;
import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.model.UpVote;

public interface UpVoteRepository extends CrudRepository<UpVote, Long> 
{
    boolean existsByPostAndUtente(Post post, Utente utente);
    void deleteByPostAndUtente(Post post, Utente utente);
}
