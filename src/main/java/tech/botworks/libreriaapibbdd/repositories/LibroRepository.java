package tech.botworks.libreriaapibbdd.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tech.botworks.libreriaapibbdd.entities.Libro;
import tech.botworks.libreriaapibbdd.modelos.LibroListarActivosDTO;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
  // Inside the Query we select titulo and ejemplares from Libro and
  // save them inside a new LibroListaActivosDTO object.
  // Apparently it needs a fully qualified name.
  @Query ("SELECT new tech.botworks.libreriaapibbdd.modelos.LibroListarActivosDTO(l.ejemplares, l.titulo)" + "FROM Libro l WHERE l.libroActivo=true")
  List<LibroListarActivosDTO>listarActivos();
}
