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
   
    private HashMap<Coordenada,Casillero> casilleros;
    private int largoTablero = 20;
    private int altoTablero= 20;
    private static Tablero instancia = new Tablero();
    
    private Tablero(){
    	
    	this.casilleros= new HashMap<Coordenada,Casillero>();
        for (int i=1; i<=largoTablero; i++) {
        	for (int j=1; j<= altoTablero ; j++){
        		casilleros.put(new Coordenada(i,j), new Casillero());
        	}
        }
//        this.posicionarChispaEnElMedio();
    }

	public void ubicarElemento(Interactuable algof1, Coordenada coord1) {
    	this.casilleros.get(coord1).ubicarElemento(algof1);
    }
    
    public Interactuable devolverElemeno(Coordenada coord){
    	return this.casilleros.get(coord).devolverElemento();
    }

	public void cambiar(Interactuable ocupante, Coordenada origen, Coordenada destino) {
		Casillero casillero = this.casilleros.get(origen);
		//casillero.removerElemento();
		Casillero casillero2 = new Casillero();
		this.casilleros.put(origen, casillero2);
		casillero = this.casilleros.get(destino);
		casillero.ubicarElemento(ocupante);
		this.casilleros.put(destino, casillero);
		
		
	}

	public int devolverLargo() {
		return largoTablero;
	}

	public int devolverAlto() {
		return altoTablero;
	}

	public static Tablero getInstancia() {
		return instancia;
	}


}
