package model.bonus;

import model.superficies.Superficie;

public class Flash extends Bonus {

	public Flash(int duracion) {
		super(duracion);
	}

	@Override
	public int aplicarBonus(int stat) {
		return stat * 3;
	}

}