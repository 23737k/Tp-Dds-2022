package dds.grupo3.api.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/calculoHUanual")
public interface HuellaAnualController {

  @GetMapping("")
  public String seleccionarOrganizacion(Model model);

  @GetMapping("/huAnual")
  public String calculoHUanual(Model model);


}


