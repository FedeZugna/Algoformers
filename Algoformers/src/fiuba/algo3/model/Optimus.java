package model;

public class Optimus extends Algoformer {

	String nombre = "Optimus";
	int vidaOptimus = 500;
	int ataqueHumanoide = 50;
	int distanciaAtaqueHumanoide = 2;
	int velocidadHumanoide = 2;
	int ataqueAlterno = 15;
	int distanciaAtaqueAlterno = 4;
	int velocidadAlterno = 5;

	public Optimus() {

		inicializarAlgoformer(nombre, vidaOptimus, ataqueHumanoide, distanciaAtaqueHumanoide, velocidadHumanoide,
				ataqueAlterno, distanciaAtaqueAlterno, velocidadAlterno);
	}

}
