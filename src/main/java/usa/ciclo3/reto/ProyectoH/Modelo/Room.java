/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.ciclo3.reto.ProyectoH.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Andy
 */
@Entity
@Table(name = "Room")
public class Room implements Serializable {
//{"name":"425","stars":5,"category":{"id":1},"hotel":"DeCameron","description":"Habitación sencilla"

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // genera las tablas
  /**
   * Variable
   */
  private Integer id;
  /**
   * Variable
   */
  private String name;
  /**
   * Variable
   */
  private String hotel;
  /**
   * Variable
   */
  private Integer stars;
  /**
   * Variable
   */
  private String description;

  //relacion con la tabla categoria
  @ManyToOne
  @JoinColumn(name = "categoryId") //nombre de la llave foranea
  @JsonIgnoreProperties({"rooms", "category"})//
  /**
   * Variable
   */
  private Category category;  //instancia de categoria y donde hace el mapeo para la relacion 

  //relacion  tabla mensajes
  @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "room")
  @JsonIgnoreProperties({"room", "client"})//room
  /**
   * Variable
   */
  public List< Message> messages;

  //relacion tabla reservacion 
  @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "room")
  @JsonIgnoreProperties({"room", "reservations"})
  /**
   * Variable
   */
  public List<Reservation> reservations;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getHotel() {
    return hotel;
  }

  public void setHotel(String hotel) {
    this.hotel = hotel;
  }

  public Integer getStars() {
    return stars;
  }

  public void setStars(Integer stars) {
    this.stars = stars;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public List<Message> getMessages() {
    return messages;
  }

  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }

  public List<Reservation> getReservations() {
    return reservations;
  }

  public void setReservations(List<Reservation> reservations) {
    this.reservations = reservations;
  }
//http://129.151.117.48:8080/
}
