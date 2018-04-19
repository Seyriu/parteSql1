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
import java.time.LocalDate;

/**
 *
 * @author Utente
 */
public class TestSelect2 {

  public static void main(String[] args) {
    String url = "jdbc:mysql://localhost:3306/netflix?user=forit&password=12345";
    try (
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(Queries.ELENCO_PERSONE)) {

      while (rs.next()) {
        long id = rs.getLong("ID");
        String nome = rs.getString("nome");
        String cognome = rs.getString("cognome");
        LocalDate dataNascita = rs.getDate("data_nascita").toLocalDate();
        System.out.println(id + " " + nome + " " + cognome + " " + dataNascita);
      }
    } catch (SQLException ex) {

    }

  }
}
