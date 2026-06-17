package it.uniroma3.siw.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
public String updateUtente(
        @PathVariable("id") Long id,
        @RequestParam String bio,
        @RequestParam String username,
        @RequestParam("fileFoto") MultipartFile file,
        jakarta.servlet.http.HttpServletRequest request // <-- Ci serve per resettare la sessione nel browser
    ) throws IOException {

    Utente utente = utenteService.getUtente(id);
    utente.setBio(bio);

    // 1. Controlliamo se lo username è stato effettivamente modificato
    String vecchioUsername = utente.getCredenziali().getUsername();
    boolean usernameCambiato = !vecchioUsername.equalsIgnoreCase(username);

    if (utente.getCredenziali() != null) {
        utente.getCredenziali().setUsername(username);
        credenzialiService.saveCredenziali(utente.getCredenziali());
    }

    // 2. Gestione Foto Profilo
    if (!file.isEmpty()) {
        Path uploadDir = Paths.get("uploads/avatar");
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path path = uploadDir.resolve(fileName);
        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        utente.setUrlFotoProfilo("/uploads/avatar/" + fileName);
    }

    // 3. Salviamo l'utente nel DB
    utenteService.save(utente);

    // 4. Se ha cambiato username, facciamo il logout forzato per ripulire i cookie del browser
    if (usernameCambiato) {
        jakarta.servlet.http.HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Svuota la sessione del browser
        }
        org.springframework.security.core.context.SecurityContextHolder.clearContext(); // Svuota Spring Security
        
        // Lo mandiamo al login dicendogli che è andato tutto a buon fine
        return "redirect:/login?usernameCambiato=true"; 
    }

    // Se ha cambiato solo bio o foto, torna al profilo normalmente senza disconnetterlo
    return "redirect:/profilo/" + id;
}

}
