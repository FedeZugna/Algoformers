package model.bonus;


public class BurbujaInmaculada extends Bonus {
	
    public BurbujaInmaculada(int duracion){
	super(duracion);
    }
	
    @Override
    public int aplicarModificador(int stat) {
        return 0;
    }

	

}
