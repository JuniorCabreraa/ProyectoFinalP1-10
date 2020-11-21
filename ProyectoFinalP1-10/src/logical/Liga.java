package logical;

import java.util.ArrayList;


public class Liga {
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
}
