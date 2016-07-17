package model.algoformers;

public class Bonecrusher extends Algoformer {

	String nombreDeBonecrusher = "Bonecrusher";
	int vidaDeBonecrusher = 200;
	int ataqueHumanoide = 30;
	int distanciaAtaqueHumanoide = 3;
	int velocidadHumanoide = 1;
	int ataqueAlterno = 30;
	int distanciaAtaqueAlterno = 3;
	int velocidadAlterno = 8;
	final static private String rutaImgAlt = "file:src/fotos/Algoformers/BonecrusherA.png";
	final static private String rutaImgHum = "file:src/fotos/Algoformers/Bonecrusher.png";

	public Bonecrusher() {
		this.inicializarAlgoformer(nombreDeBonecrusher, vidaDeBonecrusher, ataqueHumanoide, distanciaAtaqueHumanoide,
				velocidadHumanoide, ataqueAlterno, distanciaAtaqueAlterno, velocidadAlterno, rutaImgHum, rutaImgAlt);

	}
}
