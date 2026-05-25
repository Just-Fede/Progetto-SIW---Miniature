package it.uniroma3.siw.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.repository.UtenteRepository;

@Service
public class UtenteService {
	private final UtenteRepository utenteRepository;

    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    @Transactional(readOnly = true)
    public Utente getUtente(Long id) {
        return this.utenteRepository.findById(id).orElse(null);
    }

    @Transactional
    public Utente saveUtente(Utente utente) {
        return this.utenteRepository.save(utente);
    }
}
