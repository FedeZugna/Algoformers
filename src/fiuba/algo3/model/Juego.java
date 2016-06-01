package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Juego {
	
	Tablero tableroGeneral;
	public Jugador jugador1;
	public Jugador jugador2;
	
	
	public void tamanoDeMapa(int largo, int alto) {
		tableroGeneral= new Tablero (largo, alto);
	}

	public Tablero devolverTablero() {
		return tableroGeneral;
	}

	public void agregarJugador(String nombreDeEquipo) {
		if (nombreDeEquipo== "AUTOBOTS"){
			jugador1= new Jugador (tableroGeneral, nombreDeEquipo);
		}else{
			jugador2= new Jugador (tableroGeneral, nombreDeEquipo);
		}
	}

	public ArrayList<Algoformer> devolverAlgoformersVivosDe(String nombreDeEquipo) {
		if (nombreDeEquipo== "AUTOBOTS"){
			return jugador1.devolverAlgoformersVivos();
		}else{
			return jugador2.devolverAlgoformersVivos();
		}
	}

	public ArrayList<Algoformer> devolverEquipoDe(String nombreDeEquipo) {
		if (nombreDeEquipo== "AUTOBOTS"){
			return jugador1.devolverEquipo();
		}else{
			return jugador2.devolverEquipo();
		}
	}

	private void posicionar(Jugador jugador, Coordenada coord1,
			Coordenada coord2, Coordenada coord3) {
		
		ArrayList<Coordenada> coordenadas= new ArrayList<Coordenada>();
		coordenadas.add(coord1);
		coordenadas.add(coord2);
		coordenadas.add(coord3);
		int indice= 0;
		ArrayList<Algoformer> equipo= jugador.devolverEquipo();
		Iterator<Algoformer> iterador = equipo.iterator();
		while(iterador.hasNext()){
			Algoformer algoformerParaAgregar= iterador.next();
			jugador.ubicarElemento(algoformerParaAgregar, coordenadas.get(indice));
			indice ++;
		}
	}	
	
	public void posicionarAutobots() {
		Coordenada coord1= new Coordenada(1, 1);	//Seria imposible
		Coordenada coord2= new Coordenada(1, 2);	//testearlo con
		Coordenada coord3= new Coordenada(1, 3);	//un random
		this.posicionar(jugador1, coord1, coord2, coord3);
		
	}

	public Interactuable devolverElementoEnCoordenada(int i, int j) {
		Coordenada coordenadaABuscar= new Coordenada (i, j);
		return tableroGeneral.devolverElemeno (coordenadaABuscar);
	}

	public void posicionarDecepticons() {
		int i= tableroGeneral.devolverLargo();
		int j= tableroGeneral.devolverAlto();
		Coordenada coord1= new Coordenada(i, j);
		Coordenada coord2= new Coordenada(i, j-1);
		Coordenada coord3= new Coordenada(i, j-2);
		this.posicionar(jugador2, coord1, coord2, coord3);
	}
	

}
