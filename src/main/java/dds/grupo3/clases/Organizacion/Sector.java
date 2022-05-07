package dds.grupo3.clases.organizacion;

import java.util.List;

import dds.grupo3.clases.miembro.Miembro;

public class Sector {
	public Organizacion organizacion;
	public Organizacion getOrganizacion() {
		return organizacion;
	}

	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
	}

	private String nombre;
	private List<Miembro> miembros;

	public Sector(String nombre) {
		super();
		this.nombre = nombre;
	}

	public void agregarMiembro(Miembro miembro) {
		miembros.add(miembro);
	}

	public String getNombre() {
		return nombre;
	}

	public List<Miembro> getMiembros() {
		return miembros;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setMiembros(List<Miembro> miembros) {
		this.miembros = miembros;
	}
}