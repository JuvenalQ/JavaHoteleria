/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.ciclo3.reto.ProyectoH.Web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import usa.ciclo3.reto.ProyectoH.Modelo.Score;
import usa.ciclo3.reto.ProyectoH.Service.ScoreService;

/**
 *
 * @author Andy
 */
@RestController
@RequestMapping("/api/Score") ///api/Score/save
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ScoreController {

  @Autowired
  private ScoreService objScoreService;

  @GetMapping("/all")
  public List<Score> getScores() {
    return objScoreService.getScores();
  }

  @GetMapping({"/id"})
  public Optional<Score> getId(@PathVariable("id") int id) {
    return objScoreService.getId(id);
  }

  @PostMapping("/save")
  @ResponseStatus(HttpStatus.CREATED)
  public Score saveScore(@RequestBody Score objR) {
    return objScoreService.saveScore(objR);
  }

  //RETO4
  @PutMapping("/update")
  @ResponseStatus(HttpStatus.CREATED)
  public Score updateScore(@RequestBody Score objS) {
    return objScoreService.updateScore(objS);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Boolean delScore(@PathVariable Integer id) {
    return objScoreService.delScore(id);
  }

  
  //Nueva rama  listo  para la maquina 
}
