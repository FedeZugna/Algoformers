package model;

import java.util.ArrayList;
import java.util.Iterator;

public class AlgoformerGenerico extends Algoformer{
	
	public AlgoformerGenerico(String nombre,int vida,ArrayList<EstadoAlgoFormer> estadosPosibles){
		this.nombre=nombre;
		this.vida=vida;
		this.estados= new ListaCircular();
		Iterator<EstadoAlgoFormer> iterador = estadosPosibles.iterator();
		while (iterador.hasNext()) {
			this.estados.add(iterador.next());
		}
	}
}
