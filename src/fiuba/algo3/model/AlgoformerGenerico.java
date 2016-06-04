package model;

import java.util.ArrayList;

public class AlgoformerGenerico extends Algoformer{
	
	public AlgoformerGenerico(String nombre,int vida,ArrayList<EstadoAlgoformer> estadosPosibles){
		this.nombre=nombre;
		this.vida=vida;
		this.estados= new ListaCircularEstatica(estadosPosibles);
		this.estadoActual = this.estados.get();
		}
}

