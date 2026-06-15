package it.uniroma3.siw.controller;

import java.time.LocalDate;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static it.uniroma3.siw.SecurityConfiguration.ROLE_ADMIN;
import static it.uniroma3.siw.SecurityConfiguration.ROLE_USER;
import it.uniroma3.siw.model.Credenziali;
import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.service.CredenzialiService;


@Controller
public class AuthenticationController {
	private final CredenzialiService credenzialiService;
	
	private final PasswordEncoder passwordEncoder;

	public AuthenticationController(CredenzialiService credenzialiService, PasswordEncoder passwordEncoder) {
		this.credenzialiService = credenzialiService;
		
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping("/register")
	public String showRegisterForm(Authentication authentication) 
	{
		if (authentication != null && authentication.isAuthenticated())
			return "redirect:/";

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
	public String registerUser(	@RequestParam String username, 
								@RequestParam String password,
								@RequestParam String email,
								@RequestParam String role) 
	{

		if(!role.equals(ROLE_ADMIN))
			role = ROLE_USER;

		Credenziali newCredenziali = new Credenziali();
		newCredenziali.setUsername(username);
		newCredenziali.setPassword(passwordEncoder.encode(password));
		newCredenziali.setEmail(email);
		newCredenziali.setRole(role);
		
		Utente newUtente = new Utente();
		newUtente.setCredenziali(newCredenziali);
		newUtente.setBio("L'Imperatore Protegge!");
		newUtente.setUrlFotoProfilo("/img/fotoProfilo/default.jpg");
		newUtente.setDataRegistrazione(LocalDate.now());
		

		newCredenziali.setUtente(newUtente);
    	newUtente.setCredenziali(newCredenziali);
		newCredenziali.setUtente(newUtente);
		credenzialiService.saveCredenziali(newCredenziali);

		return "redirect:/login";	
	}
	
	@GetMapping("/error/403")
	public String accessDenied() {
	    return "error/403";
	}
}
