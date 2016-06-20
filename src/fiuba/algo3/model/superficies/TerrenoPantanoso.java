package model.superficies;

import model.excepciones.NoPuedeMoverseException;
import model.algoformers.*;
import model.superficies.Terreno;

public class TerrenoPantanoso extends Terreno {

	public TerrenoPantanoso() {
		super();
		super.setPasos_alterno(2 * VELOCIDAD_ROCOSO);
	}

	@Override
	public int getPasos_humanoide() {
		throw new NoPuedeMoverseException();
	}
}