/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.algoformers;

import model.superficies.*;
import model.*;
import model.bonus.Stat;
import model.bonus.StatModifier;
/**
 *
 * @author Martin
 */
public abstract class EstadoAlgoformer {

	private Stat ataque;
	private Stat distanciaAtaque;
	private Stat velocidadDespl;
	private int distanciaDeCombinacion = 3;

	public EstadoAlgoformer(int ataque, int distanciaAtaque, int velocidadDespl) {
		this.ataque = new Stat(ataque);
		this.distanciaAtaque = new Stat(distanciaAtaque);
		this.velocidadDespl = new Stat(velocidadDespl);
	}

	public int getVelocidadDespl() {
		return this.velocidadDespl.devolverStat();
	}
	
	public int getDistanciaAtaque(){
		return this.distanciaAtaque.devolverStat();
	}
	
	public void setVelocidadDespl(int nuevaVelocidad){
		this.velocidadDespl.cambiarValorBase(nuevaVelocidad);
	}

	// SIN COMMAND
	boolean esAlcanzable(Coordenada origen, Coordenada destino, int alcance) {
		return origen.esAlcanzable(destino, alcance);

	}

	boolean esMovimientoPosible(Coordenada coordOrigen, Coordenada coordObjetivo) {
		return esAlcanzable(coordOrigen, coordObjetivo, this.velocidadDespl.devolverStat());
	}

	boolean esAtaquePosible(Coordenada coordOrigen, Coordenada coordObjetivo) {
		return esAlcanzable(coordOrigen, coordObjetivo, this.distanciaAtaque.devolverStat());
	}

	public boolean esCombinacionPosible(Coordenada coordenadaOrigen, Coordenada coordenadaAmiga) {
		return esAlcanzable(coordenadaOrigen, coordenadaAmiga, this.distanciaDeCombinacion);
	}

	public int getAtaque() {
		return this.ataque.devolverStat();
	}
	
	public void setAtaque(int nuevoAtaque){
		this.ataque.cambiarValorBase(nuevoAtaque);
	}

	public abstract int devolverPasosPara(Superficie terreno);

	public int devolverPasosPara(Casillero destino) {
		return devolverPasosPara(destino.getTerreno());
	}

        public void agregarModificadorAtaque(StatModifier modificador){
            this.ataque.agregarModificador(modificador);
        }
        
        public void agregarModificadorDistanciaAtaque(StatModifier modificador){
            this.distanciaAtaque.agregarModificador(modificador);
        }
        
        public void agregarModificadorVelocidadDesplazamiento(StatModifier modificador){
            this.velocidadDespl.agregarModificador(modificador);
        }

		public abstract String devuelveRutaImg(Algoformer a); 
}
