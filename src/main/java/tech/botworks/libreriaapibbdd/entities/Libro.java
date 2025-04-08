package tech.botworks.libreriaapibbdd.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name="libros")
public class Libro {

  @Id
  @Column(name = "id_libro", columnDefinition = "BIGINT", nullable = false)
  private Long idLibro; 

  private int ejemplares;

  @Column (name="libro_activo", columnDefinition = "BIT(1)")
  private Boolean libroActivo = true;

  @Column(columnDefinition = "VARCHAR(255)", length = 255, nullable = false)
  private String titulo;

  @ManyToOne
  @JoinColumn (name= "id_autor")
  private Autor idAutor;

  @ManyToOne
  @JoinColumn(name = "id_editorial")
  private Editorial idEditorial;

}
