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
@Table (name="autores")
public class Autor {
  @Id
  @Column(name = "id_autor", columnDefinition = "VARCHAR(255)", nullable = false, updatable = false)
  @GeneratedValue (strategy=GenerationType.UUID)
  private String idAutor;

  @Column(name="autor_activo", columnDefinition = "BIT(1)")
  private boolean autorActivo;

  @Column(name = "nombre_autor", columnDefinition = "VARCHAR(255)", length = 255, nullable = false)
  private String nombreAutor;

}
