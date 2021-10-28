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
import usa.ciclo3.reto.ProyectoH.Modelo.Category;
import usa.ciclo3.reto.ProyectoH.Service.CategoryService;

/**
 *
 * @author Andy
 */
@RestController
@RequestMapping("/api/Category") // /api/Category/save
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CategoryController {

  @Autowired
  private CategoryService objCategoryService;

  @GetMapping("/all")
  public List<Category> getCategory() {
    return objCategoryService.getCategory();
  }

  @GetMapping({"/id"})
  public Optional<Category> getIdCat(@PathVariable("id") int id) {
    return objCategoryService.getIdCat(id);
  }

  @PostMapping("/save")
  @ResponseStatus(HttpStatus.CREATED)
  public Category saveCategory(@RequestBody Category objC) {
    return objCategoryService.saveCategory(objC);
  }

  //RETO4
  @PutMapping("/update")
  @ResponseStatus(HttpStatus.CREATED)
  public Category updateCategory(@RequestBody Category category) {
    return objCategoryService.updateCategory(category);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Boolean delCategory(@PathVariable Integer id) {
    return objCategoryService.delCategory(id);
  }
}
