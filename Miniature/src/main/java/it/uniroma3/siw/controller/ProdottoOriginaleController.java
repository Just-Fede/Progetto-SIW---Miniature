package it.uniroma3.siw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.model.ProdottoOriginale;
import it.uniroma3.siw.service.ProdottoOriginaleService;


@Controller
public class ProdottoOriginaleController {

		private final ProdottoOriginaleService prodottoOriginaleService;

		public ProdottoOriginaleController(ProdottoOriginaleService prodottoOriginaleService) 
		{
			this.prodottoOriginaleService=prodottoOriginaleService;
		}

		@GetMapping("/admin/form/prodottoOriginaleForm")
		public String getForm() {
			return "/admin/form/prodottoOriginaleForm";
		}
		
		@PostMapping("/admin/form/prodottoOriginaleForm")
		public String postForm(
			@RequestParam String nome,
			@RequestParam String descrizione,
			@RequestParam String categoria,
			@RequestParam String storeUrl,
			@RequestParam String immagineUrl
		){
			ProdottoOriginale prodottoNew = new ProdottoOriginale();
			
			prodottoNew.setNome(nome);
			prodottoNew.setDescrizione(descrizione);
			prodottoNew.setCategoria(categoria);

			prodottoNew.setStoreUrl(storeUrl);
			prodottoNew.setImmagineUrl(immagineUrl);

			this.prodottoOriginaleService.save(prodottoNew);
			
			return "redirect:/admin/form/prodottoOriginaleForm";
		}
		
}
