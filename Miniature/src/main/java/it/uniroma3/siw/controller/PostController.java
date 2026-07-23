package it.uniroma3.siw.controller;

import java.util.*;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import static it.uniroma3.siw.SecurityConfiguration.ROLE_ADMIN;
import it.uniroma3.siw.model.Commento;
import it.uniroma3.siw.model.Credenziali;
import it.uniroma3.siw.model.Post;
import it.uniroma3.siw.model.ProdottoOriginale;
import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.service.CredenzialiService;
import it.uniroma3.siw.service.PostService;
import it.uniroma3.siw.service.ProdottoOriginaleService;
import it.uniroma3.siw.service.UpVoteService;

@Controller
public class PostController {

    private final PostService postService;
    private final ProdottoOriginaleService prodottoOriginaleService;
    private final UpVoteService upVoteService;
    private final CredenzialiService credenzialiService;

    public PostController(
            PostService postService,
            ProdottoOriginaleService prodottoOriginaleService,
            UpVoteService upVoteService,
            CredenzialiService credenzialiService
    ) {
        this.postService = postService;
        this.prodottoOriginaleService = prodottoOriginaleService;
        this.upVoteService = upVoteService;
        this.credenzialiService = credenzialiService;
    }

    // #########################################[CONTROLLER PAGINA INDEX]#########################################################################
    @GetMapping("/")
    public String home(@AuthenticationPrincipal UserDetails userDetails, Model model) {

        if (userDetails != null) {
            Utente utente = credenzialiService
                    .getCredenziali(userDetails.getUsername())
                    .getUtente();

            model.addAttribute("utente", utente);

        }

        List<Post> elencoPost = this.postService.findAll();

        model.addAttribute("posts", elencoPost);

        return "/public/index";
    }

    @GetMapping("/admin/index")
    public String getAdminIndex() {
        return "/admin/index";
    }

    /*#########################################[CONTROLLER POST]#########################################################################*/

    @GetMapping("/post/create")
    public String getPostForm(Model model) {
        List<ProdottoOriginale> prodotti = this.prodottoOriginaleService.findAll();
        model.addAttribute("prodottiOriginali", prodotti);

        return "/user/postForm";
    }

    @PostMapping("/post/create")
    public String postPostForm(
            @RequestParam String titolo,
            @RequestParam String descrizione,
            @RequestParam(required = false) Long prodottoId,
            @RequestParam("copertina") MultipartFile immagineCopertina,
            @RequestParam(value = "altreImmagini", required = false) MultipartFile[] altreImmagini,
            @AuthenticationPrincipal UserDetails userDetails
    ) {

        if (userDetails == null) {
            return "redirect:/login";
        }

        Credenziali credenziali = credenzialiService
                .getCredenzialiByUsername(userDetails.getUsername());

        postService.createPost(
                titolo,
                descrizione,
                prodottoId,
                immagineCopertina,
                altreImmagini,
                credenziali.getUtente()
        );

        return "redirect:/";
    }

    /*#########################################[CONTROLLER UPVOTE]#########################################################################*/
    @PostMapping("/post/{id}/upVote")
    public String upVotePost(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {

        if (userDetails == null) {
            return "redirect:/login";
        }

        Post post = postService.findById(id);

        Utente utente = credenzialiService
                .getCredenzialiByUsername(userDetails.getUsername())
                .getUtente();

        upVoteService.toggleUpVote(post, utente);
        return "redirect:/";
    }

    /*#########################################[CONTROLLER POST]#########################################################################*/

    @GetMapping("/post/{id}")
    public String getPost(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails, Model model) {
        Post post = postService.findById(id);
        model.addAttribute("post", post);

        if (userDetails != null) {
            Utente utenteLoggato = this.credenzialiService.getCredenzialiByUsername(userDetails.getUsername()).getUtente();
            model.addAttribute("utenteLoggato", utenteLoggato);
        }

        Set<Commento> commenti = post.getCommenti();
        model.addAttribute("commenti", commenti);
        return "/public/post";
    }

    @PostMapping("/post/delete/{id}")
    public String deletePost(@PathVariable Long id,
            @AuthenticationPrincipal UserDetails userDetails) {

        if (userDetails == null) {
            return "redirect:/login";
        }

        Post post = postService.findById(id);

        Credenziali credenziali
                = credenzialiService.getCredenzialiByUsername(userDetails.getUsername());

        boolean admin = credenziali.getRole().equals(ROLE_ADMIN);

        boolean proprietario
                = credenziali.getUtente().getId().equals(post.getUtente().getId());

        if (!admin && !proprietario) {
            return "error/403";
        }

        postService.delete(post);

        return "redirect:/";
    }

}
