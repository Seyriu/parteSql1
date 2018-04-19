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
public class TestUpdate4 {

  public static void main(String[] args) throws SQLException {
    String url = "jdbc:mysql://localhost:3306/netflix?user=forit&password=12345";
    try (
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement()) {
      String inserisciPersona = "INSERT INTO persona (NOME, COGNOME, DATA_NASCITA) VALUES ('Alvaro', 'Vitali', '1945-12-21');";
      st.executeUpdate(inserisciPersona, Statement.RETURN_GENERATED_KEYS); // ritorna le chiavi auto incrementate generate automaticamente in un resultset
      ResultSet generatedKey = st.getGeneratedKeys();
      generatedKey.next();
      Long id = generatedKey.getLong(1);
      String InserisciAttore = "INSERT INTO ATTORE(ID, ID_NAZIONE) VALUES (" + id + ", 1)";
      st.executeUpdate(InserisciAttore);
//      // caRICA query ed esegue in un secondo tempo
//      st.setString(1, "Oscar"); // parte da 1 in sql
//      st.setString(2, "Miglior Attrice");
//      st.executeUpdate();
//      st.clearParameters();
//      
//      
//      st.setString(1, "Palma D'Oro"); // parte da 1 in sql
//      st.setString(2, "Miglior Attrice");
//      st.executeUpdate();
//      st.clearParameters();
    } catch (SQLException ex) {
      System.out.println("Si è verificato un errore " + ex);
    }
  }
}
