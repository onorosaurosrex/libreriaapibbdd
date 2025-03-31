package tech.botworks.libreriaapibbdd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.botworks.libreriaapibbdd.entities.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, String> {

}
