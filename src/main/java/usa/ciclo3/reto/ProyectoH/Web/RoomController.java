/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.ciclo3.reto.ProyectoH.Web;

import java.util.List;
import java.util.Optional;
//import javax.websocket.server.PathParam;
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
import usa.ciclo3.reto.ProyectoH.Modelo.Room;
import usa.ciclo3.reto.ProyectoH.Service.RoomService;

/**
 *
 * @author Andy
 */
@RestController
@RequestMapping("/api/Room") // /api/Room/save
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class RoomController {

  @Autowired
  private RoomService objRoomService;

  @GetMapping("/all")
  public List<Room> getRooms() {
    return objRoomService.getRooms();
  }

  @GetMapping({"/id"})
  public Optional<Room> getId(@PathVariable("id") int id) {
    return objRoomService.getid(id);
  }

  @PostMapping("/save")
  @ResponseStatus(HttpStatus.CREATED)
  public Room saveRoom(@RequestBody Room objR) {
    return objRoomService.saveRoom(objR);
  }

  //RETO4
  @PutMapping("/update")
  @ResponseStatus(HttpStatus.CREATED)
  public Room updateRoom(@RequestBody Room objR) {
    return objRoomService.updateReservation(objR);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Boolean delRepository(@PathVariable Integer id) {
    return objRoomService.delRoom(id);
  }
}
