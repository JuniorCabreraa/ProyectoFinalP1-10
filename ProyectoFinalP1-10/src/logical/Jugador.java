package logical;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class Jugador implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7546744486660725131L;
	protected String nombre;
	protected Date nacimiento;
	protected int altura;
	protected int peso;
	protected int noCamiseta;
	protected String bat_lanz;
	protected String posicion;
	protected boolean lesionado;
	protected ArrayList<Lesion> misLesiones;
	protected int boletosBase;
	protected int ponches;
	protected int errores;
	protected Equipo equipo;
	
	//Constructor
	public Jugador(String nombre, Date nacimiento, int altura, int peso, int noCamiseta, String bat_lanz,
			String posicion, Equipo equipo) {
		super();
		this.nombre = nombre;
		this.nacimiento = nacimiento;
		this.altura = altura;
		this.peso = peso;
		this.noCamiseta = noCamiseta;
		this.bat_lanz = bat_lanz;
		this.posicion = posicion;
		lesionado = false;
		misLesiones = new ArrayList<Lesion>();
		boletosBase = 0;
		ponches = 0;
		errores = 0;
		this.equipo = equipo;
	}
	
	//Getters and Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getNoCamiseta() {
		return noCamiseta;
	}

	public void setNoCamiseta(int noCamiseta) {
		this.noCamiseta = noCamiseta;
	}

	public String getBat_lanz() {
		return bat_lanz;
	}

	public void setBat_lanz(String bat_lanz) {
		this.bat_lanz = bat_lanz;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public boolean isLesionado() {
		return lesionado;
	}

	public void setLesionado(boolean lesionado) {
		this.lesionado = lesionado;
	}

	public ArrayList<Lesion> getMisLesiones() {
		return misLesiones;
	}

	public void setMisLesiones(ArrayList<Lesion> misLesiones) {
		this.misLesiones = misLesiones;
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

	public int getErrores() {
		return errores;
	}

	public void setErrores(int errores) {
		this.errores = errores;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	//Insertar Lesion (Tambien Elimina al Jugador de la Alineacion)
	public boolean insertarLesion(Lesion lesion) {
		boolean aux = false;
		lesion.getJugador().verificarLesion();
		if (lesion.getJugador().isLesionado() == false) {
			misLesiones.add(lesion);
			lesionado = true;
			aux = true;
			if (lesion.getJugador() instanceof Jugador) {
				for (Jugador player : equipo.getAlineacion()) {
					if (lesion.getJugador().equals(player)) {
						equipo.eliminarJugadorAlineacion(lesion.getJugador());
						JOptionPane.showMessageDialog(null, "Jugador Eliminado de Alineación", null, JOptionPane.INFORMATION_MESSAGE);
						return aux;
					}
				}
			}
			if (lesion.getJugador() instanceof Lanzador) {
				for (Lanzador player : equipo.getMisLanzadores()) {
					if (lesion.getJugador().equals(player)) {
						equipo.eliminarLanzador((Lanzador) lesion.getJugador());
						JOptionPane.showMessageDialog(null, "Lanzador Eliminado de Alineación", null, JOptionPane.INFORMATION_MESSAGE);
						return aux;
					}
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Ya está lesionado", null, JOptionPane.INFORMATION_MESSAGE);
			return aux;
		}
		
		return aux;
	}
	
	//Verificar Lesion
	public void verificarLesion() {
		Date present = new Date();
		
		for (Lesion lesion : misLesiones) {
			if (present.after(lesion.getFinaliza()) == true) {
				lesion.setActiva(false);
				lesionado = false;
			} 
		}
	}	

}
