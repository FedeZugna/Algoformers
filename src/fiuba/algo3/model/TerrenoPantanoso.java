package model;

import model.Terreno;

public class TerrenoPantanoso extends Terreno {
	public int pasos_humanoide = VELOCIDAD_ROCOSO;
	public int pasos_alterno = 2*VELOCIDAD_ROCOSO;
}