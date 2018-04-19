/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author Utente
 */
public class AbbonamentoDTO {
  private long id;
  private String descrizione;
  private int durata; // in mesi
  private BigDecimal costo;

  @Override
  public String toString() {
    return "AbbonamentoDTO{" + "id=" + id + ", descrizione=" + descrizione + ", durata=" + durata + ", costo=" + costo + ", metodoPagamento=" + metodoPagamento + ", dataSottoscrizione=" + dataSottoscrizione + '}';
  }
  private String metodoPagamento;
  private LocalDate dataSottoscrizione;

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
    hash = 89 * hash + Objects.hashCode(this.descrizione);
    hash = 89 * hash + this.durata;
    hash = 89 * hash + Objects.hashCode(this.costo);
    hash = 89 * hash + Objects.hashCode(this.metodoPagamento);
    hash = 89 * hash + Objects.hashCode(this.dataSottoscrizione);
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
    final AbbonamentoDTO other = (AbbonamentoDTO) obj;
    if (this.id != other.id) {
      return false;
    }
    if (this.durata != other.durata) {
      return false;
    }
    if (!Objects.equals(this.descrizione, other.descrizione)) {
      return false;
    }
    if (!Objects.equals(this.metodoPagamento, other.metodoPagamento)) {
      return false;
    }
    if (!Objects.equals(this.costo, other.costo)) {
      return false;
    }
    if (!Objects.equals(this.dataSottoscrizione, other.dataSottoscrizione)) {
      return false;
    }
    return true;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getDescrizione() {
    return descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public int getDurata() {
    return durata;
  }

  public void setDurata(int durata) {
    this.durata = durata;
  }

  public BigDecimal getCosto() {
    return costo;
  }

  public void setCosto(BigDecimal costo) {
    this.costo = costo;
  }

  public String getMetodoPagamento() {
    return metodoPagamento;
  }

  public void setMetodoPagamento(String metodoPagamento) {
    this.metodoPagamento = metodoPagamento;
  }

  public LocalDate getDataSottoscrizione() {
    return dataSottoscrizione;
  }

  public void setDataSottoscrizione(LocalDate dataSottoscrizione) {
    this.dataSottoscrizione = dataSottoscrizione;
  }

  public AbbonamentoDTO() {
  }
  private static final Logger LOG = Logger.getLogger(AbbonamentoDTO.class.getName());

  public AbbonamentoDTO(long id, String descrizione, int durata, BigDecimal costo, String metodoPagamento, LocalDate dataSottoscrizione) {
    this.id = id;
    this.descrizione = descrizione;
    this.durata = durata;
    this.costo = costo;
    this.metodoPagamento = metodoPagamento;
    this.dataSottoscrizione = dataSottoscrizione;
  }
  
  
}
