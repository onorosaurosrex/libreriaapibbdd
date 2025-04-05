package tech.botworks.libreriaapibbdd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tech.botworks.libreriaapibbdd.entities.Autor;
import tech.botworks.libreriaapibbdd.services.AutorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;


@RestController
@RequestMapping("/autores")
public class AutorController {
  // Instancio al servicio, para poder acceder a sus métodos.
  @Autowired
  private AutorService autorService;

  @PostMapping("crear")
  public ResponseEntity<Object> crearAutor(@RequestBody String nombre) {
    try {
      autorService.crearAutor(nombre);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("borrar")
  public ResponseEntity<Object> borrarAutor(String idAutor) {
    try {
      autorService.borrarAutor(idAutor);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

 @GetMapping("listar")
    public ResponseEntity<Object> listarAutores() {
        try {
            return new ResponseEntity<>(autorService.listarAutores(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("listaractivos")
    public ResponseEntity<Object> listarAutoresActivos() {
      try {
        return new ResponseEntity<>(autorService.listarAutoresActivos(), HttpStatus.OK);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    @GetMapping("listarborrados")
    public ResponseEntity<Object> listarAutoresBorrados() {
      try {
        return new ResponseEntity<>(autorService.listarAutoresBorrados(), HttpStatus.OK);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
    
  @GetMapping("buscar")
  public ResponseEntity<Object> buscarAutor(String idAutor) {
    try {
      return new ResponseEntity<>(autorService.buscarAutor(idAutor),HttpStatus.OK);

    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }  
  }
  
   @PatchMapping("modificar")
    public ResponseEntity<Void> modificarAutor(String id,String nombre) {
        try {
            autorService.modificarAutor(id,nombre);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

  }
  

