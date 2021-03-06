package model.superficies;

public abstract class Terreno extends Superficie {

	public static final int VELOCIDAD_ROCOSO = 1;
	public static final int VELOCIDAD_ESPINAS = VELOCIDAD_ROCOSO; // POR
	private String nombre; // SUPUESTO

	private int pasos_humanoide;
	private int pasos_alterno;

	@Override
	public int getPasos_humanoide() {
		return this.pasos_humanoide;
	}

	@Override
	public int getPasos_alterno() {
		return this.pasos_alterno;
	}

	protected void setPasos_humanoide(int pasos) {
		this.pasos_humanoide = pasos;
	}

	protected void setPasos_alterno(int pasos) {
		this.pasos_alterno = pasos;
	}

	public String devuelveNombreCont() {
		return nombre;
	}

	protected void agregarRutaDeImagen(String nombreDeRuta) {
		this.nombre = nombreDeRuta;
	}
}