package model;

public class Superion extends Algoformer {

	int ataque = 100;
	int distancia = 2;
	int velocidad = 3;

	public Superion(int vida1, int vida2, int vida3) {
		this.nombre = "Superion";
		this.vida = vida1 + vida2 + vida3;
		this.inicializarAlgoformer(nombre, vida, ataque, distancia, velocidad, ataque, distancia, velocidad);
	}
}
