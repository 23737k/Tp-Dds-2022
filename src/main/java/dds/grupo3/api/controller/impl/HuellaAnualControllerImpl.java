package dds.grupo3.api.controller.impl;

import dds.grupo3.api.controller.HuellaAnualController;
import dds.grupo3.api.dto.response.HuAnual;
import dds.grupo3.api.dto.response.HuellaPorAnio;
import dds.grupo3.api.dto.response.TernaHuAnual;
import dds.grupo3.api.service.HuAnualService;
import dds.grupo3.api.service.OrganizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HuellaAnualControllerImpl implements HuellaAnualController {

  @Autowired
  OrganizacionService organizacionService;
  @Autowired
  HuAnualService huAnualService;

  @Override
  public String calculoHUanual(Model model) {
    List<HuAnual> huellasAnuales= huAnualService.obtenerHuellasAnuales();
    List<TernaHuAnual> ternaHuAnuales= new ArrayList<>();
    for(HuAnual huAnual: huellasAnuales){
      String razonSocial= huAnual.getOrganizacion().getRazonSocial();
      for(HuellaPorAnio huellaPorAnio: huAnual.getHuellas()){
        ternaHuAnuales.add(new TernaHuAnual(razonSocial,huellaPorAnio.getAnio(),huellaPorAnio.getValor()));
      }
    }
    model.addAttribute("listadoHuellas", ternaHuAnuales);
    return "calcularHUdesgloseAnio";
  }

}
