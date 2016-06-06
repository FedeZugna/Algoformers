/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Martin
 */
public abstract class EstadoAlgoformer {
    
    private int ataque;
    private int distancia_ataque;
    private int velocidad_despl;

    

	public EstadoAlgoformer(int ataque, int distancia_ataque, int velocidad_despl) {
        this.ataque = ataque;
        this.distancia_ataque = distancia_ataque;
        this.velocidad_despl = velocidad_despl;
    }
    
	public int getVelocidad_despl() {
		return velocidad_despl;
	}
	
    //SIN COMMAND
    boolean esAlcanzable(Coordenada origen, Coordenada destino, int alcance){
    	return origen.esAlcanzable(destino,alcance);
    	
    }
    
    boolean esMovimientoPosible(Coordenada coordOrigen, Coordenada coordObjetivo) {
    	return esAlcanzable(coordOrigen, coordObjetivo, this.velocidad_despl);
    }

    boolean esAtaquePosible(Coordenada coordOrigen, Coordenada coordObjetivo) {
    	return esAlcanzable(coordOrigen, coordObjetivo, this.distancia_ataque);    
    }

	public int getAtaque() {
		return this.ataque;
	}

	public abstract int devolverPasosPara(Terreno terreno);
    
}
