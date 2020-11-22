package logical;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class Equipo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -116520969366731001L;
	private String codigo;
	private String nombre;
	private String estadio;
	private Date fundacion;
	private String ciudad;
	private String manager;
	private int partidosJugados;
	private int partidosGanados;
	private int partidosPerdidos;
	private int carreras;
	private int hits;
	private int dobles;
	private int triples;
	private int homeruns;
	private int carrerasImpulsadas;
	private int boletosBase;
	private int ponches;
	private int basesRobadas;
	private int turnosBate;
	private ArrayList<Jugador> misJugadores;
	private ArrayList<Lanzador> misLanzadores;
	private ArrayList<Jugador> alineacion;

	//Constructor
	public Equipo(String codigo, String nombre, String estadio, Date fundacion, String ciudad, String manager) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.estadio = estadio;
		this.fundacion = fundacion;
		this.ciudad = ciudad;
		this.manager = manager;
		partidosJugados = 0;
		partidosGanados = 0;
		partidosPerdidos = 0;
		carreras = 0;
		hits = 0;
		dobles = 0;
		triples = 0;
		homeruns = 0;
		carrerasImpulsadas = 0;
		boletosBase = 0;
		ponches = 0;
		basesRobadas = 0;
		turnosBate = 0;
		misJugadores = new ArrayList<Jugador>(25);
		misLanzadores = new ArrayList<Lanzador>(7);
		alineacion = new ArrayList<Jugador>(9);
	}

	//Getters and Setters
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	public Date getFundacion() {
		return fundacion;
	}

	public void setFundacion(Date fundacion) {
		this.fundacion = fundacion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public int getPartidosJugados() {
		return partidosJugados;
	}

	public void setPartidosJugados(int partidosJugados) {
		this.partidosJugados = partidosJugados;
	}

	public int getPartidosGanados() {
		return partidosGanados;
	}

	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}

	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}

	public void setPartidosPerdidos(int partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}

	public int getCarreras() {
		return carreras;
	}

	public void setCarreras(int carreras) {
		this.carreras = carreras;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getDobles() {
		return dobles;
	}

	public void setDobles(int dobles) {
		this.dobles = dobles;
	}

	public int getTriples() {
		return triples;
	}

	public void setTriples(int triples) {
		this.triples = triples;
	}

	public int getHomeruns() {
		return homeruns;
	}

	public void setHomeruns(int homeruns) {
		this.homeruns = homeruns;
	}

	public int getCarrerasImpulsadas() {
		return carrerasImpulsadas;
	}

	public void setCarrerasImpulsadas(int carrerasImpulsadas) {
		this.carrerasImpulsadas = carrerasImpulsadas;
	}

	public int getBoletosBase() {
		return boletosBase;
	}

	public void setBoletosBase(int boletosBase) {
		this.boletosBase = boletosBase;
	}

	public int getPonches() {
		return ponches;
	}

	public void setPonches(int ponches) {
		this.ponches = ponches;
	}

	public int getBasesRobadas() {
		return basesRobadas;
	}

	public void setBasesRobadas(int basesRobadas) {
		this.basesRobadas = basesRobadas;
	}

	public ArrayList<Jugador> getMisJugadores() {
		return misJugadores;
	}

	public void setMisJugadores(ArrayList<Jugador> misJugadores) {
		this.misJugadores = misJugadores;
	}

	public ArrayList<Lanzador> getMisLanzadores() {
		return misLanzadores;
	}

	public void setMisLanzadores(ArrayList<Lanzador> misLanzadores) {
		this.misLanzadores = misLanzadores;
	}

	public ArrayList<Jugador> getAlineacion() {
		return alineacion;
	}

	public void setAlineacion(ArrayList<Jugador> alineacion) {
		this.alineacion = alineacion;
	}

	public int getTurnosBate() {
		return turnosBate;
	}

	public void setTurnosBate(int turnosBate) {
		this.turnosBate = turnosBate;
	}

	//Insertar Jugador
	public void insertarJugador(Jugador jugador) {
		for (Jugador x : misJugadores) {
			if (jugador.getNoCamiseta() == x.getNoCamiseta()) {
				JOptionPane.showMessageDialog(null, "Número de Camiseta No Disponible" , null, JOptionPane.ERROR_MESSAGE);
				break;
			} else if (misJugadores.indexOf(x) == (misJugadores.size()-1) && jugador.getNoCamiseta() != x.getNoCamiseta()) {
				misJugadores.add(jugador);
			}
		}
	}

	//Eliminar Jugador
	public void eliminarJugador(Jugador jugador) {
		misJugadores.remove(jugador);
	}

	//Insertar Jugador en Alineacion
	public void insertarJugadorAlineacion(Jugador jugador) {
		if(jugador.lesionado == true) { 
			JOptionPane.showMessageDialog(null, "JUGADOR LESIONADO", null, JOptionPane.ERROR_MESSAGE);

		} else {
			alineacion.add(jugador);
		}
	}

	//Eliminar Jugador en Alineacion
	public void eliminarJugadorAlineacion(Jugador jugador) {
		alineacion.remove(jugador);
	}

	//Insertar Lanzadores en Alineacion de Lanzadores
	public void insertarLanzador(Lanzador lanzador) {
		if(lanzador.lesionado == true) { 
			JOptionPane.showMessageDialog(null, "LANZADOR LESIONADO", null, JOptionPane.ERROR_MESSAGE);

		} else {
			misLanzadores.add(lanzador);
		}
	}

	//Eliminar Lanzadores en Alineacion de Lanzadores
	public void eliminarLanzador(Lanzador lanzador) {
		misLanzadores.remove(lanzador);
	}

	//Buscar Jugador por Numero de Camiseta
	public Jugador buscarJugadorNoCamiseta(int noCamiseta) {
		Jugador player = null;
		boolean encontrado = false;
		int i = 0;

		while (!encontrado && i < misJugadores.size()) {
			if (misJugadores.get(i).getNoCamiseta() == noCamiseta) {
				player = misJugadores.get(i);
				encontrado = true;
			}
			i++;
		}
		return player;
	}

	//Buscar Jugador por Nombre
	public Jugador buscarJugadorNombre(String nombre) {
		Jugador player = null;
		boolean encontrado = false;
		int i = 0;

		while (!encontrado && i < misJugadores.size()) {
			if (misJugadores.get(i).getNombre().equalsIgnoreCase(nombre)) {
				player = misJugadores.get(i);
				encontrado = true;
			}
			i++;
		}
		return player;
	}
	
	//Cantidad de Jugadores en mi Equipo (Lanzadores, Bateadores y Total)
	public int[] cantJugadores() {
		int[] cant = new int [3];
		cant[0] = 0;
		cant[1] = 0;
		cant[2] = 0;
		for (Jugador jugador : misJugadores) {
			if (jugador instanceof Lanzador) {
				cant[0]++;
			} else if (jugador instanceof Bateador) {
				cant[1]++;
			}
		}
		cant[2] = cant[0]+cant[1];
		
		return cant;
	}
	
	//Promedio de Bateo	
	public BigDecimal promedioBateo() {
		float x = ((float)hits/turnosBate);
		BigDecimal avg = new BigDecimal(x).setScale(3, RoundingMode.HALF_UP);
		return avg;
	}
	
}
