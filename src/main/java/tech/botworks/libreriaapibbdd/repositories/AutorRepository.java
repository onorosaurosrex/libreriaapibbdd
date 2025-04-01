package tech.botworks.libreriaapibbdd.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tech.botworks.libreriaapibbdd.entities.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, String>{

  List<Autor> findAllByAutorActivoIsTrue();

  @Query("SELECT a FROM Autor a WHERE a.idAutor = :idAutor")
  Optional<Autor> buscarAutor(@Param("idAutor") String idAutor);

}
