package it.uniroma3.siw.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.ProdottoOriginale;
import it.uniroma3.siw.repository.ProdottoOriginaleRepository;

@Service
public class ProdottoOriginaleService 
{
	
	private final ProdottoOriginaleRepository prodottoOriginaleRepository;

	public ProdottoOriginaleService(ProdottoOriginaleRepository prodottoOriginaleRepository) {
	this.prodottoOriginaleRepository=prodottoOriginaleRepository;
	}
	
	@Transactional(readOnly=true)
	public List<ProdottoOriginale> findAll() {
		return (List<ProdottoOriginale>)this.prodottoOriginaleRepository.findAll();
	}

    public ProdottoOriginale findById(Long prodottoId) 
	{
        return this.prodottoOriginaleRepository.findById(prodottoId).get();
    }

	public void save(ProdottoOriginale prodottoOriginale)
	{
		this.prodottoOriginaleRepository.save(prodottoOriginale);
	}

}
