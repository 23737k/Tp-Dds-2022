package dds.grupo3.api.service;

import dds.grupo3.api.dto.response.HuAnual;
import dds.grupo3.api.dto.response.HuellaPorAnio;

import java.util.List;

public interface HuAnualService {
   List<HuellaPorAnio> calcularHuellasAnuales(Long idOrg);
   void actualizarListadoHuellas();
   void cargarHuellasAnuales();
   List<HuAnual> obtenerHuellasAnuales();
   void modificarHuellasPorOrg(Long idOrg);
}
