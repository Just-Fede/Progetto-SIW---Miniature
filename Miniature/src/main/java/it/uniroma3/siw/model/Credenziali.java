package it.uniroma3.siw.model;

import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Credenziali 
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank
	private String username;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String role;
	
	@OneToOne
	private Utente utente;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
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
		Credenziali other = (Credenziali) obj;
		return id == other.id;
	}
	
	
	
}
