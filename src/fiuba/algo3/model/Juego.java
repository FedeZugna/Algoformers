package model;

import model.excepciones.CasilleroOcupadoException;
import model.excepciones.NombreDeEquipoNoExisteException;
import java.util.ArrayList;
import java.util.HashMap;

import model.algoformers.*;
import model.bonus.Bonus;
import model.bonus.BurbujaInmaculada;
import model.bonus.DobleCanion;
import model.bonus.Flash;

import java.util.Iterator;

public class Juego {

	Tablero tableroGeneral = Tablero.getInstancia();
	public Jugador jugador1;
	public Jugador jugador2;
	public Interactuable chispa = new Chispa();
	private ArrayList<Bonus> listaDeBonus = new ArrayList<>();
	private int jugadas;
	public Jugador[] turnos = new Jugador[2];
	private HashMap<Jugador, ArrayList<Notificable>> aNotificar;
	private Jugador ganador;

	public Juego() {

		this.llenarListaDeBonus();
		this.tableroGeneral = Tablero.getInstancia();
		this.inicializarTablero();
		jugadas = 0;
		turnos[0] = this.jugador1;
		turnos[1] = this.jugador2;
		this.aNotificar = new HashMap<>();
		this.aNotificar.put(turnos[0], new ArrayList<>());
		this.aNotificar.put(turnos[1], new ArrayList<>());
		this.ganador = null;
	}

	private void llenarListaDeBonus() {
		this.listaDeBonus.add(new DobleCanion());
		this.listaDeBonus.add(new BurbujaInmaculada());
		this.listaDeBonus.add(new Flash());
	}

	public void posicionarChispaEnElMedio() {
		int largo = tableroGeneral.devolverLargo();
		int alto = tableroGeneral.devolverAlto();

		Coordenada coordenadaMedio = new Coordenada(largo / 2, alto / 2);
		tableroGeneral.ubicarElemento(chispa, coordenadaMedio);
	}

	public Tablero devolverTablero() {
		return tableroGeneral;
	}

	public void agregarJugador(String nombreDeEquipo) throws NombreDeEquipoNoExisteException {
		try {
			if (nombreDeEquipo == "AUTOBOTS") {
				jugador1 = new Jugador(tableroGeneral, "AUTOBOTS");
			} else {
				jugador2 = new Jugador(tableroGeneral, "DECEPTICONS");
			}
		} catch (NombreDeEquipoNoExisteException e) {

		}
	}

	public ArrayList<Algoformer> devolverAlgoformersVivosDeJugador1() {
		return devolverAlgoformersVivosDe(this.jugador1.devolverNombreEquipo());
	}

	public ArrayList<Algoformer> devolverAlgoformersVivosDeJugador2() {
		return devolverAlgoformersVivosDe(this.jugador2.devolverNombreEquipo());
	}

	public ArrayList<Algoformer> devolverAlgoformersVivosDe(String nombreDeEquipo) {
		if (nombreDeEquipo == "AUTOBOTS") {
			return jugador1.devolverAlgoformersVivos();
		} else {
			return jugador2.devolverAlgoformersVivos();
		}
	}

	public ArrayList<Algoformer> devolverEquipoDe(String nombreDeEquipo) {
		if (nombreDeEquipo == "AUTOBOTS") {
			return jugador1.devolverEquipo();
		} else {
			return jugador2.devolverEquipo();
		}
	}

	public void posicionar(Jugador jugador, Coordenada coord1, Coordenada coord2, Coordenada coord3) {

		ArrayList<Coordenada> coordenadas = new ArrayList<Coordenada>();
		coordenadas.add(coord1);
		coordenadas.add(coord2);
		coordenadas.add(coord3);
		int indice = 0;
		ArrayList<Algoformer> equipo = jugador.devolverEquipo();
		Iterator<Algoformer> iterador = equipo.iterator();
		while (iterador.hasNext()) {
			Algoformer algoformerParaAgregar = iterador.next();
			jugador.ubicarElemento(algoformerParaAgregar, coordenadas.get(indice));
			indice++;
		}
	}

