package logical;

import java.io.Serializable;
import java.util.ArrayList;


public class Liga implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2394678102697023660L;
	private ArrayList<Jugador> listaJugadores;
	private ArrayList<Equipo> listaEquipos;
	private ArrayList<Partido> listaPartidos;
	private int cantPartidos;
	
	//Constructor
	public Liga() {
		super();
		listaJugadores = new ArrayList<Jugador>();
		listaEquipos = new ArrayList<Equipo>();
		listaPartidos = new ArrayList<Partido>();
		cantPartidos = 1;
	}
	
	//Getters and Setters
	public ArrayList<Jugador> getListaJugadores() {
		return listaJugadores;
	}

	public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}

	public ArrayList<Equipo> getListaEquipos() {
		return listaEquipos;
	}

	public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
		this.listaEquipos = listaEquipos;
	}

	public ArrayList<Partido> getListaPartidos() {
		return listaPartidos;
	}

	public void setListaPartidos(ArrayList<Partido> listaPartidos) {
		this.listaPartidos = listaPartidos;
	}

	public int getCantPartidos() {
		return cantPartidos;
	}

	public void setCantPartidos(int cantPartidos) {
		this.cantPartidos = cantPartidos;
	}
	
	//Insertar Jugador
	public void insertarJugador(Jugador jugador) {
		listaJugadores.add(jugador);
	}
	
	//Insertar Equipo
	public void insertarEquipo(Equipo equipo) {
		listaEquipos.add(equipo);
	}
	
	//Insertar Partido
	public void insertarPartido(Partido partido) {
		listaPartidos.add(partido);
		cantPartidos++;
	}

	//Buscar Jugador Por Nombre
	public Jugador buscarJugadorPorNombre(String name) {
		Jugador aux = null;
		boolean found = false;
		int x = 0;
		while (!found && x<listaJugadores.size()) {
			if (listaJugadores.get(x).getNombre().equalsIgnoreCase(name)) {
				aux = listaJugadores.get(x);
				found = true;
			}
			x++;
		}
		return aux;
	}
	
	//Buscar Equipo por Nombre
	public Equipo buscarEquipoPorNombre(String name) {
		Equipo equipoEncontrado = null;
		for (Equipo team : listaEquipos) {
			if(team.getNombre().equalsIgnoreCase(name)) {
				equipoEncontrado = team; 
			}
		}
		return equipoEncontrado;
	}
	
	//Buscar Partidos por Numero
	public Partido buscarPartidoPorNumero(int numero) {
		Partido game = null;
		boolean encontrado = false;
		int i = 0;
		
		while (!encontrado && i <listaPartidos.size()) {
			if (listaPartidos.get(i).getNoPartido() == numero) {
				game = listaPartidos.get(i);
				encontrado = true;
			}
			i++;
		}
		return game;
	}
	
	//Eliminar jugador
	public void elimiarJugador(String nombre) {

		int i = 0;
		boolean encontrado = false;
		
		while (i<listaJugadores.size() && !encontrado) {
		
			if(listaJugadores.get(i).getNombre().equalsIgnoreCase(nombre)){
				listaJugadores.remove(listaJugadores.get(i));
				encontrado = true;
			}else{
				i++;
			}
		}
		
	}
	
	//Eliminar equipo
	public void elimiarEquipo(String nombre) {

		int i = 0;
		boolean encontrado = false;
		
		while (i<listaEquipos.size() && !encontrado) {
		
			if(listaEquipos.get(i).getNombre().equalsIgnoreCase(nombre)){
				listaEquipos.remove(listaEquipos.get(i));
				encontrado = true;
			}else{
				i++;
			}
		}
		
	}
	
	//Eliminar partido
	public void elimiarPartido(int noPartido) {

		int i = 0;
		boolean encontrado = false;
		
		while (i<listaPartidos.size() && !encontrado) {
		
			if(listaPartidos.get(i).getNoPartido() == noPartido){
				listaPartidos.remove(listaPartidos.get(i));
				encontrado = true;
			}else{
				i++;
			}
		}
		
	}
	
	//Buscar partido por uno de los equipos 
	public int[] BuscarPartidoPorUnEquipo1(Equipo codigo) {
		int[] partido = new int[1];
		boolean encontrado = false;
		int i = 0;
		
		while (!encontrado && i <listaPartidos.size()) {
			if (listaPartidos.get(i).getVisitante() == codigo || listaPartidos.get(i).getLocal() == codigo) {
				encontrado = true;
				partido[0]++;
				
			}
			i++;
		}
		return partido;
	}
	



}
