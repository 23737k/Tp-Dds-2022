package dds.grupo3.api.repository;

import dds.grupo3.clases.miembro.Miembro;
import dds.grupo3.clases.otros.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface RepoPersona extends MongoRepository<Persona, Long> {
}
