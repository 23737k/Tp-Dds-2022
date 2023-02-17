package dds.grupo3.api.repository;

import dds.grupo3.api.dto.response.HuAnual;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface RepoHuAnual extends MongoRepository<HuAnual, Long> {
   Optional<HuAnual> findByOrganizacionId (Long id);

}
