package model;

public class Ratchet extends Algoformer {
	
	String nombre= "Ratchet";
	int vidaRatchet= 150;
	int ataqueHumanoide= 5;
	int distanciaAtaqueHumanoide= 5;
	int velocidadHumanoide= 1;
	int ataqueAlterno= 35;
	int distanciaAtaqueAlterno= 2;
	int velocidadAlterno= 8;
	
	public Ratchet (){
		
		inicializarAlgoformer (nombre, vidaRatchet, ataqueHumanoide, distanciaAtaqueHumanoide, velocidadHumanoide, ataqueAlterno, distanciaAtaqueAlterno, velocidadAlterno);
	}
}
