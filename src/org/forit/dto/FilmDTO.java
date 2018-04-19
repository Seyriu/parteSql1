/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Utente
 */
public class FilmDTO {

  private long id;
  private String titolo, descrizione, nazione, lingua;
  private int anno, durata;
  private List <String> generi = new ArrayList<>();

  public FilmDTO() {
  }

  public FilmDTO(long id, String titolo, String descrizione, String nazione, String lingua, int anno, int durata) {
    this.id = id;
    this.titolo = titolo;
    this.descrizione = descrizione;
    this.nazione = nazione;
    this.lingua = lingua;
    this.anno = anno;
    this.durata = durata;
  }

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

  public String getNazione() {
    return nazione;
  }

  public void setNazione(String nazione) {
    this.nazione = nazione;
  }

  public String getLingua() {
    return lingua;
  }

  public void setLingua(String lingua) {
    this.lingua = lingua;
  }

  public int getAnno() {
    return anno;
  }

  public void setAnno(int anno) {
    this.anno = anno;
  }

  public int getDurata() {
    return durata;
  }

  public void setDurata(int durata) {
    this.durata = durata;
  }

  public List<String> getGeneri() {
    return generi;
  }

  public void setGeneri(List<String> generi) {
    this.generi = generi;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
    hash = 53 * hash + Objects.hashCode(this.titolo);
    hash = 53 * hash + Objects.hashCode(this.descrizione);
    hash = 53 * hash + Objects.hashCode(this.nazione);
    hash = 53 * hash + Objects.hashCode(this.lingua);
    hash = 53 * hash + this.anno;
    hash = 53 * hash + this.durata;
    hash = 53 * hash + Objects.hashCode(this.generi);
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
    final FilmDTO other = (FilmDTO) obj;
    if (this.id != other.id) {
      return false;
    }
    if (this.anno != other.anno) {
      return false;
    }
    if (this.durata != other.durata) {
      return false;
    }
    if (!Objects.equals(this.titolo, other.titolo)) {
      return false;
    }
    if (!Objects.equals(this.descrizione, other.descrizione)) {
      return false;
    }
    if (!Objects.equals(this.nazione, other.nazione)) {
      return false;
    }
    if (!Objects.equals(this.lingua, other.lingua)) {
      return false;
    }
    if (!Objects.equals(this.generi, other.generi)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FilmDTO{" + "id=" + id + ", titolo=" + titolo + ", descrizione=" + descrizione + ", nazione=" + nazione + ", lingua=" + lingua + ", anno=" + anno + ", durata=" + durata + ", generi=" + generi + '}';
  }
  
}
