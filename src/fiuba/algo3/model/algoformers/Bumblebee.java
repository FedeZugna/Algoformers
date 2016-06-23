package model.algoformers;

public class Bumblebee extends Algoformer {

	int ataqueHumanoide = 40;
	int distanciaAtaqueHumanoide = 1;
	int velocidadHumanoide = 2;
	int ataqueAlterno = 20;
	int distanciaAtaqueAlterno = 3;
	int velocidadAlterno = 5;
	final static private String rutaImgAlt = "file:/src/fiuba/algo3/fotos/Algoformers/Bumblebee.png";
	final static private String rutaImgHum = "file:/src/fiuba/algo3/fotos/Algoformers/BumblebeeA.png";

	public Bumblebee() {
		this.nombre = "Bumblebee";
		this.vida = 350;
		this.inicializarAlgoformer(nombre, vida, ataqueHumanoide, distanciaAtaqueHumanoide, velocidadHumanoide,
				ataqueAlterno, distanciaAtaqueAlterno, velocidadAlterno);
	}
}
