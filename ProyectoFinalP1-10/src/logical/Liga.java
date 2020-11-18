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
		cantPartidos = 0;
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
}
