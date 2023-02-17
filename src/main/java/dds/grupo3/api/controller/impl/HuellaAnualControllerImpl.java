package dds.grupo3.api.controller.impl;

import dds.grupo3.api.controller.HuellaAnualController;
import dds.grupo3.api.dto.response.HuAnual;
import dds.grupo3.api.service.HuAnualService;
import dds.grupo3.api.service.OrganizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class HuellaAnualControllerImpl implements HuellaAnualController {

  @Autowired
  OrganizacionService organizacionService;
  @Autowired
  HuAnualService huAnualService;

  @Override
  public String seleccionarOrganizacion(Model model) {
    model.addAttribute("organizaciones",organizacionService.buscarOrganizaciones());
    return "calcularHUAnual";
  }

  @Override
  public String calculoHUanual(Long idOrg, Model model) {
    HuAnual huAnual= huAnualService.obtenerHuellasAnuales(idOrg);
    model.addAttribute("listadoHuellas", huAnual);
    return "calcularHUdesgloseAnio";
  }

}
