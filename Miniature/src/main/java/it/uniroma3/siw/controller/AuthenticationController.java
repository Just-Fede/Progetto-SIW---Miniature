package it.uniroma3.siw.controller;

import java.time.LocalDate;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.ui.Model;
import it.uniroma3.siw.model.Credenziali;
import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.service.CredenzialiService;
import jakarta.validation.Valid;


@Controller
public class AuthenticationController {
	private final CredenzialiService credenzialiService;
	
	private final PasswordEncoder passwordEncoder;

	public AuthenticationController(CredenzialiService credenzialiService, PasswordEncoder passwordEncoder) {
		this.credenzialiService = credenzialiService;
		
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping("/register")
public String showRegisterForm(Authentication authentication, Model model) {
    if (authentication != null && authentication.isAuthenticated()) {
        return "redirect:/";
    }
    
    // Passiamo l'oggetto 'credenziali' richiesto dal form th:object="${credenziali}"
    model.addAttribute("credenziali", new Credenziali());
    
    return "/Public/register";
}

	@GetMapping("/login")
	public String showLoginForm(Authentication authentication) 
	{
		if (authentication != null && authentication.isAuthenticated())
			return "redirect:/";

		return "/Public/login";
	}

	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("credenziali") Credenziali credenziali, 
                               BindingResult bindingResult, 
                               Model model) {

        // 1. CONTROLLO DUPLICATI (Evita il crash se l'utente esiste già)
        if (credenzialiService.getCredenziali(credenziali.getUsername()) != null) {
            // Aggiunge un errore globale al Form senza far crashare nulla
            bindingResult.addError(new ObjectError("global", "Questo Username è già registrato!"));
        }
		// 2. CONTROLLO EMAIL DUPLICATA (Aggiungi questo!)
		if (credenzialiService.findByEmail(credenziali.getEmail()) != null) {
        bindingResult.addError(new ObjectError("global", "Questa Email è già in uso!"));
    	}
        // 2. SE CI SONO ERRORI (di validazione o duplicati), RICARICA IL FORM
        if (bindingResult.hasErrors()) {
            return "/Public/register";
        }

        // 3. SE TUTTO È OK, PREPARIAMO L'UTENTE COLLEGATO
        Utente utente = new Utente();
        utente.setBio("L'Imperatore Protegge!");
        utente.setUrlFotoProfilo("/img/fotoProfilo/default.jpg");
        utente.setDataRegistrazione(LocalDate.now());

        // Iniettiamo la password criptata
        credenziali.setPassword(passwordEncoder.encode(credenziali.getPassword()));
        
        // Colleghiamo i due oggetti (Relazione bidirezionale)
        credenziali.setUtente(utente);
        utente.setCredenziali(credenziali);

        // Salviamo. Grazie a CascadeType.ALL su Credenziali, salverà anche l'utente automaticamente
        credenzialiService.saveCredenziali(credenziali);

        return "redirect:/login";   
    }
	
	@GetMapping("/error/403")
	public String accessDenied() {
	    return "error/403";
	}
}
