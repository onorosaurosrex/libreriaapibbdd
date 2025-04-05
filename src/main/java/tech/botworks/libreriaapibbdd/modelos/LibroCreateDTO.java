package tech.botworks.libreriaapibbdd.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import tech.botworks.libreriaapibbdd.entities.Autor;
import tech.botworks.libreriaapibbdd.entities.Editorial;

@Data
public class LibroCreateDTO {
  private Long idLibro;
  private int ejemplares;
  // private Boolean libroActivo;
  private String titulo;
  private String idAutor;
  private byte[] idEditorial;
}
