package it.uniroma3.siw.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.siw.model.Post;
import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.service.CredenzialiService;
import it.uniroma3.siw.service.PostService;


@Controller
public class GeneralController {

    private final CredenzialiService credenzialiService;
    private final PostService postService;

    public GeneralController(CredenzialiService credenzialiService, PostService postService) {
        this.credenzialiService = credenzialiService;
        this.postService = postService;
    }

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
    
}
