package usa.ciclo3.reto.ProyectoH;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"usa.ciclo3.reto.ProyectoH.Modelo"})
@SpringBootApplication
public class ProyectoHoteleriaApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProyectoHoteleriaApplication.class, args);
  }

}
