package it.uniroma3.siw.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class ProdottoOriginale 
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String descrizione;
	
	@NotBlank
	private String categoria;
	
	@NotBlank
	private String storeURL;
	
	@NotBlank
	private String immagineURL;
	
	@OneToMany(mappedBy="prodottoOriginale")
	private List<Post> posts;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getStoreURL() {
		return storeURL;
	}

	public void setStoreURL(String storeURL) {
		this.storeURL = storeURL;
	}

	public String getImmagineURL() {
		return immagineURL;
	}

	public void setImmagineURL(String immagineURL) {
		this.immagineURL = immagineURL;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdottoOriginale other = (ProdottoOriginale) obj;
		return id == other.id;
	}
	
	
}
