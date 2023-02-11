package dds.grupo3.api.service.impl;

import dds.grupo3.api.repository.RepoPersona;
import dds.grupo3.api.service.PersonaService;
import dds.grupo3.clases.otros.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService {
  @Autowired
  RepoPersona repo;

  @Override
  public void guardarPersona(Persona persona) {
    repo.save(persona);
  }
}
