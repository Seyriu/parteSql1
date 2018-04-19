/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author UTENTE
 */
public class TestTransaction {

  public static void main(String[] args) {
    String url = "jdbc:mysql://localhost:3306/netflix?user=forit&password=12345";
    try (Connection conn = DriverManager.getConnection(url)) {
//      conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
      conn.setAutoCommit(false); // disabilito l'autocommit
      try (Statement st = conn.createStatement()) {

        String inserisciPersona = "INSERT INTO persona (NOME, COGNOME, DATA_NASCITA) VALUES ('Luca', 'Zingaretti', '1975-05-09');";
        st.executeUpdate(inserisciPersona, Statement.RETURN_GENERATED_KEYS); // ritorna le chiavi auto incrementate generate automaticamente in un resultset
        ResultSet generatedKey = st.getGeneratedKeys();
        generatedKey.next();
        Long id = generatedKey.getLong(1);
        String InserisciAttore = "INSERT INTO ATTORE(ID, ID_NAZIONE) VALUES (" + id + ", 1')"; // errore creato appositamente
        st.executeUpdate(InserisciAttore);
        conn.commit();
      } catch (SQLException ex) {
        conn.rollback();
        throw ex;
      }
    } catch (SQLException ex) {
      System.out.println("Si è verificato un errore " + ex);
    }
  }
}
