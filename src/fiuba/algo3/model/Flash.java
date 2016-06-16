package model;

import model.superficies.Superficie;

public class Flash extends Bonus {

	public Flash(int duracion) {
		super(duracion);
	}

	@Override
	public int aplicarBonus(int stat) {
		return stat * 3;
	}
	
	//REVISAR ESTO
	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void aplicarseEfectosSuperficie(Superficie superficie) {
		// TODO Auto-generated method stub

	}

}
