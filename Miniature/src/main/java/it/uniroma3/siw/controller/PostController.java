package it.uniroma3.siw.controller;

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

@Controller
public class PostController {

    private final PostService postService;
    private final ProdottoOriginaleService prodottoOriginaleService;

    public PostController(PostService postService, ProdottoOriginaleService prodottoOriginaleService) 
{
        this.postService = postService;
        this.prodottoOriginaleService = prodottoOriginaleService;
    }

    @GetMapping("/post/create")
    public String getPostForm(Model model) {
        List<ProdottoOriginale> prodotti = this.prodottoOriginaleService.findAll();
        model.addAttribute("prodottiOriginali", prodotti);

        return "/user/postForm";
    }

    /*#########################################[ATTENZIONE]#########################################################################*/
@PostMapping("/post/create")
public String postPostForm(
        @RequestParam String titolo,
        @RequestParam String descrizione,
        @RequestParam(required = false) Long prodottoId,
        @RequestParam("copertina") MultipartFile immagineCopertina,
        @RequestParam(value = "altreImmagini", required = false) MultipartFile[] altreImmagini
) {

    Post newPost = postService.createPost(
            titolo,
            descrizione,
            prodottoId,
            immagineCopertina,
            altreImmagini
    );

    return "redirect:/";
}
    /*#########################################[ATTENZIONE]#########################################################################*/

}
