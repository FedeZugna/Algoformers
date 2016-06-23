package model.algoformers;

public class Menasor extends AlgoformerGroso {

	String nombreDeMenasor= "Menasor";
	int ataque = 115;
	int distancia = 2;
	int velocidad = 2;
	final static private String rutaImgHum = "file:/src/fiuba/algo3/fotos/Algoformers/Superion.png";

	public Menasor(Algoformer algo1, Algoformer algo2, Algoformer algo3){
		this.agregarVidaCorrespondienteAAlgoformer(algo1);
		this.agregarVidaCorrespondienteAAlgoformer(algo2);
		this.agregarVidaCorrespondienteAAlgoformer(algo3);
		int vidaTotal= vidaDe1+ vidaDe2+ vidaDe3;
		this.inicializarAlgoformer(nombreDeMenasor, vidaTotal, ataque, distancia, velocidad, ataque, distancia, velocidad);
		this.calcularCorrespondenciaDeVidaDeCadaUno();
	}

	private void agregarVidaCorrespondienteAAlgoformer(Algoformer algoformer) {
		if (algoformer.getNombre()== "Megatron"){
			this.vidaDe1= algoformer.getVida();
		}
		if (algoformer.getNombre()== "Bonecrusher"){
			this.vidaDe2= algoformer.getVida();
		}
		if (algoformer.getNombre()== "Frenzy"){
			this.vidaDe3= algoformer.getVida();
		}
	}

}