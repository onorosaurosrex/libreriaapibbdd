package tech.botworks.libreriaapibbdd.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor
@Entity
@Table (name="editoriales")
public class Editorial {
  @Id
  @Column (name="id_editorial")
  @GeneratedValue (strategy=GenerationType.UUID)
  private byte[] idEditorial;

  @Column(name="editorial_activa", columnDefinition = "BIT(1)")
  private boolean editorialActiva;

  @Column(name = "nombre_editorial", columnDefinition = "VARCHAR(255)", length = 255, nullable = false)
  private String nombreEditorial;
}
