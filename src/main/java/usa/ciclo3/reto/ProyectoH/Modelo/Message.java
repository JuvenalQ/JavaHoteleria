/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.ciclo3.reto.ProyectoH.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Andy
 */
@Entity
@Table(name = "Message")
public class Message implements Serializable {

//{"messageText":"Me gusta.","client":{"idClient":1},"room":{"id":1}}
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idMessage;
  private String messageText;

  //relacion tabla habitacion
  @ManyToOne
  @JoinColumn(name = "roomId")
  @JsonIgnoreProperties({"messages", "reservations", "client"})//
  private Room room;

  //relacion tabla cliente
  @ManyToOne
  @JoinColumn(name = "idClient")
  @JsonIgnoreProperties({"client", "messages", "reservations"})
  private Client client;

  public Integer getIdMessage() {
    return idMessage;
  }

  public void setIdMessage(Integer idMessage) {
    this.idMessage = idMessage;
  }

  public String getMessageText() {
    return messageText;
  }

  public void setMessageText(String messageText) {
    this.messageText = messageText;
  }

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }
}
