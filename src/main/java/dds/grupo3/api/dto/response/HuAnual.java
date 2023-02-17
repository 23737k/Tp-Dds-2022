package dds.grupo3.api.dto.response;

import dds.grupo3.clases.organizacion.Organizacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("huanual")
public class HuAnual {

  @Id
  private String id;
  private OrganizacionBasicaDTO organizacion;
  private List<HuellaPorAnio> huellas;
  private String holis;

  public HuAnual(OrganizacionBasicaDTO organizacion, List<HuellaPorAnio> huellas){
    this.organizacion=organizacion;
    this.huellas=huellas;
  }

}
