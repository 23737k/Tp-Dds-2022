package dds.grupo3.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TernaHuAnual {
  private String razonSocial;
  private int anio;
  private float valor;

}
