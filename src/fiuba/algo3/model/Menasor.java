package model;

public class Menasor extends Algoformer {

	int ataque= 115;
	int distancia= 2;
	int velocidad= 2;
	
	public Menasor(int vida1, int vida2, int vida3){
		this.nombre= "Menasor";
		this.vida= vida1+ vida2+ vida3;
		this.inicializarAlgoformer(nombre, vida, ataque, distancia, velocidad, ataque, distancia, velocidad);
		
	}
}