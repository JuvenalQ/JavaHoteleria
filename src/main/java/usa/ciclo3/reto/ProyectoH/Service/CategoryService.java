/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.ciclo3.reto.ProyectoH.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo3.reto.ProyectoH.Modelo.Category;
import usa.ciclo3.reto.ProyectoH.Repository.CategoryRepository;

/**
 *
 * @author Andy
 */
@Service
public class CategoryService {

  @Autowired
  private CategoryRepository objCategoryRepository;

  public List<Category> getCategory() {
    return objCategoryRepository.getCategory();
  }

  public Optional<Category> getIdCat(int id) {
    return objCategoryRepository.getIdCat(id);
  }

  public Category saveCategory(Category objC) {
    if (objC.getId() == null) {
      return objCategoryRepository.saveCategory(objC);
    } else {
      Optional<Category> catAux = objCategoryRepository.getIdCat(objC.getId());

      if (catAux.isEmpty()) {
        return objCategoryRepository.saveCategory(objC);
      } else {
        return objC;
      }
    }
  }

  //Reto 4 
  public Category updateCategory(Category objC) {
    if (objC.getId() != null) { //Verifica si el id no está vacío

      //Crea un auxiliar en el que se guarda el id del elemento
      Optional<Category> categoryAux = objCategoryRepository.getIdCat(objC.getId());

      //Verifica que el id no sea vacío
      if (!categoryAux.isEmpty()) {

        //Verifica que el nombre no sea vacío
        if (objC.getName() != null) {
          //busca el nombre y sobreescribe el nombre actual que se consigue con .get()
          categoryAux.get().setName(objC.getName());
        }

        //Verifica que la descripción no sea vacía
        if (objC.getDescription() != null) {

          //Busca la desc actual y la sobreescribe
          categoryAux.get().setDescription(objC.getDescription());
        }

        //Guarda el valor actual de categoryAux
        objCategoryRepository.saveCategory(categoryAux.get());

        //Retorna el valor de categoryAux
        return categoryAux.get();
      } else {

        //Si name o description son vacios retorna el objeto original
        return objC;
      }
    } else {

      //Si el id es null retorna el objeto original
      return objC;
    }
  }

  public Boolean delCategory(Integer id) {
    Boolean objEliminar = getIdCat(id).map(category -> {
      objCategoryRepository.delCategory(category);
      return true;
    }).orElse(false);
    return objEliminar;
  }
}
