package logical;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class Bateador extends Jugador implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5517869422426207514L;
	private int turnosBate;
	private int carreras;
	private int hits;
	private int dobles;
	private int triples;
	private int homeruns;
	private int carrerasImpulsadas;
	private int basesRobadas;
	private int asistencias;
	private int corredoresAtrapadosRob;
	private int dobleMatanza;
	private int outsRealizados;
	private int basesRobadasPermitidas;
	private int golpeado;
	private int elevadosSacrificios;
	
	//Constructor
	public Bateador(String nombre, Date nacimiento, float altura, int peso, int noCamiseta, String bat_lanz,
			String posicion, Equipo equipo) {
		super(nombre, nacimiento, altura, peso, noCamiseta, bat_lanz, posicion, equipo);
		turnosBate = 0;
		carreras = 0;
		hits = 0;
		dobles = 0;
		triples = 0;
		homeruns = 0;
		carrerasImpulsadas = 0;
		basesRobadas = 0;
		asistencias = 0;
		corredoresAtrapadosRob = 0;
		dobleMatanza = 0;
		outsRealizados = 0;
		basesRobadasPermitidas = 0;
		golpeado = 0;
		elevadosSacrificios = 0;
	}
	
	//Getters and Setters
	public int getTurnosBate() {
		return turnosBate;
	}

	public void setTurnosBate(int turnosBate) {
		this.turnosBate = turnosBate;
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

	public int getBasesRobadas() {
		return basesRobadas;
	}

	public void setBasesRobadas(int basesRobadas) {
		this.basesRobadas = basesRobadas;
	}

	public int getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}

	public int getCorredoresAtrapadosRob() {
		return corredoresAtrapadosRob;
	}

	public void setCorredoresAtrapadosRob(int corredoresAtrapadosRob) {
		this.corredoresAtrapadosRob = corredoresAtrapadosRob;
	}

	public int getDobleMatanza() {
		return dobleMatanza;
	}

	public void setDobleMatanza(int dobleMatanza) {
		this.dobleMatanza = dobleMatanza;
	}

	public int getOutsRealizados() {
		return outsRealizados;
	}

	public void setOutsRealizados(int outsRealizados) {
		this.outsRealizados = outsRealizados;
	}

	public int getBasesRobadasPermitidas() {
		return basesRobadasPermitidas;
	}

	public void setBasesRobadasPermitidas(int basesRobadasPermitidas) {
		this.basesRobadasPermitidas = basesRobadasPermitidas;
	}

	public int getGolpeado() {
		return golpeado;
	}

	public void setGolpeado(int golpeado) {
		this.golpeado = golpeado;
	}

	public int getElevadosSacrificios() {
		return elevadosSacrificios;
	}

	public void setElevadosSacrificios(int elevadosSacrificios) {
		this.elevadosSacrificios = elevadosSacrificios;
	}
	
	//Promedio de Bateo	
	public BigDecimal promedioBateo() {
		float x = ((float)hits/turnosBate);
		BigDecimal avg = new BigDecimal(x).setScale(3, RoundingMode.HALF_UP);
		return avg;
	}
	
	//Porcentaje de Alcanzar Bases	
	public BigDecimal porcentajeAlcanceBases() {
		float x = (((float)hits+boletosBase+golpeado)/(hits+boletosBase+golpeado+elevadosSacrificios));
		BigDecimal obp = new BigDecimal(x).setScale(3, RoundingMode.HALF_UP);
		return obp;
	}
	
	//Porcentaje de Slugging (Indice de bases totales por turnos al bate)	
	public BigDecimal slugging() {
		float x = ((((float)hits)+(2*dobles)+(3*triples)+(4*homeruns))/(turnosBate));
		BigDecimal slg = new BigDecimal(x).setScale(3, RoundingMode.HALF_UP);
		return slg;
	}
	
	//Porcentaje de Alcanzar Mas Bases Por Slugging
	public BigDecimal porcentajeAlcanceBasesPorSlugging() {
		BigDecimal x = slugging().add(porcentajeAlcanceBases());
		BigDecimal ops = x.setScale(3, RoundingMode.HALF_UP);
		return ops;
	}
	
	//Poder Aislado (ISO)
	public BigDecimal poderAislado() {
		BigDecimal x = slugging().subtract(promedioBateo());
		BigDecimal iso = x.setScale(3, RoundingMode.HALF_UP);
		return iso;
	}
	
	//Porcentaje de Fildeo
	public BigDecimal porcentajeFildeo() {
		float x = (((float)outsRealizados+asistencias)/(outsRealizados+asistencias+errores));
		BigDecimal fielding = new BigDecimal(x).setScale(3, RoundingMode.HALF_UP);
		return fielding;
	}
	
	//Factor de Alcance
	public BigDecimal factorAlcance() {
		float x = (((float)outsRealizados+asistencias)/9);
		BigDecimal rf = new BigDecimal(x).setScale(2, RoundingMode.HALF_UP);
		return rf;
	}
	
}
