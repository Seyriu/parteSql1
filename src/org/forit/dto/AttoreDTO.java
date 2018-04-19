/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.dto;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Utente
 */
public class AttoreDTO {

  private long ID;
  private String nome, cognome, nazione;
  private LocalDate dataNascita;

  public AttoreDTO() {
  }

  public AttoreDTO(long ID, String nome, String cognome, String nazione, LocalDate dataNascita) {
    this.ID = ID;
    this.nome = nome;
    this.cognome = cognome;
    this.nazione = nazione;
    this.dataNascita = dataNascita;
  }

  public long getID() {
    return ID;
  }

  public void setID(long ID) {
    this.ID = ID;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCognome() {
    return cognome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public String getNazione() {
    return nazione;
  }

  public void setNazione(String nazione) {
    this.nazione = nazione;
  }

  public LocalDate getDataNascita() {
    return dataNascita;
  }

  public void setDataNascita(LocalDate dataNascita) {
    this.dataNascita = dataNascita;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 11 * hash + (int) (this.ID ^ (this.ID >>> 32));
    hash = 11 * hash + Objects.hashCode(this.nome);
    hash = 11 * hash + Objects.hashCode(this.cognome);
    hash = 11 * hash + Objects.hashCode(this.nazione);
    hash = 11 * hash + Objects.hashCode(this.dataNascita);
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
    final AttoreDTO other = (AttoreDTO) obj;
    if (this.ID != other.ID) {
      return false;
    }
    if (!Objects.equals(this.nome, other.nome)) {
      return false;
    }
    if (!Objects.equals(this.cognome, other.cognome)) {
      return false;
    }
    if (!Objects.equals(this.nazione, other.nazione)) {
      return false;
    }
    if (!Objects.equals(this.dataNascita, other.dataNascita)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "AttoreDTO{" + "ID=" + ID + ", nome=" + nome + ", cognome=" + cognome + ", nazione=" + nazione + ", dataNascita=" + dataNascita + '}';
  }
  
  
}
