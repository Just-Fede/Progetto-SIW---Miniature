package it.uniroma3.siw.service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import it.uniroma3.siw.model.Post;
import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.repository.PostRepository;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final ProdottoOriginaleService prodottoOriginaleService;
    private final ImmagineService immagineService;
    private final CommentoService commentoService;
    private final UpVoteService upVoteService;

    public PostService(
            PostRepository postRepository,
            ProdottoOriginaleService prodottoOriginaleService,
            ImmagineService immagineService,
            CommentoService commentoService,
            UpVoteService upVoteService
    ) {

        this.postRepository = postRepository;
        this.prodottoOriginaleService = prodottoOriginaleService;
        this.immagineService = immagineService;
        this.commentoService = commentoService;
        this.upVoteService = upVoteService;
    }

    @Transactional
    public Post createPost(
            String titolo,
            String descrizione,
            Long prodottoId,
            MultipartFile copertina,
            MultipartFile[] altreImmagini,
            Utente utente
    ) {

        Post post = new Post();
        post.setTitolo(titolo);
        post.setDescrizione(descrizione);
        post.setData(LocalDate.now());
        post.setUtente(utente);

        if (prodottoId != null) {
            post.setProdottoOriginale(
                    prodottoOriginaleService.findById(prodottoId)
            );
        }

        postRepository.save(post);

        immagineService.salvaCopertina(post, copertina);

        if (altreImmagini != null) {
            immagineService.salvaGalleria(post, altreImmagini);
        }

        return post;
    }
 
    @Transactional(readOnly = true)
    public List<Post> findAll() 
    {

        
        List<Post> posts = postRepository.findAll();
        
        Collections.sort(posts, new Comparator<Post>() 
        {
            @Override
            public int compare(Post p1, Post p2)
            {
                int cmp = p2.getUpVotes().size() - p1.getUpVotes().size();
                if(cmp != 0)
                    return cmp;
                return p2.getData().compareTo(p1.getData());
            }    
        });

       return posts;
    }

    @Transactional(readOnly = true)
    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Transactional
    public void delete(Post post) 
    {
        this.commentoService.deleteByPost(post);
        this.upVoteService.deleteByPost(post);
        this.immagineService.deleteByPost(post);

        this.postRepository.delete(post);
    }

}
