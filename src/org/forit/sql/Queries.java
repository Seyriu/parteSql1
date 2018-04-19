/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.sql;

/**
 *
 * @author Utente
 */
public class Queries {
  public final static String ELENCO_PERSONE = "SELECT * FROM persona";
  public final static String PREMI_PER_OGNI_ATTORE = "SELECT p.*, n.descrizione NAZIONE, pr.nome nomePremio, COUNT(*) numeroPremi "
            + "FROM persona p, attore a, nazione n, entita_x_premio exp, premio pr "
            + "WHERE p.id = a.id AND a.id_nazione = n.id AND p.id = exp.ID_ENTITA AND exp.ID_PREMIO = pr.id "
            + "GROUP BY p.ID , pr.id";
  public final static String INSERISCI_NUOVO_PREMIO = "INSERT INTO PREMIO (nome, tipo) VALUES(?, ?)";
}
