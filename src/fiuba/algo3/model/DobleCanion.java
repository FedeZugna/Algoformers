package model;

import model.superficies.Superficie;

public class DobleCanion extends Bonus {
	 
	public DobleCanion(int duracion) {
	        super(duracion);
	    }

		@Override
		public int aplicarBonus(int stat) {
			return 2 * stat;
		}

		// REVISAR ESTO
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
