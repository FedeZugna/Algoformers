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
    private int largoTablero;
    private int altoTablero;
    
    public Tablero(int largo, int alto){
    	largoTablero= largo;
    	altoTablero= alto;
    	this.casilleros= new HashMap<Coordenada,Casillero>();
        for (int i=1; i<=largo; i++) {
        	for (int j=1; j<= alto ; j++){
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


}
