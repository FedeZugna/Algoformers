package model.superficies;

import model.Algoformer;
import model.superficies.Terreno;

public class TerrenoDeEspinas extends Terreno {

	public TerrenoDeEspinas() {
		super();
		super.setPasos_alterno(VELOCIDAD_ESPINAS);
		super.setPasos_humanoide(VELOCIDAD_ESPINAS);
	}

	@Override
	public void aplicarEfectosSuperficie(Algoformer a) {
		double vidaAux= a.getVida()*0.05;
		int vidaARestar= (int) vidaAux;
		a.recibirAtaque(vidaARestar);
	}

}