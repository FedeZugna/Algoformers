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
				// Casillero cas = new Casillero(new TerrenoRocoso());
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

		/*
		 * int numeroAleatorio= (int) (Math.random()*100+1); switch
		 * (numeroAleatorio) { case 1: case 2: case 3: case 4: case 5: case 6:
		 * case 7: case 8: case 9: case 10: return new Casillero (new
		 * TerrenoPantanoso(), new Nube()); case 11: case 12: case 13: case 14:
		 * case 15:case 16:case 17:case 18:case 19:case 20:return new Casillero
		 * (new TerrenoPantanoso(), new TormentaPsionica()); case 21: case
		 * 22:case 23:case 24:case 25:case 26:case 27:case 28:case 29:case
		 * 30:return new Casillero (new TerrenoPantanoso(), new
		 * NebulosaDeAndromeda());
		 * 
		 * case 31: case 32:case 33:case 34:case 35:case 36:case 37:case 38:case
		 * 39:case 40:return new Casillero (new TerrenoDeEspinas(), new
		 * NebulosaDeAndromeda()); case 41: case 42:case 43:case 44:case 45:case
		 * 46:case 47:case 48:case 49:case 50:return new Casillero (new
		 * TerrenoDeEspinas(), new Nube()); case 51: case 52:case 53:case
		 * 54:case 55:case 56:case 57:case 58:case 59:case 60:return new
		 * Casillero (new TerrenoDeEspinas(), new TormentaPsionica());
		 * 
		 * case 61: case 62:case 63:case 64:case 65:case 66:case 67:case 68:case
		 * 69:case 70:return new Casillero (new TerrenoRocoso(), new
		 * TormentaPsionica()); case 81: case 82:case 83:case 84:case 85:case
		 * 86:case 87:case 88:case 89:case 90:return new Casillero (new
		 * TerrenoRocoso(), new NebulosaDeAndromeda());
		 * 
		 * default:return new Casillero (new TerrenoRocoso(),new Nube()); }
		 */
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
		return Tablero.LIMITELARGO; // A REFACTORIZAR
	}

	public int devolverAlto() {
		return Tablero.LIMITEALTO; // A REFACTORIZAR
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
