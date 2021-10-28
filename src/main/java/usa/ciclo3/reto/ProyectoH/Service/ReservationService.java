/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.ciclo3.reto.ProyectoH.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo3.reto.ProyectoH.Modelo.Reservation;
import usa.ciclo3.reto.ProyectoH.Repository.ReservationRepository;

/**
 *
 * @author Andy
 */
@Service
public class ReservationService {

  @Autowired
  private ReservationRepository objRepository;

  //
  public List<Reservation> getRepositorys() {
    return (List<Reservation>) objRepository.getRepositorys();
  }

  public Optional<Reservation> getIdRep(int id) {
    return objRepository.getIdRep(id);
  }

  public Reservation saveRepository(Reservation objR) {

    if (objR.getIdReservation() == null) {
      return objRepository.saveRepository(objR);
    } else {

      Optional<Reservation> resAux = objRepository.getIdRep((objR.getIdReservation()));

      if (resAux.isEmpty()) {
        return objRepository.saveRepository(objR);

      } else {
        return objR;
      }
    }
  }

  //Reto 4 
  public Reservation updateReservation(Reservation objR) {
    if (objR.getIdReservation() != null) { //Verifica si el id no está vacío

      //Crea un auxiliar en el que se guarda el id del elemento
      Optional<Reservation> auxReservation = objRepository.getIdRep(objR.getIdReservation());

      //Verifica que el id no sea vacío
      if (!auxReservation.isEmpty()) {

        if (objR.getStartDate() != null) {
          auxReservation.get().setStartDate(objR.getStartDate());
        }

        if (objR.getDevolutionDate() != null) {
          auxReservation.get().setDevolutionDate(objR.getDevolutionDate());
        }

        if (objR.getStatus() != null) {
          auxReservation.get().setStatus(objR.getStatus());
        }

        //Tablas relacionadas 
        if (objR.getRoom() != null) {
          auxReservation.get().setRoom(objR.getRoom());
        }

        if (objR.getClient() != null) {
          auxReservation.get().setClient(objR.getClient());
        }

        if (objR.getScore() != null) {
          auxReservation.get().setScore(objR.getScore());
        }

        //Guarda el valor actual
        objRepository.saveRepository(auxReservation.get());

        //Retorna el valor 
        return auxReservation.get();
      } else {
        return objR;
      }
    } else {
      return objR;
    }
  }

  public Boolean delRepository(Integer id) {
    Boolean objEliminar = getIdRep(id).map(Reservation -> {
      objRepository.delRepository(Reservation);
      return true;
    }).orElse(false);
    return objEliminar;
  }
}
