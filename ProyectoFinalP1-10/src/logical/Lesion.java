package logical;

import java.io.Serializable;
import java.util.Date;

public class Lesion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5172629896362644834L;
	private Jugador jugador;
	private Equipo equipo;
	private String categoria;
	private String diagnostico;
	private Date inicio;
	private Date finaliza;
	private boolean activa;
	
	//Constructor
	public Lesion(Jugador jugador, Equipo equipo, String categoria, String diagnostico, Date finaliza) {
		super();
		this.jugador = jugador;
		this.equipo = equipo;
		this.categoria = categoria;
		this.diagnostico = diagnostico;
		inicio = new Date();
		this.finaliza = finaliza;
		activa = true;
	}
	
	//Getters and Setters
	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFinaliza() {
		return finaliza;
	}

	public void setFinaliza(Date finaliza) {
		this.finaliza = finaliza;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}
	
}
