package it.uniroma3.siw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import it.uniroma3.siw.model.Credenziali;
import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.service.CredenzialiService;
import it.uniroma3.siw.service.UtenteService;


@Controller
public class AuthenticationController {
	private CredenzialiService credenzialiService;
	private UtenteService utenteService;

	public AuthenticationController(CredenzialiService credenzialiService, UtenteService utenteService) {
		this.credenzialiService = credenzialiService;
		this.utenteService = utenteService;
	}

	@GetMapping("/register")
	public String showRegisterForm(Model model) {
		model.addAttribute("utente", new Utente());
		model.addAttribute("credenziali", new Credenziali());
		return "formRegisterUser";
	}

	@GetMapping("/login")
	public String showLoginForm(Model model) {
		return "formLogin";
	}

	@GetMapping("/success")
	public String defaultAfterLogin(Model model) {
		return "index";
	}

	
	@PostMapping("/register")
	public String registerUser() {

		
		return "registrationSuccessful";

	}
}
