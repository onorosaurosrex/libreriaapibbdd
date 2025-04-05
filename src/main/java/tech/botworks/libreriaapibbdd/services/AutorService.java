package tech.botworks.libreriaapibbdd.services;

// import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import tech.botworks.libreriaapibbdd.entities.Autor;
import tech.botworks.libreriaapibbdd.repositories.AutorRepository;

import java.lang.classfile.ClassFile.Option;
import java.util.List;

@Service
public class AutorService {
  @Autowired
  AutorRepository autorRepository;

  //CREAR
  public void crearAutor(String nombreAutor){
    Autor autor = new Autor();
    autor.setNombreAutor(nombreAutor);
    autorRepository.save(autor);
  }
  //MODIFICAR --> PATCH
  public void modificarAutor (String idAutor, String nombreAutor) {
    Optional<Autor> respuesta = autorRepository.findById(idAutor);
    if (respuesta.isPresent()) {
      Autor autor = respuesta.get();
      autor.setNombreAutor(nombreAutor);
      autorRepository.save(autor);
    }
  }


  //BUSCAR (Listar todos)
  public List<Autor> listarAutores() {
    return autorRepository.findAll();
    // return autorRepository.findAllByAutorActivoIsTrue();
  }

  // BUSCAR (Listar activos)
  public List<Autor> listarAutoresActivos() {
    return autorRepository.findAllByAutorActivoIsTrue();
  }

  // BUSCAR (Listar borrados)
  public List<Autor> listarAutoresBorrados() {
    return autorRepository.findAllByAutorActivoIsFalse();
  }

  //BUSCAR (Encontrar uno)
  public Optional<Autor> buscarAutor(String idAutor){
    return autorRepository.buscarAutor(idAutor);
  }


  //BORRAR (DESACTIVAR)
  public void borrarAutor(String idAutor) {
    Autor autor = autorRepository.getReferenceById(idAutor);
    autor.setAutorActivo(false);
    autorRepository.save(autor);
  }
}
