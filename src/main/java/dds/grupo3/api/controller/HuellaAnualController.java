package dds.grupo3.api.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/calculoHUanual")
public interface HuellaAnualController {

  @GetMapping("")
  public String seleccionarAnio(Model model);

  @GetMapping("/huAnual")
  public String calculoHUanual(@RequestParam(value = "anio", required = true) Long anio,
                               Model model);


}


