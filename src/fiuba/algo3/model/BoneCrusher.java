package model;

public class BoneCrusher extends Algoformer {
	
	
	int ataqueHumanoide= 30;
	int distanciaAtaqueHumanoide= 3;
	int velocidadHumanoide= 1;
	int ataqueAlterno= 30;
	int distanciaAtaqueAlterno= 3;
	int velocidadAlterno= 8;
	
	public BoneCrusher(){
		this.nombre= "BoneCrusher";
		this.vida= 200;
		this.inicializarAlgoformer(nombre, vida, ataqueHumanoide, distanciaAtaqueHumanoide, velocidadHumanoide, ataqueAlterno, distanciaAtaqueAlterno, velocidadAlterno);
		
	}
}
