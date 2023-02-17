package dds.grupo3.api.service.impl;

import dds.grupo3.api.dto.response.HuAnual;
import dds.grupo3.api.dto.response.HuellaPorAnio;
import dds.grupo3.api.dto.response.OrganizacionBasicaDTO;
import dds.grupo3.api.repository.RepoHuAnual;
import dds.grupo3.api.repository.RepoOrganizacion;
import dds.grupo3.api.service.HuAnualService;
import dds.grupo3.clases.medible.Medible;
import dds.grupo3.clases.organizacion.Organizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HuAnualServiceImpl implements HuAnualService {
  @Autowired
  RepoHuAnual repoHuAnual;
  @Autowired
  RepoOrganizacion repoOrganizacion;

  @Override
  public List<HuellaPorAnio> calcularHuellasAnuales(Long idOrg) {
    List<Medible> mediciones = repoOrganizacion.findById(idOrg).get().getMediciones();
    Iterator<Medible> iterador = mediciones.iterator();
    List<HuellaPorAnio> huellasAnuales = new ArrayList<HuellaPorAnio>();     //creo el listado de HuellaPorAnio para ir agregando
    Calendar calendar = Calendar.getInstance();
    while (iterador.hasNext()) {
      Medible unMedible = iterador.next();              //obtengo la medicion
      calendar.setTime(unMedible.getFecha());           //seteo la fecha de la medicion a Calendar
      int anio= calendar.get(Calendar.YEAR);            //obtengo el año de esa medicion
      if(huellasAnuales.stream().anyMatch(huellaPorAnio->huellaPorAnio.getAnio()==anio)){   //pregunto si alguna huellaAnual ya creada tiene el año de la medicion
        HuellaPorAnio unaHuellaPorAnio= huellasAnuales.stream().filter(huellaPorAnio->huellaPorAnio.getAnio()==anio).findFirst().get(); //obtengo la huella de ese anio
        unaHuellaPorAnio.setValor(unaHuellaPorAnio.getValor()+unMedible.obtenerHuella()); //le incremento a su valor el de la huella del medible del mismo año
      }
      else{     //si no existe una HuellaPorAnio para tal año creo una
        HuellaPorAnio huellaPorAnio=new HuellaPorAnio(anio,unMedible.obtenerHuella());
        huellasAnuales.add(huellaPorAnio);
      }
    }
    return huellasAnuales;
  }

  public void actualizarListadoHuellas(){
    List<HuAnual> huanuales= repoHuAnual.findAll();
    Iterator<HuAnual> iterador = huanuales.iterator();
    while (iterador.hasNext()) {
      HuAnual huAnual= iterador.next();
      huAnual.setHuellas(calcularHuellasAnuales(huAnual.getOrganizacion().getId()));
      repoHuAnual.save(huAnual);
    }
  }

  public void cargarHuellasAnuales(){
    List<Organizacion> organizaciones= repoOrganizacion.findAll();
    Iterator<Organizacion> iterador = organizaciones.iterator();
    while (iterador.hasNext()){
      OrganizacionBasicaDTO organizacion= new OrganizacionBasicaDTO(iterador.next());
      HuAnual huAnual= new HuAnual(organizacion, calcularHuellasAnuales(organizacion.getId()));
      repoHuAnual.save(huAnual);
    }
  }

  @Override
  public HuAnual obtenerHuellasAnuales(Long idOrg) {
    return repoHuAnual.findByOrganizacionId(idOrg).get();
  }


}
