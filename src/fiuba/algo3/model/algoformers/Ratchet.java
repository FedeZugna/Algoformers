package model.algoformers;

public class Ratchet extends Algoformer {

	private int ataqueHumanoide = 5;
	private int distanciaAtaqueHumanoide = 5;
	private int velocidadHumanoide = 1;
	private int ataqueAlterno = 35;
	private int distanciaAtaqueAlterno = 2;
	private int velocidadAlterno = 8;
	final static private String rutaImgAlt = "file:src/fotos/Algoformers/RatchetA.png";
	final static private String rutaImgHum = "file:src/fotos/Algoformers/Ratchet.png";

	public Ratchet() {
		this.nombre = "Ratchet";
		this.vida = 150;
		this.inicializarAlgoformer(nombre, vida, ataqueHumanoide, distanciaAtaqueHumanoide, velocidadHumanoide,
				ataqueAlterno, distanciaAtaqueAlterno, velocidadAlterno, rutaImgHum, rutaImgAlt);
	}
}
