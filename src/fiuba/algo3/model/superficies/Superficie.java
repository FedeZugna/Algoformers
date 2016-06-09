package model.superficies;

import model.*;

public abstract class Superficie {

	public abstract int getPasos_humanoide();

	public abstract int getPasos_alterno();

	public abstract void aplicarEfectosSuperficie(Algoformer a);
}
