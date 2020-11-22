package logical;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Partido implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1925195659803900370L;
	private int noPartido;
	private Date fechaJuego;
	private Equipo local;
	private Equipo visitante;
	private ArrayList<Jugador> alineacionLocal;
	private ArrayList<Jugador> alineacionVisitante;
	private String estadio;
	private int[] entradasLocal;
	private int[] entradasVisitante;
	private int entradas;
	private int carrerasLocal;
	private int carrerasVisitante;
	private int hitsLocal;
	private int hitsVisitante;
	private int erroresLocal;
	private int erroresVisitante;
	private boolean terminado;
	
	//Constructor
	public Partido(int noPartido, Date fechaJuego, Equipo local, Equipo visitante, String estadio) {
		super();
		this.noPartido = noPartido;
		this.fechaJuego = fechaJuego;
		this.local = local;
		this.visitante = visitante;
		alineacionLocal = new ArrayList<Jugador>(9);
		alineacionVisitante =  new ArrayList<Jugador>(9);
		this.estadio = estadio;
		entradasLocal = new int[15];
		entradasVisitante = new int[15];
		entradas = 0;
		carrerasLocal = 0;
		carrerasVisitante = 0;
		hitsLocal = 0;
		hitsVisitante = 0;
		erroresLocal = 0;
		erroresVisitante = 0;
		terminado = false;
	}

	//Getters and Setters
	public int getNoPartido() {
		return noPartido;
	}

	public void setNoPartido(int noPartido) {
		this.noPartido = noPartido;
	}

	public Date getFechaJuego() {
		return fechaJuego;
	}

	public void setFechaJuego(Date fechaJuego) {
		this.fechaJuego = fechaJuego;
	}

	public Equipo getLocal() {
		return local;
	}

	public void setLocal(Equipo local) {
		this.local = local;
	}

	public Equipo getVisitante() {
		return visitante;
	}

	public void setVisitante(Equipo visitante) {
		this.visitante = visitante;
	}

	public ArrayList<Jugador> getAlineacionLocal() {
		return alineacionLocal;
	}

	public void setAlineacionLocal(ArrayList<Jugador> alineacionLocal) {
		this.alineacionLocal = alineacionLocal;
	}

	public ArrayList<Jugador> getAlineacionVisitante() {
		return alineacionVisitante;
	}

	public void setAlineacionVisitante(ArrayList<Jugador> alineacionVisitante) {
		this.alineacionVisitante = alineacionVisitante;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	public int[] getEntradasLocal() {
		return entradasLocal;
	}

	public void setEntradasLocal(int[] entradasLocal) {
		this.entradasLocal = entradasLocal;
	}

	public int[] getEntradasVisitante() {
		return entradasVisitante;
	}

	public void setEntradasVisitante(int[] entradasVisitante) {
		this.entradasVisitante = entradasVisitante;
	}

	public int getEntradas() {
		return entradas;
	}

	public void setEntradas(int entradas) {
		this.entradas = entradas;
	}

	public int getCarrerasLocal() {
		return carrerasLocal;
	}

	public void setCarrerasLocal(int carrerasLocal) {
		this.carrerasLocal = carrerasLocal;
	}

	public int getCarrerasVisitante() {
		return carrerasVisitante;
	}

	public void setCarrerasVisitante(int carrerasVisitante) {
		this.carrerasVisitante = carrerasVisitante;
	}

	public int getHitsLocal() {
		return hitsLocal;
	}

	public void setHitsLocal(int hitsLocal) {
		this.hitsLocal = hitsLocal;
	}

	public int getHitsVisitante() {
		return hitsVisitante;
	}

	public void setHitsVisitante(int hitsVisitante) {
		this.hitsVisitante = hitsVisitante;
	}

	public int getErroresLocal() {
		return erroresLocal;
	}

	public void setErroresLocal(int erroresLocal) {
		this.erroresLocal = erroresLocal;
	}

	public int getErroresVisitante() {
		return erroresVisitante;
	}

	public void setErroresVisitante(int erroresVisitante) {
		this.erroresVisitante = erroresVisitante;
	}

	public boolean isTerminado() {
		return terminado;
	}

	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}
}
