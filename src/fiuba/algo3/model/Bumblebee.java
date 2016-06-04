package model;

public class Bumblebee extends Algoformer {

	
	int ataqueHumanoide= 40;
	int distanciaAtaqueHumanoide= 1;
	int velocidadHumanoide= 2;
	int ataqueAlterno= 20;
	int distanciaAtaqueAlterno= 3;
	int velocidadAlterno= 5;
	
	public Bumblebee (){
		this.nombre= "Bumblebee";
		this.vida= 350;
		this.inicializarAlgoformer(nombre, vida, ataqueHumanoide, distanciaAtaqueHumanoide, velocidadHumanoide, ataqueAlterno, distanciaAtaqueAlterno, velocidadAlterno);
	}
}
