/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author UTENTE
 */
public class TestUpdate3 {

  public static void main(String[] args) throws SQLException {
    String url = "jdbc:mysql://localhost:3306/netflix?user=forit&password=12345";
    try (
            Connection conn = DriverManager.getConnection(url);
            PreparedStatement st = conn.prepareStatement(Queries.INSERISCI_NUOVO_PREMIO)) {
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
