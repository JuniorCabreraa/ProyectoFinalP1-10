package logical;

import java.util.ArrayList;
import java.util.Date;

public class Jugador {
	protected String nombre;
	protected Date nacimiento;
	protected String altura;
	protected float peso;
	protected int noCamiseta;
	protected String bat_lanz;
	protected String posicion;
	protected boolean lesionado;
	protected ArrayList<Lesion> misLesiones;
	protected int boletosBase;
	protected int ponches;
	protected int juegosJugados;
	protected int errores;
	protected Equipo equipo;
	
	//Constructor
	public Jugador(String nombre, Date nacimiento, String altura, float peso, int noCamiseta, String bat_lanz,
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
		juegosJugados = 0;
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

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
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

	public int getJuegosJugados() {
		return juegosJugados;
	}

	public void setJuegosJugados(int juegosJugados) {
		this.juegosJugados = juegosJugados;
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
	
}
