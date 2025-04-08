package tech.botworks.libreriaapibbdd.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
//required to function with the respository query.
public class LibroListarActivosDTO {
  private int ejemplares;
  private String titulo;
  // private Long idLibro;
  // private Boolean libroActivo;

}
