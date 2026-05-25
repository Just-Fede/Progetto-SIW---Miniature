package it.uniroma3.siw.controller;

import org.springframework.stereotype.Controller;

import it.uniroma3.siw.service.ProdottoOriginaleService;

@Controller
public class ProdottoOriginaleController {
		private ProdottoOriginaleService prodottoOriginaleService;
		public ProdottoOriginaleController(ProdottoOriginaleService prodottoOriginaleService) {
			this.prodottoOriginaleService=prodottoOriginaleService;
		}
		
}
