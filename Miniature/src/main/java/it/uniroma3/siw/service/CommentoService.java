package it.uniroma3.siw.service;

import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Commento;
import it.uniroma3.siw.repository.CommentoRepository;
import it.uniroma3.siw.model.Post;

@Service
public class CommentoService {

    public final CommentoRepository commentoRepository;

    public CommentoService(CommentoRepository commentoRepository) {
        this.commentoRepository = commentoRepository;
    }

    public void save(Commento commento) {
        this.commentoRepository.save(commento);
    }
    
    public void deleteByPost(Post post)
    {
    	this.commentoRepository.deleteByPost(post);
    }

}
