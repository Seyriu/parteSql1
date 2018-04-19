/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.sql;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Map;
import org.forit.corsoDiStudi.dto.VotoDTO;
import org.forit.corsoDiStudi.exceptions.CDSException;

/**
 *
 * @author Utente
 */
public class TestCorsoDiStudi {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws CDSException {
    CorsoDiStudiDAO cds = new CorsoDiStudiDAO();
    VotoDTO voto = new VotoDTO(0, 27, 2, 2, 3, 2, LocalDate.of(2018, Month.APRIL, 9));
//    cds.insertVoto(30, LocalDate.of(2017, Month.MARCH, 25), 2, 2, 1, 1);
    // cds.insertVoto(voto);
    Map<String, Integer> studentsInEachClass = cds.getStudentsInEachClass();
    System.out.println(studentsInEachClass);
  }

}
