package model.bonus;


public class Flash extends Bonus {

	public Flash(int duracion) {
		super(duracion);
	}

    @Override
    public int aplicarModificador(int stat) {
        return stat * 3;
    }


}
