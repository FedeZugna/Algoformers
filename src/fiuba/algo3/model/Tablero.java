/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import model.algoformers.Algoformer;

import model.superficies.*;

/**
 *
 * @author Martin
 */
public class Tablero {

	public static final int LIMITEALTO = 10;
	public static final int LIMITELARGO = 15;
	private HashMap<Coordenada, Casillero> casilleros;
	private Juego JuegoActual;
	private static Tablero instancia = new Tablero();

	private Tablero() {

		this.casilleros = new HashMap<Coordenada, Casillero>();
		for (int i = 1; i <= Tablero.LIMITEALTO; i++) {
			for (int j = 1; j <= Tablero.LIMITELARGO; j++) {
				Casillero cas = this.sortearTerreno();
				cas.setUbicacion(new Coordenada(j, i));
				casilleros.put(cas.getUbicacion(), cas);
			}
		}
	}

	private Casillero sortearTerreno() {

		int numeroAleatorio = (int) (Math.random() * 25 + 1);
		Casillero casillero = new Casillero(new TerrenoRocoso(), new Nube());
		switch (numeroAleatorio) {
		case 1:
			casillero.setEspacioAereo(new NebulosaDeAndromeda());
			break;
		case 2:
			casillero.setEspacioAereo(new TormentaPsionica());
			break;
		case 3:
			casillero.setTerreno(new TerrenoPantanoso());
			casillero.setEspacioAereo(new Nube());
			break;
		case 4:
			casillero.setTerreno(new TerrenoPantanoso());
			casillero.setEspacioAereo(new NebulosaDeAndromeda());
			break;
		case 5:
			casillero.setTerreno(new TerrenoPantanoso());
			casillero.setEspacioAereo(new TormentaPsionica());
			break;
		case 6:
			casillero.setTerreno(new TerrenoDeEspinas());
			casillero.setEspacioAereo(new Nube());
			break;
		case 7:
			casillero.setTerreno(new TerrenoDeEspinas());
			casillero.setEspacioAereo(new NebulosaDeAndromeda());
			break;
		case 8:
			casillero.setTerreno(new TerrenoDeEspinas());
			casillero.setEspacioAereo(new TormentaPsionica());
			break;
		}
		return casillero;
	}

	public void ubicarElemento(Interactuable algof1, Coordenada coord1) {
		this.casilleros.get(coord1).ubicarElemento(algof1);
	}

	public Interactuable devolverElemento(Coordenada coord) {
		return this.casilleros.get(coord).devolverElemento();
	}

	public void cambiar(Interactuable ocupante, Casillero origen, Casillero destino) {

		origen.removerElemento();
		this.casilleros.put(origen.getUbicacion(), origen);
		destino.ubicarElemento(ocupante);
		this.casilleros.put(destino.getUbicacion(), destino);
	}

	public int devolverLargo() {
		return Tablero.LIMITELARGO; // a ref
	}

	public int devolverAlto() {
		return Tablero.LIMITEALTO; // a ref
	}

	public static Tablero getInstancia() {
		return instancia;
	}

	public Casillero devolverCasillero(Coordenada coordenada) {
		return casilleros.get(coordenada);
	}

	// este metodo lo hice para implementar el tearDown en las pruebas, me
	// parece espantoso
	public void reiniciarTablero() {
		instancia = new Tablero();
	}

	public void agregarNotificable(Notificable n) {
		this.JuegoActual.agregarNotificable(n);
	}

	public void definirJuego(Juego juego) {
		this.JuegoActual = juego;
	}

    void chispaFueCapturada(Algoformer algoformer) {
        this.JuegoActual.chispaFueCapturada(algoformer);
    }
}
