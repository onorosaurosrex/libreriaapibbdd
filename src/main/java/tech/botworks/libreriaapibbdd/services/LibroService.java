package tech.botworks.libreriaapibbdd.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.botworks.libreriaapibbdd.entities.Autor;
import tech.botworks.libreriaapibbdd.entities.Editorial;
import tech.botworks.libreriaapibbdd.entities.Libro;
import tech.botworks.libreriaapibbdd.modelos.LibroCreateDTO;
import tech.botworks.libreriaapibbdd.repositories.AutorRepository;
import tech.botworks.libreriaapibbdd.repositories.EditorialRepository;
import tech.botworks.libreriaapibbdd.repositories.LibroRepository;

@Service
public class LibroService {
  @Autowired
  public LibroRepository libroRepository;
  @Autowired
  public EditorialService editorialService;
  @Autowired
  public AutorService autorService;

  // CREATE

  public void crearLibro
    (LibroCreateDTO libroCreateDTO) {
      Libro nuevoLibro = new Libro();
      nuevoLibro.setIdLibro(libroCreateDTO.getIdLibro());
      nuevoLibro.setEjemplares(libroCreateDTO.getEjemplares());
      nuevoLibro.setTitulo(libroCreateDTO.getTitulo());
      Optional<Autor> nuevoAutor = autorService.buscarAutor(libroCreateDTO.getIdAutor());
      if (nuevoAutor.isPresent()){
        Autor autor = nuevoAutor.get();
        nuevoLibro.setIdAutor(autor);
      }
      Optional<Editorial> nuevoEditorial = editorialService.buscarEditorial(libroCreateDTO.getIdEditorial());
      if (nuevoEditorial.isPresent()) {
        Editorial editorial = nuevoEditorial.get();
        nuevoLibro.setIdEditorial(editorial);
      }

      libroRepository.save(nuevoLibro);


      
      // private Long idLibro;
      // private int ejemplares;
      // private Boolean libroActivo;
      // private String titulo;
      // private String idAutor;
      // private String idEditorial;
                          }


}
