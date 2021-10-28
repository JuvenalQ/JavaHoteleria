/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.ciclo3.reto.ProyectoH.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.ciclo3.reto.ProyectoH.Modelo.Score;
import usa.ciclo3.reto.ProyectoH.Repository.Crud.ScoreCrud;

/**
 *
 * @author Andy
 */
@Repository
public class ScoreRepository {

  @Autowired
  private ScoreCrud objScoreCrud;

  //Obtiene los registro de la tabla 
  public List<Score> getScores() {
    return (List<Score>) objScoreCrud.findAll();
  }

  //obtiene el id seleccionado 
  public Optional<Score> getId(int id) {
    return objScoreCrud.findById(id);
  }

  //guardas la habitacion 
  public Score saveScore(Score objR) {
    return objScoreCrud.save(objR);
  }

  //Agregue este metodo 4 
  public void delScore(Score objS) {
    objScoreCrud.delete(objS);
  }

}
