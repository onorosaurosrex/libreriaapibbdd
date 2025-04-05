package tech.botworks.libreriaapibbdd.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tech.botworks.libreriaapibbdd.entities.Autor;
import tech.botworks.libreriaapibbdd.entities.Editorial;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial,byte[]>  {
 
    @Query("SELECT a FROM Editorial e WHERE e.idEditorial = :idEditorial")
  Optional<Editorial> buscarEditorial(@Param("idEditorial") byte[] idEditorial);

  
}
