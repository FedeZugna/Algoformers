package model.superficies;

import model.Algoformer;

public class TerrenoRocoso extends Terreno {

	public TerrenoRocoso() {
		super();
		super.setPasos_alterno(VELOCIDAD_ROCOSO);
		super.setPasos_humanoide(VELOCIDAD_ROCOSO);
	}

	@Override
	public void aplicarEfectosSuperficie(Algoformer a) {
		//No hace nada
	}

}