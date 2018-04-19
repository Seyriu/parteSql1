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
 * @author UTENTE
 */
public class TestSelect3 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/netflix?user=forit&password=12345";

        try (
                Connection conn = DriverManager.getConnection(url);
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(Queries.PREMI_PER_OGNI_ATTORE)) {

            while (rs.next()) {
                long id = rs.getLong("ID");
                String nome = rs.getString("NOME");
                String cognome = rs.getString("COGNOME");
                LocalDate dataNascita = rs.getDate("DATA_NASCITA").toLocalDate();
                String nazione = rs.getString("NAZIONE");
                String nomePremio = rs.getString("nomePremio");
                int numeroPremi = rs.getInt("numeroPremi");

                System.out.println(id + " " + nome + " " + cognome + " " + dataNascita + " " + nazione + " " + nomePremio + " " + numeroPremi);
            }
        } catch (SQLException ex) {
            System.out.println("Si è verificato un errore " + ex);
        }
    }
}