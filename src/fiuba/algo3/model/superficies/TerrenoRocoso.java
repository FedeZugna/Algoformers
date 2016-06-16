package model.superficies;

public class TerrenoRocoso extends Terreno {

	public TerrenoRocoso() {
		super();
		super.setPasos_alterno(VELOCIDAD_ROCOSO);
		super.setPasos_humanoide(VELOCIDAD_ROCOSO);
	}
}