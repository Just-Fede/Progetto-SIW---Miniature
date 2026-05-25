package it.uniroma3.siw.service;

import org.springframework.stereotype.Service;

import it.uniroma3.siw.repository.ProdottoOriginaleRepository;

@Service
public class ProdottoOriginaleService {
	
	private ProdottoOriginaleRepository prodottoOriginaleRepository;
	public ProdottoOriginaleService(ProdottoOriginaleRepository prodottoOriginaleRepository) {
	this.prodottoOriginaleRepository=prodottoOriginaleRepository;
	}
	
	
}
