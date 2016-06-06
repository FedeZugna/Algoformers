package model;

public class Terreno /*implements */ extends Superficie {
	
	protected final int VELOCIDAD_ROCOSO = 1;
	protected final int VELOCIDAD_ESPINAS = 1;

	private int pasos_humanoide =1 ;
	private int pasos_alterno = 1;
	
	public int getPasos_humanoide() {
		return pasos_humanoide;
	}

	public int getPasos_alterno() {
		return pasos_alterno;
	}	
}