package dds.grupo3.clases.services.geodds;

import dds.grupo3.clases.services.geodds.entities.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

import java.util.List;

public interface GeoddsService {
  @GET("paises")
  Call<List<Pais>> paises(@Query("offset") int offset);

  @GET("provincias")
  Call<List<Provincia>> provincias(@Query("offset") int offset);

  @GET("provincias")
  Call<List<Provincia>> provincias(@Query("offset") int offset, @Query("paisId") int paisId);

  @GET("municipios")
  Call<List<Municipio>> municipios(@Query("offset") int offset);

  @GET("municipios")
  Call<List<Municipio>> municipios(@Query("offset") int offset, @Query("provinciaId") int provinciaId);

  @GET("localidades")
  Call<List<Localidad>> localidades(@Query("offset") int offset);

  @GET("localidades")
  Call<List<Localidad>> localidades(@Query("offset") int offset, @Query("municipioId") int provinciaId);

  @GET("distancia")
  Call<Distancia> distancia(@Query("localidadOrigenId") int localidadOrigenId,
                            @Query("calleOrigen") String calleOrigen,
                            @Query("alturaOrigen") String alturaOrigen,
                            @Query("localidadDestinoId") int localidadDestinoId,
                            @Query("calleDestino") String calleDestino,
                            @Query("alturaDestino") String alturaDestino);

  //TODO: no creo que haga falta agregar POST("user")
}