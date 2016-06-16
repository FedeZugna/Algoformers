/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.superficies.*;

/**
 *
 * @author Martin
 */
public abstract class EstadoAlgoformer {

	private int ataque;
	private int distanciaAtaque;
	private int velocidadDespl;
	private int distanciaDeCombinacion = 3;

	public EstadoAlgoformer(int ataque, int distanciaAtaque, int velocidadDespl) {
		this.ataque = ataque;
		this.distanciaAtaque = distanciaAtaque;
		this.velocidadDespl = velocidadDespl;
	}

	public int getVelocidadDespl() {
		return velocidadDespl;
	}
	
	public void setVelocidadDespl(int nuevaVelocidad){
		this.velocidadDespl = nuevaVelocidad;
	}

	// SIN COMMAND
	boolean esAlcanzable(Coordenada origen, Coordenada destino, int alcance) {
		return origen.esAlcanzable(destino, alcance);

	}

	boolean esMovimientoPosible(Coordenada coordOrigen, Coordenada coordObjetivo) {
		return esAlcanzable(coordOrigen, coordObjetivo, this.velocidadDespl);
	}

	boolean esAtaquePosible(Coordenada coordOrigen, Coordenada coordObjetivo) {
		return esAlcanzable(coordOrigen, coordObjetivo, this.distanciaAtaque);
	}

	public boolean esCombinacionPosible(Coordenada coordenadaOrigen, Coordenada coordenadaAmiga) {
		return esAlcanzable(coordenadaOrigen, coordenadaAmiga, this.distanciaDeCombinacion);
	}

	public int getAtaque() {
		return this.ataque;
	}

	public abstract int devolverPasosPara(Terreno terreno);

	public int devolverPasosPara(Casillero destino) {
		return devolverPasosPara(destino.getTerreno());
	}

}
