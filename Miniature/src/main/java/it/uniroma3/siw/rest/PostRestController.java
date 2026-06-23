package it.uniroma3.siw.rest;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.siw.model.Post;
import it.uniroma3.siw.service.PostService;

@RestController
@RequestMapping("/rest/posts")
@CrossOrigin(origins = "http://localhost:5173")
public class PostRestController {

    private final PostService postService;

    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    // GET /rest/posts → Ritorna tutti i post da filtrare su React
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = this.postService.findAll(); // Assicurati di avere questo metodo nel Service
        return posts != null && !posts.isEmpty()
            ? ResponseEntity.ok(posts)
            : ResponseEntity.notFound().build();
    }
}