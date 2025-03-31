package tech.botworks.libreriaapibbdd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.botworks.libreriaapibbdd.entities.Editorial;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial,byte[]>  {
  
}
