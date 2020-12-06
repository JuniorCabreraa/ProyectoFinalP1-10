package logical;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;


public class Liga implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2394678102697023660L;
	private ArrayList<Jugador> listaJugadores;
	private ArrayList<Equipo> listaEquipos;
	private ArrayList<Partido> listaPartidos;
	private int cantPartidos;
	private static Liga league = null;
	private ArrayList <Usuario> listaUsuarios;
	private  Usuario loginUser;
	private static boolean firsTime;
	
	//Constructor
	private Liga() {
		super();
		listaJugadores = new ArrayList<Jugador>();
		listaEquipos = new ArrayList<Equipo>();
		listaPartidos = new ArrayList<Partido>();
		listaUsuarios = new ArrayList<Usuario>();
		cantPartidos = 0;
	}
	//SINGLETON
	public static Liga getInstance() {
		if(league == null) {
			league = new Liga();
		}
		return league;
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
	
	public static Liga getLeague() {
		return league;
	}
	
	public static void setLeague(Liga league) {
		Liga.league = league;
	}
	
	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}
	
	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	public Usuario getLoginUser() {
		return loginUser;
	}
	
	public void setLoginUser(Usuario loginUser) {
		this.loginUser = loginUser;
	}
	
	public static boolean isFirsTime() {
		return firsTime;
	}
	
	public static void setFirsTime(boolean firsTime) {
		Liga.firsTime = firsTime;
	}
	
	//Insertar Usuario
	public void insertarUsuario(Usuario user) {
		listaUsuarios.add(user);
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
	
	//Eliminar Usuario
	public void eliminarUsuario(Usuario user) {
		listaUsuarios.remove(user);
	}
	
	//Eliminar Jugador
	public void eliminarJugador(Jugador jugador) {
		listaJugadores.remove(jugador);
	}

	//Eliminar Equipo
	public void eliminarEquipo(Equipo equipo) {
		listaEquipos.remove(equipo);
	}

	//Eliminar Partido
	public void eliminarPartido(Partido partido) {
		listaPartidos.remove(partido);
		cantPartidos--;
	}

	//Buscar Jugador Por Nombre
	public Jugador buscarJugadorPorNombre(String name) {
		Jugador aux = null;
		boolean found = false;
		int x = 0;
		while (!found && x < listaJugadores.size()) {
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
	
	//Buscar Partido por Numero
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
	
	//Buscar Partidos por Uno de los Equipos 
	public ArrayList<Partido> buscarPartidoPorEquipo(Equipo equipo) {
		ArrayList<Partido> partidos = new ArrayList<>();
		
		for (Partido game : listaPartidos) {
			if (game.getLocal().equals(equipo) || game.getVisitante().equals(equipo)) {
				partidos.add(game);
			}
		}
		return partidos;
	}
	
	//Verificar Usuario
	public boolean confirmLogin(String usuario, String password) {
		boolean login = false;
		
		for (Usuario user : listaUsuarios) {
			if(user.getUsername().equals(usuario) && user.getPassword().equals(password)){
				loginUser = user;
				login = true;
			}
		}
		return login;
	}
	
	//Guardar Datos
	public void saveData() {
		FileOutputStream data;
		ObjectOutputStream dataObj;
		try {
			data = new FileOutputStream("Data.dat");
			dataObj = new ObjectOutputStream(data);
			dataObj.writeObject(league);
			data.close();
			dataObj.close();
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e, "File Not Found", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (IOException a) {
			JOptionPane.showMessageDialog(null, a, "I/O", JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
	
	//Cargar Datos
	public void loadData() {
		FileInputStream data;
		ObjectInputStream dataObj;
		
		try {
			data = new FileInputStream("Data.dat");
			dataObj = new ObjectInputStream(data);
			Liga db = (Liga) dataObj.readObject();
			Liga.setLeague(db);
			data.close();
			dataObj.close();
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e, "File Not Found", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (IOException a) {
			JOptionPane.showMessageDialog(null, a, "I/O", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (ClassNotFoundException z) {
			JOptionPane.showMessageDialog(null, z, "Class Not Found", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//Reproducir Sonido
	public void reproducirSonido(String nombreSonido){
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch(UnsupportedAudioFileException ex) {
			System.out.println("Error al reproducir el sonido.");
			
		} catch (IOException e) {
			System.out.println("Error al reproducir el sonido.2");
		} catch (LineUnavailableException e) {
			System.out.println("Error al reproducir el sonido.3");
		}
	}

	//Grafico
	public int[] cantidadLesionesCat() {
		int[]aux = new int [6];
		int cabeza = 0, hombro = 0, brazo = 0, espalda = 0, pierna = 0, pie = 0;
		
		for (Jugador player : Liga.getInstance().getListaJugadores()) {
			for (Lesion les : player.getMisLesiones()) {
				if (les.isActiva()) {
					if (les.getCategoria().equalsIgnoreCase("Cabeza")) {
						cabeza++;
					}
					if (les.getCategoria().equalsIgnoreCase("Hombro")) {
						hombro++;
					}
					if (les.getCategoria().equalsIgnoreCase("Brazo")) {
						brazo++;
					}
					if (les.getCategoria().equalsIgnoreCase("Espalda")) {
						espalda++;
					}
					if (les.getCategoria().equalsIgnoreCase("Pierna")) {
						pierna++;
					}
					if (les.getCategoria().equalsIgnoreCase("Pie")) {
						pie++;
					}
				}
			}
		}
		
		aux[0] = cabeza;
		aux[1] = hombro;
		aux[2] = brazo;
		aux[3] = espalda;
		aux[4] = pierna;
		aux[5] = pie;
		
		return aux;
	}
}
