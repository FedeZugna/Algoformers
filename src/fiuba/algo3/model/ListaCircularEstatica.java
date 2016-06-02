/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Martin
 */
public class ListaCircularEstatica {
    private final List<EstadoAlgoFormer> lista;
    private Iterator<EstadoAlgoFormer> iterador;
    
    public ListaCircularEstatica(ArrayList<EstadoAlgoFormer> estadosPosibles){
        this.lista = estadosPosibles;
        this.iterador = this.lista.listIterator();
    }
    
    public EstadoAlgoFormer get(){
       if (!this.iterador.hasNext()){
           this.iterador = this.lista.listIterator();
       }
       return this.iterador.next();
    }

	public boolean isEmpty() {
		return lista.isEmpty();
	}

}
