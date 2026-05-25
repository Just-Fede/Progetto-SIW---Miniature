package it.uniroma3.siw.service;

import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Credenziali;
import it.uniroma3.siw.repository.CredenzialiRepository;

@Service
public class CredenzialiService {
	private final CredenzialiRepository credenzialiRepository;

    public CredenzialiService(CredenzialiRepository credenzialiRepository) {
        this.credenzialiRepository = credenzialiRepository;
    }
	public Credenziali getCredenziali(Long id) {
        return credenzialiRepository.findById(id).orElse(null);
    }

    public Credenziali getCredenziali(String username) {
        return credenzialiRepository.findByUsername(username).orElse(null);
    }

    public Credenziali saveCredenziali(Credenziali credenziali) {
        return credenzialiRepository.save(credenziali);
    }
}
