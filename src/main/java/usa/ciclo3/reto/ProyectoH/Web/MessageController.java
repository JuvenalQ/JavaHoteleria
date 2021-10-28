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
import usa.ciclo3.reto.ProyectoH.Modelo.Message;
import usa.ciclo3.reto.ProyectoH.Service.MessageService;

/**
 *
 * @author Andy
 */
@RestController
@RequestMapping("/api/Message") ///api/Message/save
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MessageController {

  @Autowired
  private MessageService objMessageService;

  @GetMapping("/all")
  public List<Message> getMessages() {
    return objMessageService.getMessages();
  }

  @GetMapping({"/id"})
  public Optional<Message> getId(@PathVariable("id") int id) {
    return objMessageService.getId(id);
  }

  @PostMapping("/save")
  @ResponseStatus(HttpStatus.CREATED)
  public Message saveMessage(@RequestBody Message objM) {
    return objMessageService.saveMesage(objM);
  }

  //reto4
  @PutMapping("/update")
  @ResponseStatus(HttpStatus.CREATED)
  public Message updateMessage(@RequestBody Message objM) {
    return objMessageService.updateMessage(objM);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Boolean delMessage(@PathVariable Integer id) {
    return objMessageService.delMessage(id);
  }
}
