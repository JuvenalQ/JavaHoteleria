/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.ciclo3.reto.ProyectoH.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo3.reto.ProyectoH.Modelo.Client;
import usa.ciclo3.reto.ProyectoH.Repository.ClientRepository;

/**
 *
 * @author Andy
 */
@Service
public class ClientService {

  @Autowired
  private ClientRepository objClientRepository;

  //
  public List<Client> getClients() {
    return (List<Client>) objClientRepository.getClients();
  }

  //
  public Optional<Client> getId(int id) {
    return objClientRepository.getId(id);
  }

  //
  public Client saveClient(Client objC) {
    if (objC.getIdClient() == null) {
      return objClientRepository.saveClient(objC);
    } else {
      Optional<Client> auxClient = objClientRepository.getId(objC.getIdClient());

      if (auxClient.isEmpty()) {
        return objClientRepository.saveClient(objC);
      } else {
        return objC;
      }
    }
  }

  //Reto 4 
  public Client updateClient(Client objC) {
    if (objC.getIdClient() != null) { //Verifica si el id no está vacío

      //Crea un auxiliar en el que se guarda el id del elemento
      Optional<Client> auxClient = objClientRepository.getId(objC.getIdClient());

      //Verifica que el id no sea vacío
      if (!auxClient.isEmpty()) {

        if (objC.getName() != null) {
          auxClient.get().setName(objC.getName());
        }

        if (objC.getEmail() != null) {
          auxClient.get().setEmail(objC.getEmail());
        }

        if (objC.getPassword() != null) {
          auxClient.get().setPassword(objC.getPassword());
        }

        if (objC.getAge() != null) {
          auxClient.get().setAge(objC.getAge());
        }

        //tablas relacionadas 
        if (objC.getMessages() != null) {
          auxClient.get().setMessages(objC.getMessages());
        }

        if (objC.getReservations() != null) {
          auxClient.get().setReservations(objC.getReservations());
        }

        //Guarda el valor actual
        objClientRepository.saveClient(auxClient.get());

        //Retorna el valor 
        return auxClient.get();
      } else {
        return objC;
      }
    } else {
      return objC;
    }
  }

  public Boolean delClient(Integer id) {
    Boolean objEliminar = getId(id).map(Client -> {
      objClientRepository.delClient(Client);
      return true;
    }).orElse(false);
    return objEliminar;
  }

}
