package it.uniroma3.siw.service;

import org.springframework.stereotype.Service;
import it.uniroma3.siw.repository.ImmagineRepository;

@Service
public class ImmagineService 
{
    private final ImmagineRepository immagineRepository;

    public ImmagineService(ImmagineRepository immagineRepository) {
        this.immagineRepository = immagineRepository;
    }

    public void save(it.uniroma3.siw.model.Immagine img) {
        this.immagineRepository.save(img);
    }
}
