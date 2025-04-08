package tech.botworks.libreriaapibbdd.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EditorialDTO {
  private String idEditorial;
  private boolean editorialActiva;
  private String nombreEditorial;
}
