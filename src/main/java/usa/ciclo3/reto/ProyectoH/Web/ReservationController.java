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
import usa.ciclo3.reto.ProyectoH.Modelo.Reservation;
import usa.ciclo3.reto.ProyectoH.Modelo.StatusReservas;
import usa.ciclo3.reto.ProyectoH.Modelo.TopClient;
import usa.ciclo3.reto.ProyectoH.Service.ReservationService;

/**
 *
 * @author Andy
 */
@RestController
@RequestMapping("/api/Reservation") //api/Reservation/all
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {

  @Autowired
  private ReservationService objReservationService;

  @GetMapping("/all")
  public List<Reservation> getRepositorys() {
    return objReservationService.getRepositorys();
  }

  @GetMapping({"/id"})
  public Optional<Reservation> getIdRep(int id) {
    return objReservationService.getIdRep(id);
  }

  @PostMapping("/save")
  @ResponseStatus(HttpStatus.CREATED)
  public Reservation saveRepository(@RequestBody Reservation objR) {
    return objReservationService.saveRepository(objR);
  }

  //RETO4
  @PutMapping("/update")
  @ResponseStatus(HttpStatus.CREATED)
  public Reservation updateReservation(@RequestBody Reservation objR) {
    return objReservationService.updateReservation(objR);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Boolean delRepository(@PathVariable Integer id) {
    return objReservationService.delRepository(id);
  }

  //reto5 
  @GetMapping("/report-status")
  public StatusReservas getReservationStatus() {
    return objReservationService.getReservationStatus();
  }

  @GetMapping("/report-dates/{dateOne}/{dateTwo}")
  public List<Reservation> getReservasTiempo(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo) {
    return objReservationService.ReservacionTimes(dateOne, dateTwo);
  }

  @GetMapping("/report-clients")
  public List<TopClient> getClientes() {
    return objReservationService.getTopClientRes();
  }
}
