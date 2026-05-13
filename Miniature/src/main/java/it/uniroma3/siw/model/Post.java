package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Post 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank
	private String titolo;
	
	@NotBlank
	private String descrizione;
	
	@NotNull
	private LocalDate data;
	
	@ManyToOne
	private Utente utente;

	@ManyToOne
	private ProdottoOriginale prodottoOriginale;
	
	@OneToMany(mappedBy="post")
	private List<Commento> commenti;
	
	@OneToMany(mappedBy="post")
	private List<UpVote> like;
	
	@OneToMany(mappedBy="post")
	private List<Immagine> immagini;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public ProdottoOriginale getProdottoOriginale() {
		return prodottoOriginale;
	}

	public void setProdottoOriginale(ProdottoOriginale prodottoOriginale) {
		this.prodottoOriginale = prodottoOriginale;
	}

	public List<Commento> getCommenti() {
		return commenti;
	}

	public void setCommenti(List<Commento> commenti) {
		this.commenti = commenti;
	}

	public List<UpVote> getLike() {
		return like;
	}

	public void setLike(List<UpVote> like) {
		this.like = like;
	}

	public List<Immagine> getImmagini() {
		return immagini;
	}

	public void setImmagini(List<Immagine> immagini) {
		this.immagini = immagini;
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
		Post other = (Post) obj;
		return id == other.id;
	}
}
