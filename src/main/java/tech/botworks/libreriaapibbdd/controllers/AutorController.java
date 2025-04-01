import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tech.botworks.libreriaapibbdd.services.AutorService;

@RestController
@RequestMapping("/autor")
public class AutorController {
  // Instancio al servicio, para poder acceder a sus métodos.
  @Autowired
  private AutorService autorService;

  @PostMapping("crear")
  public ResponseEntity<Object> crearAutor(String nombre) {
    try {
      autorService.crearAutor(nombre);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
