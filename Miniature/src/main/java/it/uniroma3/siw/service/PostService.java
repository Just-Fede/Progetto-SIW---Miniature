package it.uniroma3.siw.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Post;
import it.uniroma3.siw.repository.PostRepository;

@Service
public class PostService {
	private PostRepository postRepository;
	public PostService (PostRepository postRepository) {
		this.postRepository=postRepository;
	}
	@Transactional(readOnly=true)
	public List<Post> findALL() {
		return (List<Post>)this.postRepository.findAll();
	}
	
	
	

}
