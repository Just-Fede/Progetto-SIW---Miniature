package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Utente 
{

	private static final String DEFAULT_AVATAR = "/img/fotoProfilo/default.jpg";

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(length = 2000)
	private String bio;

	private String urlFotoProfilo = DEFAULT_AVATAR;
	
	private LocalDate dataRegistrazione;
	
	@OneToOne(mappedBy = "utente") 
	@JsonIgnoreProperties("credenziali")
	private Credenziali credenziali;

	@OneToMany(mappedBy="utente")
	@JsonIgnore
	private List<Post> posts;

	@OneToMany(mappedBy="utente")
	@JsonIgnore
	private List<Commento> commenti;

	@OneToMany(mappedBy="utente")
	@JsonIgnore
	private List<UpVote> upVotes;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getUrlFotoProfilo() {
		return urlFotoProfilo;
	}

	public void setUrlFotoProfilo(String urlFotoProfilo) {
		this.urlFotoProfilo = urlFotoProfilo;
	}

	public LocalDate getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(LocalDate dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	public Credenziali getCredenziali() {
		return credenziali;
	}

	public void setCredenziali(Credenziali credenziali) {
		this.credenziali = credenziali;
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
		Utente other = (Utente) obj;
		return Objects.equals(id, other.id);
	}

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Commento> getCommenti() {
        return commenti;
    }

    public void setCommenti(List<Commento> commenti) {
        this.commenti = commenti;
    }

    public List<UpVote> getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(List<UpVote> upVotes) {
        this.upVotes = upVotes;
    }
	
}
