package model.bonus;

import model.algoformers.Algoformer;


public class Flash extends Bonus {
    
    private static final int DURACION_FLASH = 3;
    
	public Flash() {
		super(DURACION_FLASH);
	}

    @Override
    public int aplicarModificador(int stat) {
        return stat * 3;
    }

    @Override
    public void serCapturadoPor(Algoformer a) {
        a.getEstadoActual().agregarModificadorVelocidadDesplazamiento(this);
        super.serCapturadoPor(a);
    }

}
