package it.uniroma3.siw.service;



import org.springframework.stereotype.Service;

import it.uniroma3.siw.repository.UpVoteRepository;
import it.uniroma3.siw.model.Post;
import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.model.UpVote;
import jakarta.transaction.Transactional;

@Service
public class UpVoteService 
{
    private final UpVoteRepository upVoRepository;

    public UpVoteService(UpVoteRepository upVoRepository) 
    {
        this.upVoRepository = upVoRepository;
    }

    @Transactional
    public void toggleUpVote(Post post, Utente utente) 
    {
        if(upVoRepository.existsByPostAndUtente(post, utente)) {
            upVoRepository.deleteByPostAndUtente(post, utente);
        } else {
            UpVote upVote = new UpVote();
            upVote.setPost(post);
            upVote.setUtente(utente);
            upVoRepository.save(upVote);
        }
    }
}
