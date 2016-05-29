package model;

public class Bumblebee extends Algoformer {

	String nombre= "Bumblebee";
	int vidaBumblebee= 350;
	int ataqueHumanoide= 40;
	int distanciaAtaqueHumanoide= 1;
	int velocidadHumanoide= 2;
	int ataqueAlterno= 20;
	int distanciaAtaqueAlterno= 3;
	int velocidadAlterno= 5;
	
	public Bumblebee (){
		
		inicializarAlgoformer (nombre, vidaBumblebee, ataqueHumanoide, distanciaAtaqueHumanoide, velocidadHumanoide, ataqueAlterno, distanciaAtaqueAlterno, velocidadAlterno);
	}
}
