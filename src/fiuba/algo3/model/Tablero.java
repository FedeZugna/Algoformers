/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;

/**
 *
 * @author Martin
 */
public class Tablero {
   
    public static final int LIMITEALTO = 20;
    public static final int LIMITELARGO = 20;
	private HashMap<Coordenada,Casillero> casilleros;
    private static Tablero instancia = new Tablero();
    
    private Tablero(){
    	
    	this.casilleros= new HashMap<Coordenada,Casillero>();
        for (int i=1; i<=Tablero.LIMITEALTO; i++) {
        	for (int j=1; j<= Tablero.LIMITELARGO; j++){
        		casilleros.put(new Coordenada(i,j), new Casillero(new TerrenoRocoso()));
        	}
        }
    }

	public void ubicarElemento(Interactuable algof1, Coordenada coord1) {
    	this.casilleros.get(coord1).ubicarElemento(algof1);
    	algof1.fueUbicadoEn ( casilleros.get(coord1) );
    }
    
    public Interactuable devolverElemento(Coordenada coord){
    	return this.casilleros.get(coord).devolverElemento();
    }

	public void cambiar(Interactuable ocupante, Casillero origen, Casillero destino) {
		
		origen.removerElemento();
		this.casilleros.put(origen.getUbicacion(), origen);
		destino.ubicarElemento(ocupante);
		this.casilleros.put(destino.getUbicacion(), destino);
	}

	public int devolverLargo() {
		return Tablero.LIMITELARGO; //A REFACTORIZAR
	}

	public int devolverAlto() {
		return Tablero.LIMITEALTO;  //A REFACTORIZAR
	}

	public static Tablero getInstancia() {
		return instancia;
	}

	public Casillero devolverCasillero(Coordenada coordenada) {
		return casilleros.get(coordenada);
	}


}
