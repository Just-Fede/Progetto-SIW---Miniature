package it.uniroma3.siw.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import it.uniroma3.siw.model.Credenziali;
import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.service.CredenzialiService;
import it.uniroma3.siw.service.UtenteService;

@Controller
public class UtenteController {

    private final UtenteService utenteService;
    private final CredenzialiService credenzialiService;

    public UtenteController(UtenteService utenteService, CredenzialiService credenzialiService) {
        this.utenteService = utenteService;
        this.credenzialiService = credenzialiService;
    }

    @GetMapping("/profilo/{id}")
    public String getProfilo(@PathVariable("id") Long id, Model model, Authentication auth) {

        if (auth != null) {
            Credenziali credenzialiLoggate = credenzialiService.getCredenzialiByUsername(auth.getName());
            Utente utenteLoggato = credenzialiLoggate.getUtente();
            model.addAttribute("utenteLoggato", utenteLoggato);
        }

        Utente utente = this.utenteService.getUtente(id);
        model.addAttribute("utente", utente);

        return "/public/profilo";
    }

    @GetMapping("/utente/{id}/form")
    public String getForm(@PathVariable("id") Long id, Model model, Authentication auth) {

        if (auth == null) {
            return "redirect:/login";
        }

        if (!credenzialiService
                .getCredenzialiByUsername(auth.getName())
                .getUtente()
                .getId()
                .equals(id)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Accesso negato");
        }

        Utente utente = utenteService.getUtente(id);
        model.addAttribute(utente);
        //model.addAttribute(utente.getCredenziali());
        return "/user/utenteForm";
    }

    @PostMapping("/utente/{id}/form")
    public String updateUtente
        (
            @PathVariable("id") Long id,
            @RequestParam String bio,
            @RequestParam("fileFoto") MultipartFile file
        )
        throws IOException 
        {

        Utente utente = utenteService.getUtente(id);

        utente.setBio(bio);

        if (!file.isEmpty()) {

            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

            Path path = Paths.get("uploads/avatar/" + fileName);

            Files.copy(file.getInputStream(), path);

            utente.setUrlFotoProfilo("/uploads/avatar/" + fileName);
        }

        utenteService.save(utente);

        return "redirect:/profilo/" + id;
    }

}
