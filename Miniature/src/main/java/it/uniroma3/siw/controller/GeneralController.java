package it.uniroma3.siw.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.service.CredenzialiService;

@Controller
public class GeneralController 
{
    private final CredenzialiService credenzialiService;

    public GeneralController(CredenzialiService credenzialiService) 
    {
        this.credenzialiService = credenzialiService;
    }
    
@GetMapping("/")
public String home(@AuthenticationPrincipal UserDetails userDetails, Model model) {

    if (userDetails != null) {
        Utente utente = credenzialiService
                .getCredenziali(userDetails.getUsername())
                .getUtente();

        model.addAttribute("utente", utente);
    }

    return "/public/index";
}

    

}
