package model.bonus;

public class DobleCanion extends Bonus {
	 
	public DobleCanion(int duracion) {
	        super(duracion);
	    }

		@Override
		public int aplicarBonus(int stat) {
			return 2 * stat;
		}

}
