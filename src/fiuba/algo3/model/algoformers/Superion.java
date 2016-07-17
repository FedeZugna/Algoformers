package model.algoformers;

public class Superion extends AlgoformerGroso {

	String nombreDeSuperion = "Superion";

	int ataque = 100;
	int distancia = 2;
	int velocidad = 3;
	final static private String rutaImgHum = "file:src/fotos/Algoformers/Superion.png";

	public Superion(Algoformer algo1, Algoformer algo2, Algoformer algo3) {
		this.agregarVidaCorrespondienteAAlgoformer(algo1);
		this.agregarVidaCorrespondienteAAlgoformer(algo2);
		this.agregarVidaCorrespondienteAAlgoformer(algo3);
		int vidaTotal = vidaDe1 + vidaDe2 + vidaDe3;
		this.inicializarAlgoformer(nombreDeSuperion, vidaTotal, ataque, distancia, velocidad, ataque, distancia,
				velocidad, rutaImgHum, rutaImgHum);
		this.calcularCorrespondenciaDeVidaDeCadaUno();
	}

	private void agregarVidaCorrespondienteAAlgoformer(Algoformer algoformer) {
		if (algoformer.getNombre() == "Optimus") {
			this.vidaDe1 = algoformer.getVida();
		}
		if (algoformer.getNombre() == "Bumblebee") {
			this.vidaDe2 = algoformer.getVida();
		}
		if (algoformer.getNombre() == "Ratchet") {
			this.vidaDe3 = algoformer.getVida();
		}
	}

}