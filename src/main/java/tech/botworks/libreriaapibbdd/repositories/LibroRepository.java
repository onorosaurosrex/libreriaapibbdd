package tech.botworks.libreriaapibbdd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.botworks.libreriaapibbdd.entities.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
  
}
