package dds.grupo3.clases.otros;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("personas")
public class Persona {
  @Id
  private String id;
  private String nombre;
  private Long documento;

  public Persona(String nombre, Long documento){
    this.documento=documento;
    this.nombre=nombre;
  }
}
