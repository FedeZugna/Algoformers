package model;

import model.superficies.Superficie;

public class BurbujaInmaculada extends Bonus {
	
	public BurbujaInmaculada(int duracion){
		super(duracion);
	}
	
	@Override
	public int aplicarBonus(int factor) {
		// TODO Auto-generated method stub
		return 0;
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
