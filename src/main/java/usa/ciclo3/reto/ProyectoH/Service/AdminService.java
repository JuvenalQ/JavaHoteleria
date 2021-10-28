/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.ciclo3.reto.ProyectoH.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo3.reto.ProyectoH.Modelo.Admin;
import usa.ciclo3.reto.ProyectoH.Repository.AdminRepository;

/**
 *
 * @author Andy
 */
@Service
public class AdminService {

  @Autowired
  private AdminRepository objAdminRepository;

  public List<Admin> getAdmins() {
    return objAdminRepository.getAdmins();
  }

  public Optional<Admin> getId(int id) {
    return objAdminRepository.getId(id);
  }

  public Admin saveAdmin(Admin objA) {
    if (objA.getId() == null) {
      return objAdminRepository.SaveAdmin(objA);
    } else {
      Optional auxAd = objAdminRepository.getId(objA.getId());
      if (auxAd.isEmpty()) {
        return objAdminRepository.SaveAdmin(objA);
      } else {
        return objA;
      }
    }
  }

  //Reto 4 
  public Admin updateAdmin(Admin objA) {
    if (objA.getId() != null) { //Verifica si el id no está vacío

      //Crea un auxiliar en el que se guarda el id del elemento
      Optional<Admin> auxAd = objAdminRepository.getId(objA.getId());

      //Verifica que el id no sea vacío
      if (!auxAd.isEmpty()) {

        if (objA.getName() != null) {
          auxAd.get().setName(objA.getName());
        }

        if (objA.getEmail() != null) {
          auxAd.get().setEmail(objA.getEmail());
        }

        if (objA.getPassword() != null) {
          auxAd.get().setPassword(objA.getPassword());
        }

        //Guarda el valor actual de categoryAux
        objAdminRepository.SaveAdmin(auxAd.get());

        //Retorna el valor de categoryAux
        return auxAd.get();
      } else {
        return objA;
      }
    } else {
      return objA;
    }
  }

  public Boolean delAdmin(Integer id) {
    Boolean objEliminar = getId(id).map(Admin -> {
      objAdminRepository.delAdmin(Admin);
      return true;
    }).orElse(false);
    return objEliminar;
  }
}
