package tech.botworks.libreriaapibbdd.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.botworks.libreriaapibbdd.modelos.EditorialCreateDTO;
import tech.botworks.libreriaapibbdd.modelos.EditorialDTO;
import tech.botworks.libreriaapibbdd.services.EditorialService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping ("/editoriales")
public class EditorialController {

  @Autowired
  private EditorialService editorialService;

  @PostMapping("/nueva")
  public ResponseEntity<Object> crearEditorial(@RequestBody EditorialCreateDTO editorialCreateDTO) {
    try {
      editorialService.crearEditorialDTO(editorialCreateDTO);
      return new ResponseEntity<>(HttpStatus.CREATED);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
      .body("{\"Algun dato no es correcto o es nulo, revisar.\"}");
    }
  }
  
   @GetMapping("listar")
    public ResponseEntity<Object> listarEditoriales() {
        
      try {
        
          return new ResponseEntity<>(editorialService.listarEditoriales(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{editorialId}")
    public ResponseEntity<Object> encontrarEditorial(@PathVariable String editorialId) {
      
      try {
        EditorialDTO editorial = editorialService.obtenerEditorialDTO(editorialId);
        return ResponseEntity.ok(editorial);

      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }  
    }
    
}
