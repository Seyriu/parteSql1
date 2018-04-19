/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author UTENTE
 */
public class TestMetadata {

  public static void main(String[] args) {
    String url = "jdbc:mysql://localhost:3306/netflix?user=forit&password=12345";
    try (Connection conn = DriverManager.getConnection(url)) {
      DatabaseMetaData dbmd = conn.getMetaData();
      System.out.println(dbmd.getDatabaseProductName());
      System.out.println(dbmd.getDatabaseProductVersion());
      System.out.println(dbmd.getDefaultTransactionIsolation());
      System.out.println(dbmd.getDriverName());
      ResultSet rs = dbmd.getTables(null, "netflix", null, null); // restituisce un oggetto con tutte le tabelle dello schema netflix ed i loro metadati

      System.out.println("--------------------------");
      while (rs.next()) {
        String tableName = rs.getString("TABLE_NAME");
        System.out.println("Nome Tabella: " + tableName);
        ResultSet rs1 = dbmd.getColumns(null, "netflix", tableName, null);
        while (rs1.next()) {
          String columnName = rs1.getString("COLUMN_NAME");
          String typeName = rs1.getString("TYPE_NAME");
          String nullable = rs1.getString("IS_NULLABLE");
          String autoIncrement = rs1.getString("IS_AUTOINCREMENT");
          System.out.println(columnName + " " + typeName + " " + nullable + " " + autoIncrement);
        }
        System.out.println("--------------------------");
      }
    } catch (SQLException ex) {
      System.out.println("Si è verificato un errore " + ex);
    }
  }
}
