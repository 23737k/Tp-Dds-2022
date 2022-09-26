package dds.grupo3.clases.medible;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="BATCHMEDICIONES")
public class BatchMediciones {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @OneToMany(cascade= CascadeType.ALL)
  @JoinColumn
  private List<Medible> mediciones = new ArrayList<>();
}
