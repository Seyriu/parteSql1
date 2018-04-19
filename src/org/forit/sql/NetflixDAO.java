/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.sql;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaGrammar;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.forit.dto.AbbonamentoDTO;
import org.forit.dto.AttoreDTO;
import org.forit.dto.UtenteDTO;

/**
 *
 * @author Utente
 */
public class NetflixDAO {

  private static final String DB_URL = "jdbc:mysql://localhost:3306/netflix?user=forit&password=12345&useSSL=false";

  private static final String LISTA_UTENTI = "SELECT p.*, u.codice_fiscale, u.EMAIL "
          + "from persona p, utente u "
          + "where p.id = u.id "
          + "order by p.COGNOME, p.nome";

  private static final String UTENTE = "SELECT p.*, u.codice_fiscale, u.EMAIL "
          + "from persona p, utente u "
          + "where u.id=? and p.id = u.id";

  private final static String ABBONAMENTI_X_PERSONA
          = "select a.*, pxa.METODO_PAGAMENTO, pxa.DATA_SOTTOSCRIZIONE "
          + "from abbonamento a, persona_x_abbonamento pxa "
          + "where pxa.ID_PERSONA=? and a.id=pxa.ID_ABBONAMENTO";

  private static final String LISTA_ATTORI = "SELECT p.*, n.descrizione "
          + "from persona p, attore a, nazione n "
          + "where p.id = a.id and a.id_nazione=n.id "
          + "order by p.COGNOME, p.nome";

  private static final String INSERISCI_PERSONA = "INSERT INTO persona (NOME, COGNOME, DATA_NASCITA) "
          + "VALUES (?, ?, ?);";

  private static final String INSERISCI_ATTORE = "INSERT INTO ATTORE(ID, ID_NAZIONE) VALUES (?, ?)";

  private static final String ADD_PREMIO_TO_ENTITA = "INSERT INTO ENTITA_X_PREMIO (ID_ENTITA,ID_PREMIO,ANNO)"
          + "VALUES (?, ?, ?);";

  public List<AttoreDTO> getListaAttori() throws SQLException {
    try (
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(LISTA_ATTORI)) {

      List<AttoreDTO> listaAttori = new ArrayList<>();
      while (rs.next()) {
        long id = rs.getLong("ID");
        String nome = rs.getString("Nome");
        String cognome = rs.getString("cognome");
        LocalDate dataNascita = rs.getDate("Data_Nascita").toLocalDate();
        String nazione = rs.getString("descrizione");

        AttoreDTO attore = new AttoreDTO(id, nome, cognome, nazione, dataNascita);
        listaAttori.add(attore);
      }
      return listaAttori;
    } catch (SQLException ex) {
      System.out.println("Si è verificato un errore " + ex.getLocalizedMessage());
      throw ex;
    }
  }

  public List<UtenteDTO> getListaUtenti() throws SQLException {
    try (
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(LISTA_UTENTI)) {

      List<UtenteDTO> listaUtenti = new ArrayList<>();
      while (rs.next()) {
        long id = rs.getLong("ID");
        String nome = rs.getString("Nome");
        String cognome = rs.getString("cognome");
        LocalDate dataNascita = rs.getDate("Data_Nascita").toLocalDate();
        String codiceFiscale = rs.getString("CODICE_FISCALE");
        String email = rs.getString("EMAIL");

        UtenteDTO utente = new UtenteDTO(id, nome, cognome, codiceFiscale, email, dataNascita);
        listaUtenti.add(utente);
      }
      return listaUtenti;
    } catch (SQLException ex) {
      System.out.println("Si è verificato un errore " + ex.getLocalizedMessage());
      throw ex;
    }
  }

