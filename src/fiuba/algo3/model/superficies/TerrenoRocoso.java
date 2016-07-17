package model.superficies;

public class TerrenoRocoso extends Terreno {

	private String nombre = "file:src/fotos/Terrenos/Rocoso.png";

	public TerrenoRocoso() {
		super();
		agregarRutaDeImagen(nombre);
		super.setPasos_alterno(VELOCIDAD_ROCOSO);
		super.setPasos_humanoide(VELOCIDAD_ROCOSO);
	}
}