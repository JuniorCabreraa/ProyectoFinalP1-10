package logical;

import java.util.Date;

public class Bateador extends Jugador {
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
	public Bateador(String nombre, Date nacimiento, String altura, float peso, int noCamiseta, String bat_lanz,
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
	public float promedioBateo() {
		float aux = .000f;
		aux = (hits/turnosBate);
		return aux;
	}
	
	//Porcentaje de Alcanzar Bases	
	public float porcentajeAlcanceBases() {
		float aux = .000f;
		aux = ((hits+boletosBase+golpeado)/(hits+boletosBase+golpeado+elevadosSacrificios));
		return aux;
	}
	
	//Porcentaje de Slugging (Indice de bases totales por turnos al bate)	
	public float slugging() {
		float aux = .000f;
		aux = (((hits)+(2*dobles)+(3*triples)+(4*homeruns))/(turnosBate));
		return aux;
	}
	
	//Porcentaje de Alcanzar Mas Bases Por Slugging
	public float porcentajeAlcanceBasesPorSlugging() {
		float aux = .000f;
		aux = slugging()+porcentajeAlcanceBases();
		return aux;
	}
	
}
