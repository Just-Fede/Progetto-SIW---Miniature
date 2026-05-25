package it.uniroma3.siw.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.siw.model.Post;

import it.uniroma3.siw.service.PostService;

@Controller
public class PostController {
	

	private PostService postService;
	public PostController(PostService postService) {
		this.postService=postService;
	}
	//Lista di tutti i post
	@GetMapping("/posts")
	public String elencoPost( Model model) {
		List<Post> elencoPost = this.postService.findALL();
		model.addAttribute("posts", elencoPost);
		return "posts/list";
	}
	
	
}