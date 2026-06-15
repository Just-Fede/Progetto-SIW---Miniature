package it.uniroma3.siw.controller;

import java.time.LocalDate;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.model.Commento;
import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.service.CommentoService;
import it.uniroma3.siw.service.CredenzialiService;
import it.uniroma3.siw.service.PostService;

@Controller
public class CommentoController {

    public final CredenzialiService credenzialiService;
    public final PostService postService;
    public final CommentoService commentoService;

    public CommentoController(CredenzialiService credenzialiService, PostService postService, CommentoService commentoService) {
        this.credenzialiService = credenzialiService;
        this.postService = postService;
        this.commentoService = commentoService;
    }

    @GetMapping("/user/{id}/commentoForm")
    public String commentoForm(@AuthenticationPrincipal UserDetails userDetails,
            Model model,
            @PathVariable Long id
    ) {
        if (userDetails != null) {
            Utente utente = credenzialiService
                    .getCredenziali(userDetails.getUsername())
                    .getUtente();

            model.addAttribute("utente", utente);
            model.addAttribute("post", postService.findById(id));

        }
        return "/user/commentoForm";
    }

    @PostMapping("/user/{id}/commentoForm")
    public String commentoForm(
            @PathVariable Long id,
            @RequestParam String titolo,
            @RequestParam String testo,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        Commento commentoNew = new Commento();

        commentoNew.setTitolo(titolo);
        commentoNew.setTesto(testo);
        commentoNew.setData(LocalDate.now());

        commentoNew.setUtente(credenzialiService.getCredenziali(userDetails.getUsername()).getUtente());
        commentoNew.setPost(postService.findById(id));

        commentoService.save(commentoNew);

        return "redirect:/post/" + id;
    }

}
 