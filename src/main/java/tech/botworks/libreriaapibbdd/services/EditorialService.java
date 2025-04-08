package tech.botworks.libreriaapibbdd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import tech.botworks.libreriaapibbdd.entities.Autor;
import tech.botworks.libreriaapibbdd.entities.Editorial;
import tech.botworks.libreriaapibbdd.modelos.EditorialCreateDTO;
import tech.botworks.libreriaapibbdd.modelos.EditorialDTO;
import tech.botworks.libreriaapibbdd.repositories.AutorRepository;
import tech.botworks.libreriaapibbdd.repositories.EditorialRepository;

@Service
public class EditorialService {
  @Autowired
  EditorialRepository editorialRepository;

  //CREAR
  public void crearEditorial(String nombreEditorial) {
    Editorial editorial = new Editorial();
    editorial.setNombreEditorial(nombreEditorial);
    editorialRepository.save(editorial);
  }

  public void crearEditorialDTO (EditorialCreateDTO editorialCreateDTO) {
    Editorial editorial = new Editorial();
    editorial.setNombreEditorial(editorialCreateDTO.getNombreEditorial());
    editorialRepository.save(editorial);
  }

  // MODIFICAR
  public void modificarEditorial(String idEditorial, Boolean estado, String nombreEditorial) {
    Editorial editorial = editorialRepository.findById(idEditorial).get();
    editorial.setNombreEditorial(nombreEditorial);
    editorial.setEditorialActiva(estado);
    editorialRepository.save(editorial);
  }

  // BUSCAR (todos)
  public List<Editorial> listarEditoriales() {
    return editorialRepository.findAll();
  }
  
  //BUSCAR (Encontrar uno)
  public Editorial encontrarEditorial(String idEditorial){
    return editorialRepository.getReferenceById(idEditorial);
  }

  public Optional<Editorial> buscarEditorial (String idEditorial){
    return editorialRepository.buscarEditorial(idEditorial);
  }

    public EditorialDTO obtenerEditorialDTO(String id) {
        Optional<Editorial> optionalEditorial = editorialRepository.findById(id);
        Editorial editorial = null;
        try {
            // Verificamos si el valor está presente en el Optional
            if (optionalEditorial.isPresent()) {
                editorial = optionalEditorial.get();
            } else {
                throw new EntityNotFoundException("No se encontró la editorial con ID: " + id);
            }
        } catch (EntityNotFoundException e) {
            // Manejo de la excepción en caso de que no se encuentre la entidad
            throw e; // Lanzamos la excepción personalizada
        }
       
        // Mapear la entidad a DTO
        return new EditorialDTO(editorial.getIdEditorial(),  editorial.isEditorialActiva(),editorial.getNombreEditorial());



    }

  //BORRAR (DESACTIVAR)
  public void borrarEditorial(String idEditorial) {
    Editorial editorial = editorialRepository.getReferenceById(idEditorial);
    editorial.setEditorialActiva(false);
    editorialRepository.save(editorial);
  }
}
