package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Utente 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String bio;
	private String URLFotoProfilo;
	
	private LocalDate dataRegistrazione;
	
	@OneToOne
	private Credenziali credenziali;

	@OneToMany(mappedBy="utente")
	private List<Post> posts;
	@OneToMany(mappedBy="utente")
	private List<Commento> commenti;
	@OneToMany(mappedBy="utente")
	private List<UpVote> likes;
	
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

	public String getURLFotoProfilo() {
		return URLFotoProfilo;
	}

	public void setURLFotoProfilo(String uRLFotoProfilo) {
		URLFotoProfilo = uRLFotoProfilo;
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
	
}
