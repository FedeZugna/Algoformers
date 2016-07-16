package model.bonus;

import model.algoformers.Algoformer;


public class BurbujaInmaculada extends Bonus {
    
    private static final int DURACION_BURBUJA = 2;
    private static final String nombreBurbujaInmaculada = "Burbuja Inmaculada";
    private static final String rutaImg = "file:src/fotos/Bonus/Burbuja.png";
    
    public BurbujaInmaculada(){
	super(DURACION_BURBUJA,nombreBurbujaInmaculada, rutaImg);
    }
	
    @Override
    public int aplicarModificador(int stat) {
        return 0;
    }
@Override
    public void serCapturadoPor(Algoformer a) {
        a.agregarModificadorArmadura(this);
        super.serCapturadoPor(a);
    }
}
