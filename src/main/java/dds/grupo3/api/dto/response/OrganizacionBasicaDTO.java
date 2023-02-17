package dds.grupo3.api.dto.response;

import dds.grupo3.clases.medible.Medible;
import dds.grupo3.clases.organizacion.Organizacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizacionBasicaDTO {
  private Long id;
  private String razonSocial;

  public OrganizacionBasicaDTO(Organizacion organizacion){
    this.id= organizacion.getId();
    this.razonSocial=organizacion.getRazonSocial();
  }
}
