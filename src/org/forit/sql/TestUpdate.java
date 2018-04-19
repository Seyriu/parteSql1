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
 * @author Utente
 */
public class TestUpdate {

  public static void main(String[] args) throws SQLException {
    String url = "jdbc:mysql://localhost:3306/netflix?user=forit&password=12345";
    Connection conn = DriverManager.getConnection(url);
    Statement st = conn.createStatement();
//    st.executeUpdate("insert into lingua (descrizione) values('FRANCESE');"); // sia per le insert/update/delete
    st.close();
    conn.close();
  }
}
