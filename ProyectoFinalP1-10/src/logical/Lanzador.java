package logical;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class Lanzador extends Jugador implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 10365944555153231L;
	private int hitsPermitidos;
	private int carrerasPermitidas;
	private int carrerasLimpiasPermitidas;
	private int carrerasSuciasPermitidas;
	private int homerunsPermitidos;
	private int bateadoresGolpeados;
	private int juegosGanados;
	private int juegosPerdidos;
	private int juegosSalvados;
	private int juegosCompletos;
	private int juegosBlanqueados;
	private int juegosLanzados;
	private int aperturas;
	private int outs;
	
	//Constructor
	public Lanzador(String nombre, Date nacimiento, String altura, float peso, int noCamiseta, String bat_lanz,
			String posicion, Equipo equipo) {
		super(nombre, nacimiento, altura, peso, noCamiseta, bat_lanz, posicion, equipo);
		hitsPermitidos = 0;
		carrerasPermitidas = 0;
		carrerasLimpiasPermitidas = 0;
		carrerasSuciasPermitidas = 0;
		homerunsPermitidos = 0;
		bateadoresGolpeados = 0;
		juegosGanados = 0;
		juegosPerdidos = 0;
		juegosSalvados = 0;
		juegosCompletos = 0;
		juegosBlanqueados = 0;
		juegosLanzados = 0;
		aperturas = 0;
		outs = 0;
	}
	
	//Getters and Setters
	public int getHitsPermitidos() {
		return hitsPermitidos;
	}

	public void setHitsPermitidos(int hitsPermitidos) {
		this.hitsPermitidos = hitsPermitidos;
	}

	public int getCarrerasPermitidas() {
		return carrerasPermitidas;
	}

	public void setCarrerasPermitidas(int carrerasPermitidas) {
		this.carrerasPermitidas = carrerasPermitidas;
	}

	public int getCarrerasLimpiasPermitidas() {
		return carrerasLimpiasPermitidas;
	}

	public void setCarrerasLimpiasPermitidas(int carrerasLimpiasPermitidas) {
		this.carrerasLimpiasPermitidas = carrerasLimpiasPermitidas;
	}

	public int getCarrerasSuciasPermitidas() {
		return carrerasSuciasPermitidas;
	}

	public void setCarrerasSuciasPermitidas(int carrerasSuciasPermitidas) {
		this.carrerasSuciasPermitidas = carrerasSuciasPermitidas;
	}

	public int getHomerunsPermitidos() {
		return homerunsPermitidos;
	}

	public void setHomerunsPermitidos(int homerunsPermitidos) {
		this.homerunsPermitidos = homerunsPermitidos;
	}

	public int getBateadoresGolpeados() {
		return bateadoresGolpeados;
	}

	public void setBateadoresGolpeados(int bateadoresGolpeados) {
		this.bateadoresGolpeados = bateadoresGolpeados;
	}

	public int getJuegosGanados() {
		return juegosGanados;
	}

	public void setJuegosGanados(int juegosGanados) {
		this.juegosGanados = juegosGanados;
	}

	public int getJuegosPerdidos() {
		return juegosPerdidos;
	}

	public void setJuegosPerdidos(int juegosPerdidos) {
		this.juegosPerdidos = juegosPerdidos;
	}

	public int getJuegosSalvados() {
		return juegosSalvados;
	}

	public void setJuegosSalvados(int juegosSalvados) {
		this.juegosSalvados = juegosSalvados;
	}

	public int getJuegosCompletos() {
		return juegosCompletos;
	}

	public void setJuegosCompletos(int juegosCompletos) {
		this.juegosCompletos = juegosCompletos;
	}

	public int getJuegosBlanqueados() {
		return juegosBlanqueados;
	}

	public void setJuegosBlanqueados(int juegosBlanqueados) {
		this.juegosBlanqueados = juegosBlanqueados;
	}

	public int getJuegosLanzados() {
		return juegosLanzados;
	}

	public void setJuegosLanzados(int juegosLanzados) {
		this.juegosLanzados = juegosLanzados;
	}

	public int getAperturas() {
		return aperturas;
	}

	public void setAperturas(int aperturas) {
		this.aperturas = aperturas;
	}
	
	public int getOuts() {
		return outs;
	}

	public void setOuts(int outs) {
		this.outs = outs;
	}
	
	//Entradas lanzadas
	public float entradasLanzadas() {
		float x = (float)outs/3;
		BigDecimal entradas = new BigDecimal(x).setScale(1, RoundingMode.HALF_UP);
		return entradas.floatValue();
	}
	
	//Porcentaje de carreras limpias
	public BigDecimal porcentajeCarrerasLimpias() {
		float x = ((float)carrerasLimpiasPermitidas*9)/entradasLanzadas();
		BigDecimal porcentaje = new BigDecimal(x).setScale(2, RoundingMode.HALF_UP);
		return porcentaje;
	}
	
	//Boletos y hits por entradas lanzadas
	public BigDecimal boletosYhits() {
		float x = ((float)boletosBase+hitsPermitidos)/entradasLanzadas();
		BigDecimal whip = new BigDecimal(x).setScale(2, RoundingMode.HALF_UP);
		return whip;
	}
	
}
