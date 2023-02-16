package dds.grupo3.api.controller.impl;

import dds.grupo3.api.controller.HuellaAnualController;
import dds.grupo3.api.service.OrganizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class HuellaAnualControllerImpl implements HuellaAnualController {

  @Autowired
  OrganizacionService organizacionService;

  @Override
  public String seleccionarAnio(Model model) {
    return "calcularHUAnual";
  }

  @Override
  public String calculoHUanual(Long anio, Model model) {
    //model.addAttribute("organizacions", organizacionService.buscarOrganizaciones().stream().map(org -> (org.getRazonSocial())).collect(Collectors.toList()));
    model.addAttribute("organizaciones", organizacionService.buscarOrganizaciones());
    return "calcularHUdesgloseAnio";
  }

}
