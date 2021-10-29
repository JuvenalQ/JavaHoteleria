/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.ciclo3.reto.ProyectoH.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author Andy
 */
@Entity
@Table(name = "Reservation")
public class Reservation implements Serializable {
  //{"startDate":"2020-12-20","devolutionDate":"2020-12-20","client":{"idClient":1},"room":{"id":1}}

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  /**
   * variable
   */
  private Integer idReservation;
  //@Temporal(TemporalType.TIMESTAMP)
  /**
   * variable
   */
  private Date startDate;
  //@Temporal(TemporalType.TIMESTAMP)
  /**
   * variable
   */
  private Date devolutionDate;
  /**
   * variable
   */
  private String status = "created";

  //relacion tabla room
  @ManyToOne
  @JoinColumn(name = "RoomId")
  @JsonIgnoreProperties({"reservations", "room", "client"})
  /**
   * variable
   */
  private Room room;

  //relacion tabla cliente 
  @ManyToOne
  @JoinColumn(name = "ClientId")
  @JsonIgnoreProperties({"reservations", "client", "messages"})
  /**
   * variable
   */
  private Client client;

  @OneToOne
  @JsonIgnoreProperties("reservations")
  /**
   * variable
   */
  private Score score;

  public Integer getIdReservation() {
    return idReservation;
  }

  public void setIdReservation(Integer idReservation) {
    this.idReservation = idReservation;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getDevolutionDate() {
    return devolutionDate;
  }

  public void setDevolutionDate(Date devolutionDate) {
    this.devolutionDate = devolutionDate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
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

  public Score getScore() {
    return score;
  }

  public void setScore(Score score) {
    this.score = score;
  }

}
