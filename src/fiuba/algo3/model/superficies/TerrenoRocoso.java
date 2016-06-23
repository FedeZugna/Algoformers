package model.superficies;

public class TerrenoRocoso extends Terreno {
	private String nombre = "TerrenoRocoso";
	public TerrenoRocoso() {
		super();
		super.setPasos_alterno(VELOCIDAD_ROCOSO);
		super.setPasos_humanoide(VELOCIDAD_ROCOSO);
	}
}