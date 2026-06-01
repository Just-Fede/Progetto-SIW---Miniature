package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Immagine> immagini = new HashSet<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Commento> commenti = new HashSet<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UpVote> upVotes = new HashSet<>();

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

    public Set<Commento> getCommenti() {
        return commenti;
    }

    public void setCommenti(Set<Commento> commenti) {
        this.commenti = commenti;
    }

    public Set<UpVote> getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(Set<UpVote> upVotes) {
        this.upVotes = upVotes;
    }

    public Set<Immagine> getImmagini() {
        return immagini;
    }

    public void setImmagini(Set<Immagine> immagini) {
        this.immagini = immagini;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Post other = (Post) obj;
        return id == other.id;
    }
}
