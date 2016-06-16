package model.superficies;


import model.algoformers.*;
import model.superficies.Terreno;

public class TerrenoDeEspinas extends Terreno {

	public TerrenoDeEspinas() {
		super();
		super.setPasos_alterno(VELOCIDAD_ESPINAS);
		super.setPasos_humanoide(VELOCIDAD_ESPINAS);
	}

	public void aplicarEfectosSuperficieAlgoformer(Algoformer a){	
		double vidaAux= a.getVida()*0.05;
		int vidaARestar= (int) vidaAux;
		a.recibirAtaque(vidaARestar);
	}
	

}