package model.algoformers;

import model.algoformers.Algoformer;
import model.algoformers.Ataque;

public class AtaquePorcentual extends Ataque {

	public AtaquePorcentual(int danio) {
		super(danio);
	}

	@Override
	public void ataqueEjecutar(Algoformer algoformer) {
		int danio = (int) ((float) algoformer.getVida() * (float) this.getDanio() / 100);
		if (danio == 0) {
			danio = 1;
		}
		algoformer.recibirAtaque(danio);
	}

}
