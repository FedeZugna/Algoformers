package model.superficies;

import model.excepciones.NoPuedeMoverseException;
import model.superficies.Terreno;

public class TerrenoPantanoso extends Terreno {
	private String nombre = "file:src/fotos/Terrenos/Pantano.png";
	public TerrenoPantanoso() {
		super();
		agregarRutaDeImagen(nombre);
		super.setPasos_alterno(2 * VELOCIDAD_ROCOSO);
	}

	@Override
	public int getPasos_humanoide() {
		throw new NoPuedeMoverseException();
	}
}