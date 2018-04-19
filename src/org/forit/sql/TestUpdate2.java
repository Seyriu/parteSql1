/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author UTENTE
 */
public class TestUpdate2 {

  public static void main(String[] args) throws SQLException {
    String url = "jdbc:mysql://localhost:3306/netflix?user=forit&password=12345";
    try (
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement()) {
//      st.executeUpdate("INSERT INTO PREMIO (nome, tipo) VALUES('oscar', 'miglior regia')");
//      st.executeUpdate("INSERT INTO PREMIO (nome, tipo) VALUES('oscar', 'miglior fotografia')");
//      st.executeUpdate("INSERT INTO PREMIO (nome, tipo) VALUES('oscar', 'miglior colonna sonora')");
//      
//      // addBatch aggiunge una query, ma non la esegue ancora
//      st.addBatch("INSERT INTO PREMIO (nome, tipo) VALUES('Palma d''oro', 'miglior regia')");
//      st.addBatch("INSERT INTO PREMIO (nome, tipo) VALUES('Palma d''oro', 'miglior fotografia')");
//      st.addBatch("INSERT INTO PREMIO (nome, tipo) VALUES('Palma d''oro', 'miglior colonna sonora')");
//      // esegue tutte le query nel batch e svuota la coda di query
//      int[] array = st.executeBatch(); // array contiene il risultato dele query.
//      st.clearBatch();
    } catch (SQLException ex) {
      System.out.println("Si è verificato un errore " + ex);
    }
  }
}
