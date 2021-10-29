/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.ciclo3.reto.ProyectoH.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.ciclo3.reto.ProyectoH.Modelo.Client;
import usa.ciclo3.reto.ProyectoH.Modelo.Reservation;
import usa.ciclo3.reto.ProyectoH.Modelo.TopClient;
import usa.ciclo3.reto.ProyectoH.Repository.Crud.ReservationCrud;

/**
 *
 * @author Andy
 */
@Repository
public class ReservationRepository {

  @Autowired
  private ReservationCrud objReservationCrud;

  //
  public List<Reservation> getRepositorys() {
    return (List<Reservation>) objReservationCrud.findAll();
  }

  public Optional<Reservation> getIdRep(int id) {
    return objReservationCrud.findById(id);
  }

  public Reservation saveRepository(Reservation objR) {
    return objReservationCrud.save(objR);
  }

  //Agregue este metodo 4 
  public void delRepository(Reservation objR) {
    objReservationCrud.delete(objR);
  }

  //Reto5
  public List<Reservation> getReservationStatus(String status) {
    return objReservationCrud.findAllByStatus(status);
  }

  public List<Reservation> ReservacionTimes(Date initialTime, Date finalTime) {
    return objReservationCrud.findAllByStartDateAfterAndStartDateBefore(initialTime, finalTime);
  }

  //Esperar a ver pendiente 
  public List<TopClient> getTopClientRes() {

    //Se guarda los clientes de reservaciones 
    List<TopClient> listaClientes = new ArrayList<>();

    List<Object[]> report = objReservationCrud.countTotalReservationsByClient();
    for (int i = 0; i < report.size(); i++) {

      //devuelve la consulta primero va el numero y  despues el cliente 
      listaClientes.add(new TopClient((Long) report.get(i)[1], (Client) report.get(i)[0]));
    }
    return listaClientes;
  }

}
