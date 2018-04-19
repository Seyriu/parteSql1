/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.sql;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.forit.dto.AttoreDTO;
import org.forit.dto.UtenteDTO;

/**
 *
 * @author Utente
 */
public class TestNetflixDAO {

  public static void main(String[] args) throws SQLException {
    NetflixDAO netflixDAO = new NetflixDAO();
    List<UtenteDTO> listaUtenti = netflixDAO.getListaUtenti();
    listaUtenti.forEach(utente -> System.out.println(utente));

    List<AttoreDTO> listaAttori = netflixDAO.getListaAttori();
    listaAttori.forEach(attore -> System.out.println(attore));

//    netflixDAO.insertAttore("Claudio", "Bisio", LocalDate.of(1956, Month.MARCH, 22), 1);
//    netflixDAO.addPremioToEntita(10, 1, 2019);
    
    UtenteDTO utente = netflixDAO.getUtente(1);
    System.out.println(utente);
  }
}