  public UtenteDTO getUtente(long id) throws SQLException {
    try (
            Connection conn = DriverManager.getConnection(DB_URL);
            PreparedStatement ps1 = conn.prepareStatement(UTENTE);
            PreparedStatement ps2 = conn.prepareStatement(ABBONAMENTI_X_PERSONA)) {
      ps1.setLong(1, id);
      ResultSet rs = ps1.executeQuery();
      rs.next();
      String nome = rs.getString("Nome");
      String cognome = rs.getString("cognome");
      LocalDate dataNascita = rs.getDate("Data_Nascita").toLocalDate();
      String codiceFiscale = rs.getString("CODICE_FISCALE");
      String email = rs.getString("EMAIL");

      UtenteDTO utente = new UtenteDTO(id, nome, cognome, codiceFiscale, email, dataNascita);

      ps2.setLong(1, id);
      rs = ps2.executeQuery();

      while (rs.next()) {
        long idAbbonamento = rs.getLong("ID");
        String descrizioneAbbonamento = rs.getString("DESCRIZIONE");
        int durataAbbonamento = rs.getInt("durata");
        BigDecimal costo = rs.getBigDecimal("costo");
        String metodoPagamentoAbbonamento = rs.getString("metodo_pagamento");
        LocalDate dataSottoscrizioneAbbonamento = rs.getDate("data_sottoscrizione").toLocalDate();
        AbbonamentoDTO abbonamento
                = new AbbonamentoDTO(idAbbonamento, descrizioneAbbonamento, durataAbbonamento, costo, metodoPagamentoAbbonamento, dataSottoscrizioneAbbonamento);
        utente.getAbbonamenti().add(abbonamento);
      }
      return utente;
    } catch (SQLException ex) {
      System.out.println("Si è verificato un errore " + ex.getLocalizedMessage());
      throw ex;
    }
  }

  public void insertAttore(String nome, String cognome, LocalDate dataNascita, long idNazione) throws SQLException {
    try (Connection conn = DriverManager.getConnection(DB_URL)) {
      conn.setAutoCommit(false);
      try (
              PreparedStatement ps1 = conn.prepareStatement(INSERISCI_PERSONA, Statement.RETURN_GENERATED_KEYS);
              PreparedStatement ps2 = conn.prepareStatement(INSERISCI_ATTORE)) {
        ps1.setString(1, nome);
        ps1.setString(2, cognome);
        ps1.setDate(3, Date.valueOf(dataNascita));
        ps1.executeUpdate();
        ResultSet generatedKey = ps1.getGeneratedKeys();
        generatedKey.next();
        Long id = generatedKey.getLong(1);

        ps2.setLong(1, id);
        ps2.setLong(2, idNazione);
        ps2.executeUpdate();

        conn.commit();
      } catch (SQLException ex) {
        conn.rollback();
        throw ex;
      }
//      String inserisciPersona = "INSERT INTO persona (NOME, COGNOME, DATA_NASCITA) VALUES ('Alvaro', 'Vitali', '1945-12-21');";
//      st.executeUpdate(inserisciPersona, Statement.RETURN_GENERATED_KEYS);
//      ResultSet generatedKey = st.getGeneratedKeys();
//      generatedKey.next();
//      Long id = generatedKey.getLong(1);
//      String InserisciAttore = "INSERT INTO ATTORE(ID, ID_NAZIONE) VALUES (" + id + ", 1)";
//      st.executeUpdate(InserisciAttore);
    } catch (SQLException ex) {
      System.out.println("Si è verificato un errore " + ex);
      throw ex;
    }
  }

  public void addPremioToEntita(long idEntita, long idPremio, int anno) throws SQLException {
    try (
            Connection conn = DriverManager.getConnection(DB_URL);
            PreparedStatement ps = conn.prepareStatement(ADD_PREMIO_TO_ENTITA)) {
      ps.setLong(1, idEntita);
      ps.setLong(2, idPremio);
      ps.setLong(3, anno);
      ps.executeUpdate();
    } catch (SQLException ex) {
      System.out.println("Si è verificato un errore " + ex.getLocalizedMessage());
      throw ex;
    }
  }

}
