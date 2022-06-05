package dds.grupo3.clases.miembro;

import dds.grupo3.clases.organizacion.Organizacion;
import dds.grupo3.clases.organizacion.Sector;
import dds.grupo3.clases.trayectos.Trayecto;

import java.util.List;

public class Miembro {
	private String nombre;
	private String apellido;
	private TipoDocEnum tipoDoc;
	private int nroDoc;
	private List<Trayecto> trayecto;
	// Constructor
	public Miembro(String nombre, String apellido, TipoDocEnum tipoDoc, int nroDoc) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDoc = tipoDoc;
		this.nroDoc = nroDoc;
	}

	public void setUnTrayecto(List<Trayecto> unTrayecto) {
		this.trayecto = unTrayecto;
	}
	public void agregarUnTrayecto (Trayecto unTrayecto){
		trayecto.add(unTrayecto);
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public TipoDocEnum getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(TipoDocEnum tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public int getNroDoc() {
		return nroDoc;
	}

	public void setNroDoc(int nroDoc) {
		this.nroDoc = nroDoc;
	}

	public void postularme(Organizacion organizacion, Sector sector){
	organizacion.nuevoPostulado(this, sector);
	}

}
