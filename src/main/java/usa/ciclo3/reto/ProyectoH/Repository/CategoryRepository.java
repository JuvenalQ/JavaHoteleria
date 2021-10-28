/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.ciclo3.reto.ProyectoH.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.ciclo3.reto.ProyectoH.Modelo.Category;
import usa.ciclo3.reto.ProyectoH.Repository.Crud.CategoryCrud;

/**
 *
 * @author Andy
 */
@Repository
public class CategoryRepository {

  @Autowired
  private CategoryCrud objCategoryCrud;

  //
  public List<Category> getCategory() {
    return (List<Category>) objCategoryCrud.findAll();
  }

  public Optional<Category> getIdCat(int id) {
    return objCategoryCrud.findById(id);
  }

  public Category saveCategory(Category objC) {
    return objCategoryCrud.save(objC);
  }

  //Agregue este metodo 4 
  public void delCategory(Category objC) {
    objCategoryCrud.delete(objC);
  }
}