	public void posicionarAutobots() {
		Coordenada coord1 = new Coordenada(1, 1); // Seria imposible
		Coordenada coord2 = new Coordenada(1, 2); // testearlo con
		Coordenada coord3 = new Coordenada(1, 3); // un random
		this.posicionar(jugador1, coord1, coord2, coord3);

	}

	public Interactuable devolverElementoEnCoordenada(int i, int j) {
		Coordenada coordenadaABuscar = new Coordenada(i, j);
		return tableroGeneral.devolverElemento(coordenadaABuscar);
	}

	public void posicionarDecepticons() {
		int i = Tablero.LIMITELARGO - 1;
		int j = Tablero.LIMITEALTO - 1;
		Coordenada coord1 = new Coordenada(i, j); // Seria imposible
		Coordenada coord2 = new Coordenada(i, j - 1); // testearlo con
		Coordenada coord3 = new Coordenada(i, j - 2); // un random
		this.posicionar(jugador2, coord1, coord2, coord3);
	}

	private void inicializarTablero() {
		Tablero.getInstancia().definirJuego(this);
		this.agregarJugador("AUTOBOTS");
		this.posicionarAutobots();
		this.agregarJugador("DECEPTICONS");
		this.posicionarDecepticons();
		this.posicionarChispaEnElMedio();
		this.ubicarBonus();
	}

	private void ubicarBonus() {
		Iterator<Bonus> iterador = listaDeBonus.iterator();
		while (iterador.hasNext()) {
			Bonus bonusParaAgregar = iterador.next();
			this.ubicarRandom(bonusParaAgregar);
		}
	}

	private void ubicarRandom(Bonus bonus) {
		int posicionX = (int) (Math.random() * 15 + 1);
		int posicionY = (int) (Math.random() * 10 + 1);
		Coordenada coordenada = new Coordenada(posicionX, posicionY);
		try {
			tableroGeneral.ubicarElemento(bonus, coordenada);
		} catch (CasilleroOcupadoException e) {
			ubicarRandom(bonus);
		}
	}

	public Jugador obtenerJugadorActual() {
		return turnos[jugadas % 2];
	}

	public Jugador obtenerJugadorEnemigo() {
		return turnos[(jugadas + 1) % 2];
	}

	public Jugador pasarTurno() {
		if (this.devolverAlgoformersVivosDeJugador1().isEmpty()) {
			this.ganar(jugador2);
		}
		if (this.devolverAlgoformersVivosDeJugador2().isEmpty()) {
			this.ganar(jugador1);
		}
		this.notificarJugadorActual();
		this.jugadas++;
		return turnos[jugadas % 2];
	}

	private void notificarJugadorActual() {
		Jugador actual = this.obtenerJugadorActual();
		for (Notificable n : this.aNotificar.get(actual)) {
			n.notificar();
		}
	}

	public void agregarNotificable(Notificable n) {
		Jugador actual = this.obtenerJugadorActual();
		this.aNotificar.get(actual).add(n);

	}

	public void ganar(Jugador j) {
		this.ganador = j;
	}

	public Jugador devolverGanador() {
		return this.ganador;
	}

	public void chispaFueCapturada(Algoformer algoformer) {
		this.ganar(this.devolverDuenioDe(algoformer));
	}

	private Jugador devolverDuenioDe(Algoformer algoformer) {
		for (Algoformer a : this.devolverAlgoformersVivosDeJugador1()) {
			if (a.getNombre().equals(algoformer.getNombre())) {
				return this.jugador1;
			}
		}
		return this.jugador2;
	}

	public Chispa devolverChispa() {
		return (Chispa) this.chispa;
	}

	public ArrayList<Bonus> devolverListaDeBonus() {
		return this.listaDeBonus;
	}
}
