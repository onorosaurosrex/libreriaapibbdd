package tech.botworks.libreriaapibbdd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.botworks.libreriaapibbdd.entities.Autor;
import tech.botworks.libreriaapibbdd.entities.Editorial;
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

  // MODIFICAR
  public void modificarEditorial(byte[] idEditorial, Boolean estado, String nombreEditorial) {
    Editorial editorial = editorialRepository.findById(idEditorial).get();
    editorial.setNombreEditorial(nombreEditorial);
    editorial.setEditorialActiva(estado);
    editorialRepository.save(editorial);
  }

  // BUSCAR (todos)
  private List<Editorial> listarEditoriales() {
    return editorialRepository.findAll();
  }
  
  //BUSCAR (Encontrar uno)
  public Editorial encontrarEditorial(byte[] idEditorial){
    return editorialRepository.getReferenceById(idEditorial);
  }

  public Optional<Editorial> buscarEditorial (byte[] idEditorial){
    return editorialRepository.buscarEditorial(idEditorial);
  }
  

  //BORRAR (DESACTIVAR)
  public void borrarEditorial(byte[] idEditorial) {
    Editorial editorial = editorialRepository.getReferenceById(idEditorial);
    editorial.setEditorialActiva(false);
    editorialRepository.save(editorial);
  }
}
