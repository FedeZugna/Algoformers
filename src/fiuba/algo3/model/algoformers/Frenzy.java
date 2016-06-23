package model.algoformers;

public class Frenzy extends Algoformer {

	String nombre = "Frenzy";
	int vidaFrenzy = 400;
	int ataqueHumanoide = 10;
	int distanciaAtaqueHumanoide = 5;
	int velocidadHumanoide = 2;
	int ataqueAlterno = 25;
	int distanciaAtaqueAlterno = 2;
	int velocidadAlterno = 6;
	final static private String rutaImgAlt = "file:/src/fiuba/algo3/fotos/Algoformers/Frenzy.png";
	final static private String rutaImgHum = "file:/src/fiuba/algo3/fotos/Algoformers/FrenzyA.png";

	public Frenzy() {

		inicializarAlgoformer(nombre, vidaFrenzy, ataqueHumanoide, distanciaAtaqueHumanoide, velocidadHumanoide,
				ataqueAlterno, distanciaAtaqueAlterno, velocidadAlterno);
	}
}
