/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Utente
 */
public class UtenteDTO {

  private long id;
  private String nome , cognome, codiceFiscale, email;
  private LocalDate dataNascita;
  List<AbbonamentoDTO> abbonamenti = new ArrayList<>();
  List <FilmDTO> films = new ArrayList<>();

  public UtenteDTO() {
  }

  public UtenteDTO(long id, String nome, String cognome, String codiceFiscale, String email, LocalDate dataNascita) {
    this.id = id;
    this.nome = nome;
    this.cognome = cognome;
    this.codiceFiscale = codiceFiscale;
    this.email = email;
    this.dataNascita = dataNascita;
  }

  public long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getCognome() {
    return cognome;
  }

  public String getCodiceFiscale() {
    return codiceFiscale;
  }

  public String getEmail() {
    return email;
  }

  public LocalDate getDataNascita() {
    return dataNascita;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public void setCodiceFiscale(String codiceFiscale) {
    this.codiceFiscale = codiceFiscale;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setDataNascita(LocalDate dataNascita) {
    this.dataNascita = dataNascita;
  }

  public List<AbbonamentoDTO> getAbbonamenti() {
    return abbonamenti;
  }

  public void setAbbonamenti(List<AbbonamentoDTO> abbonamenti) {
    this.abbonamenti = abbonamenti;
  }

  public List<FilmDTO> getFilms() {
    return films;
  }

  public void setFilms(List<FilmDTO> films) {
    this.films = films;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
    hash = 37 * hash + Objects.hashCode(this.nome);
    hash = 37 * hash + Objects.hashCode(this.cognome);
    hash = 37 * hash + Objects.hashCode(this.codiceFiscale);
    hash = 37 * hash + Objects.hashCode(this.email);
    hash = 37 * hash + Objects.hashCode(this.dataNascita);
    hash = 37 * hash + Objects.hashCode(this.abbonamenti);
    hash = 37 * hash + Objects.hashCode(this.films);
    return hash;
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
    final UtenteDTO other = (UtenteDTO) obj;
    if (this.id != other.id) {
      return false;
    }
    if (!Objects.equals(this.nome, other.nome)) {
      return false;
    }
    if (!Objects.equals(this.cognome, other.cognome)) {
      return false;
    }
    if (!Objects.equals(this.codiceFiscale, other.codiceFiscale)) {
      return false;
    }
    if (!Objects.equals(this.email, other.email)) {
      return false;
    }
    if (!Objects.equals(this.dataNascita, other.dataNascita)) {
      return false;
    }
    if (!Objects.equals(this.abbonamenti, other.abbonamenti)) {
      return false;
    }
    if (!Objects.equals(this.films, other.films)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "UtenteDTO{" + "id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", codiceFiscale=" + codiceFiscale + ", email=" + email + ", dataNascita=" + dataNascita + ", abbonamenti=" + abbonamenti + ", films=" + films + '}';
  }
  
}
