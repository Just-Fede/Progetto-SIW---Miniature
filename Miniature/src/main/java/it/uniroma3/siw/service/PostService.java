package it.uniroma3.siw.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import it.uniroma3.siw.model.Post;
import it.uniroma3.siw.repository.PostRepository;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final ProdottoOriginaleService prodottoOriginaleService;
    private final ImmagineService immagineService;

    public PostService(
        PostRepository postRepository,
        ProdottoOriginaleService prodottoOriginaleService,
        ImmagineService immagineService
    ) {

        this.postRepository = postRepository;
        this.prodottoOriginaleService = prodottoOriginaleService;
        this.immagineService = immagineService;
    }

    @Transactional
    public Post createPost(
            String titolo,
            String descrizione,
            Long prodottoId,
            MultipartFile copertina,
            MultipartFile[] altreImmagini
    ) {

        Post post = new Post();
        post.setTitolo(titolo);
        post.setDescrizione(descrizione);
        post.setData(LocalDate.now());

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
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null);
    }
}
