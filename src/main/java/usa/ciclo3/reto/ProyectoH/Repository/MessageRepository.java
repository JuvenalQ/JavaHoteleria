/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.ciclo3.reto.ProyectoH.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.ciclo3.reto.ProyectoH.Modelo.Message;
import usa.ciclo3.reto.ProyectoH.Repository.Crud.MessageCrud;

/**
 *
 * @author Andy
 */
@Repository
public class MessageRepository {

  @Autowired
  private MessageCrud objMessageCrud;

  //
  public List<Message> getMessages() {
    return (List<Message>) objMessageCrud.findAll();
  }

  // 
  public Optional<Message> getId(int id) {
    return objMessageCrud.findById(id);
  }

  //
  public Message saveMessage(Message objM) {
    return objMessageCrud.save(objM);
  }

  //Agregue este metodo 4 
  public void delMessage(Message objM) {
    objMessageCrud.delete(objM);
  }
}
