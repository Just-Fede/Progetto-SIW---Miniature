package it.uniroma3.siw.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import it.uniroma3.siw.model.Post;
import it.uniroma3.siw.service.PostService;
import it.uniroma3.siw.model.ProdottoOriginale;
import it.uniroma3.siw.service.ProdottoOriginaleService;
import it.uniroma3.siw.model.Immagine;
import it.uniroma3.siw.service.ImmagineService;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import static it.uniroma3.siw.model.Immagine.DIRECTORY_STRING;

@Controller
public class PostController {
	
	private final PostService postService;
	private final ProdottoOriginaleService prodottoOriginaleService;
	private final ImmagineService immagineService;

	public PostController
	(PostService postService, ProdottoOriginaleService prodottoOriginaleService, ImmagineService immagineService) 
	{
		this.postService=postService;
		this.prodottoOriginaleService=prodottoOriginaleService;
		this.immagineService=immagineService;
	}
	
	@GetMapping("/post/create")
	public String getPostForm(Model model) 
	{
		List<ProdottoOriginale> prodotti = this.prodottoOriginaleService.findAll();
		model.addAttribute("prodottiOriginali", prodotti);
		
		return "/user/postForm";
	}
	
	@PostMapping("/post/create")
	public String postPostForm(	@RequestParam String nome,
								@RequestParam String descrizione,
								@RequestParam (required=false) Long prodottoId,
								@RequestParam MultipartFile immagini,
								@RequestParam (required=false) MultipartFile[] altreImmagini
	) 
	{
		ProdottoOriginale prodottoOriginale;
		if(prodottoId!=null)
			prodottoOriginale = this.prodottoOriginaleService.findById(prodottoId);
		else
			prodottoOriginale = null;
		
		Post newPost = new Post();
		newPost.setTitolo(nome);
		newPost.setDescrizione(descrizione);
		newPost.setData(LocalDate.now());
		//newPost.setUtente();
		newPost.setProdottoOriginale(prodottoOriginale);
		this.postService.save(newPost);

		Path uploadDir = Paths.get(DIRECTORY_STRING);

		try 
		{
			if(!Files.exists(uploadDir))
				Files.createDirectories(uploadDir);
		} catch (Exception e) {}
		

		if(immagini != null && !immagini.isEmpty())	
		{
			String nomeFile = UUID.randomUUID() + ".jpg";

			Path path = uploadDir.resolve(nomeFile);

			try{Files.copy(immagini.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);}
			catch(Exception e) {}
			

			Immagine img = new Immagine();
			img.setURL("/" + DIRECTORY_STRING + "/" + nomeFile);
			img.setPost(newPost);
			img.setCopertina(true);
		
			immagineService.save(img);
		}

		return "redirect:/posts";
	}
	

}