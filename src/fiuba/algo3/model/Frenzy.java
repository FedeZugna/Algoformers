package model;

public class Frenzy extends Algoformer {
	
	String nombre= "Frenzy";
	int vidaFrenzy= 400;
	int ataqueHumanoide= 10;
	int distanciaAtaqueHumanoide= 5;
	int velocidadHumanoide= 2;
	int ataqueAlterno= 25;
	int distanciaAtaqueAlterno= 2;
	int velocidadAlterno= 6;
	
	public Frenzy(){
		
		inicializarAlgoformer (nombre, vidaFrenzy, ataqueHumanoide, distanciaAtaqueHumanoide, velocidadHumanoide, ataqueAlterno, distanciaAtaqueAlterno, velocidadAlterno);
	}
}
