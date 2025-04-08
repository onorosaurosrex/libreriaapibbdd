package tech.botworks.libreriaapibbdd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.botworks.libreriaapibbdd.modelos.LibroCreateDTO;
import tech.botworks.libreriaapibbdd.modelos.LibroListarActivosDTO;
import tech.botworks.libreriaapibbdd.services.LibroService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping ("/libros")
public class LibroController {
  @Autowired
  private LibroService libroService;

  @PostMapping("nuevo")
  public ResponseEntity<Object> crearLibro(@RequestBody LibroCreateDTO libroCreateDTO) {
    try {
      libroService.crearLibro(libroCreateDTO);
      return new ResponseEntity<>(HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }  
  }

  @GetMapping("lista")
  public ResponseEntity<List<LibroListarActivosDTO>> listarLibros() {
      return new ResponseEntity<>(libroService.listarActivos(), HttpStatus.OK);
  }
  
  
   
}
