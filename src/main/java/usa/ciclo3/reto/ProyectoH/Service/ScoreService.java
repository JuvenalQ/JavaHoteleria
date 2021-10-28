/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.ciclo3.reto.ProyectoH.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo3.reto.ProyectoH.Modelo.Score;
import usa.ciclo3.reto.ProyectoH.Repository.ScoreRepository;

/**
 *
 * @author Andy
 */
@Service
public class ScoreService {

  @Autowired
  private ScoreRepository objRepository;

  //Obtiene los registro de la tabla 
  public List<Score> getScores() {
    return (List<Score>) objRepository.getScores();
  }

  //obtiene el id seleccionado 
  public Optional<Score> getId(int id) {
    return objRepository.getId(id);
  }

  //guardas 
  public Score saveScore(Score objS) {

    if (objS.getId() == null) {
      return objRepository.saveScore(objS);
    } else {
      Optional<Score> auxScore = objRepository.getId(objS.getId());

      if (auxScore.isEmpty()) {
        return objRepository.saveScore(objS);
      } else {
        return objS;
      }
    }
  }

  //Reto 4 
  public Score updateScore(Score objS) {
    if (objS.getId() != null) { //Verifica si el id no está vacío

      //Crea un auxiliar en el que se guarda el id del elemento
      Optional<Score> auxScore = objRepository.getId(objS.getId());

      //Verifica que el id no sea vacío
      if (!auxScore.isEmpty()) {

        if (objS.getScore() != null) {
          auxScore.get().setScore(objS.getScore());
        }

        if (objS.getMessage() != null) {
          auxScore.get().setMessage(objS.getMessage());
        }

        if (objS.getMessage() != null) {
          auxScore.get().setMessage(objS.getMessage());
        }

        //Guarda el valor actual
        objRepository.saveScore(auxScore.get());

        //Retorna el valor 
        return auxScore.get();
      } else {
        return objS;
      }
    } else {
      return objS;
    }
  }

  public Boolean delScore(Integer id) {
    Boolean objEliminar = getId(id).map(Score -> {
      objRepository.delScore(Score);
      return true;
    }).orElse(false);
    return objEliminar;
  }
}
