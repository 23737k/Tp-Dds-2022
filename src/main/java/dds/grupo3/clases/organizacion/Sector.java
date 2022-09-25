package dds.grupo3.clases.organizacion;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dds.grupo3.clases.miembro.Miembro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="SECTOR")
public class Sector {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
	@ManyToOne
	@JsonIgnore
  public Organizacion organizacion;
	@Column(name="NOMBRE_SECTOR")
  private String nombre;
	@ManyToMany(cascade=CascadeType.ALL)
  private List<Miembro> miembros;
  
  public String calcularHuellaMiembros() {
	  String mensajeSector = "Sector "+this.getNombre()+": \n";
	  for(Miembro unMiembro : this.getMiembros()) {
		  mensajeSector = mensajeSector + unMiembro.obtenerHU();
	  }
	  return mensajeSector;
  }
  
  public String huellaPorMiembro() {
	  float total=0;
	  for(Miembro unMiembro : this.getMiembros()) {
		  total = total + unMiembro.calcularHU();
	  }
	  String respuesta = "Huella del sector por miembro: "+(total/this.getMiembros().size());
	  return respuesta;
  }

  public void agregarMiembro(Miembro miembro) {
    this.miembros.add(miembro);
  }
}