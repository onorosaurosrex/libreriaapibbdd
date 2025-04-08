package tech.botworks.libreriaapibbdd.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tech.botworks.libreriaapibbdd.entities.Autor;
import tech.botworks.libreriaapibbdd.entities.Editorial;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial,String>  {
 
  @Query("SELECT e FROM Editorial e WHERE e.idEditorial = :idEditorial")
  Optional<Editorial> buscarEditorial(@Param("idEditorial") String idEditorial);

  
}
