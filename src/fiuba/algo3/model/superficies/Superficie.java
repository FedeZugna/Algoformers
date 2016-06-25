
package model.superficies;

import model.*;
import model.algoformers.Algoformer;

public abstract class Superficie {

	public abstract int getPasos_humanoide();

	public abstract int getPasos_alterno();
		
	public void aplicarEfectosSuperficie(Interactuable a){
		a.aplicarseEfectosSuperficie(this);
	}

	public void aplicarEfectosSuperficieAlgoformer(Algoformer a) {
		
	}

	public abstract String devuelveNombreCont();
}
