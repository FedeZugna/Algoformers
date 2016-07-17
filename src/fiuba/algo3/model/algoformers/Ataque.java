package model.algoformers;

public abstract class Ataque {

	private int danio;

	public Ataque(int danio) {
		this.danio = danio;
	}

	public void ataqueEjecutar(Algoformer algoformer) {
		algoformer.recibirAtaque(this.danio);
	}

	public int getDanio() {
		return this.danio;
	}

	public void setDanio(int danio) {
		this.danio = danio;
	}
}
