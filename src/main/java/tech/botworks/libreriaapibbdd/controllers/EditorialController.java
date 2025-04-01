package tech.botworks.libreriaapibbdd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.botworks.libreriaapibbdd.services.AutorService;
import tech.botworks.libreriaapibbdd.services.EditorialService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping ("/editorial")
public class EditorialController {

    private final AutorService autorService;
  @Autowired
  private EditorialService editorialService;

    EditorialController(AutorService autorService) {
        this.autorService = autorService;
    }

  @PostMapping("/crear")
  public ResponseEntity<Object> crearEditorial(String nombreEditorial) {
    try {
      editorialService.crearEditorial(nombreEditorial);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }
  
  
}
