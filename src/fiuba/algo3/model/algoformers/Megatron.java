package model.algoformers;

public class Megatron extends Algoformer {

	String nombre = "Megatron";
	int vidaMegatron = 550;
	int ataqueHumanoide = 10;
	int distanciaAtaqueHumanoide = 3;
	int velocidadHumanoide = 1;
	int ataqueAlterno = 55;
	int distanciaAtaqueAlterno = 2;
	int velocidadAlterno = 8;
	final static private String rutaImgAlt = "file:/src/fiuba/algo3/fotos/Algoformers/Megatron.png";
	final static private String rutaImgHum = "file:/src/fiuba/algo3/fotos/Algoformers/MegatronA.png";

	public Megatron() {

		inicializarAlgoformer(nombre, vidaMegatron, ataqueHumanoide, distanciaAtaqueHumanoide, velocidadHumanoide,
				ataqueAlterno, distanciaAtaqueAlterno, velocidadAlterno);
	}
}