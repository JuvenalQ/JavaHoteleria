/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.ciclo3.reto.ProyectoH.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo3.reto.ProyectoH.Modelo.Room;
import usa.ciclo3.reto.ProyectoH.Repository.RoomRepository;

/**
 *
 * @author Andy
 */
@Service
public class RoomService {

  //Instancia de repositrio
  @Autowired
  private RoomRepository objRepository;

  //obtiene todos los registros 
  public List<Room> getRooms() {
    return objRepository.getRooms();
  }

  //obtiene el registro seleccionado 
  public Optional<Room> getid(int id) {
    return objRepository.getId(id);
  }

  //
  public Room saveRoom(Room objR) {

    if (objR.getId() == null) {
      return objRepository.saveRoom(objR);
    } else {
      Optional<Room> auxRoom = objRepository.getId(objR.getId());

      if (auxRoom.isEmpty()) {
        return objRepository.saveRoom(objR);
      } else {
        return objR;
      }
    }
  }

  //Reto 4 
  public Room updateReservation(Room objR) {
    if (objR.getId() != null) { //Verifica si el id no está vacío

      //Crea un auxiliar en el que se guarda el id del elemento
      Optional<Room> auxRoom = objRepository.getId(objR.getId());

      //Verifica que el id no sea vacío
      if (!auxRoom.isEmpty()) {

        if (objR.getName() != null) {
          auxRoom.get().setName(objR.getName());
        }

        if (objR.getHotel() != null) {
          auxRoom.get().setHotel(objR.getHotel());
        }

        if (objR.getStars() != null) {
          auxRoom.get().setStars(objR.getStars());
        }

        if (objR.getDescription() != null) {
          auxRoom.get().setDescription(objR.getDescription());
        }

        //Tablas relacionadas   
        if (objR.getCategory() != null) {
          auxRoom.get().setCategory(objR.getCategory());
        }

        if (objR.getMessages() != null) {
          auxRoom.get().setMessages(objR.getMessages());
        }

        if (objR.getReservations() != null) {
          auxRoom.get().setReservations(objR.getReservations());
        }

        //Guarda el valor actual
        objRepository.saveRoom(auxRoom.get());

        //Retorna el valor 
        return auxRoom.get();
      } else {
        return objR;
      }
    } else {
      return objR;
    }
  }

  public Boolean delRoom(Integer id) {
    Boolean objEliminar = getid(id).map(Room -> {
      objRepository.delRoom(Room);
      return true;
    }).orElse(false);
    return objEliminar;
  }
}
