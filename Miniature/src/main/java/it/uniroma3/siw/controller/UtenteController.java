package it.uniroma3.siw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.uniroma3.siw.model.Credenziali;
import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.service.UtenteService;
import it.uniroma3.siw.service.CredenzialiService;

@Controller
public class UtenteController 
{
    private final UtenteService utenteService;
    @SuppressWarnings("unused")
    private final CredenzialiService credenzialiService;

    public UtenteController(UtenteService utenteService, CredenzialiService credenzialiService) 
    {
        this.utenteService = utenteService;
        this.credenzialiService = credenzialiService;
    }

    @GetMapping("/profilo/{id}")
    public String getProfilo(@PathVariable("id") Long id, Model model) 
    {
        Utente utente = this.utenteService.getUtente(id);
        Credenziali credenziali = utente.getCredenziali();

        model.addAttribute("utente", utente);
        model.addAttribute("credenziali", credenziali);

        return "/user/profilo";
    }
}
