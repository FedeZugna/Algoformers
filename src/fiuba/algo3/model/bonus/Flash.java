package model.bonus;

import model.algoformers.Algoformer;


public class Flash extends Bonus {
    
    private static final int DURACION_FLASH = 3;
    private static final String nombreFlash = "Flash";
    private static final String rutaImg = "file:src/fotos/Bonus/Flash.png";
    
	public Flash() {
		super(DURACION_FLASH,nombreFlash, rutaImg);
	}

    @Override
    public int aplicarModificador(int stat) {
        return stat * 3;
    }

    @Override
    public void serCapturadoPor(Algoformer a) {
        a.agregarModificadorVelocidadDesplazamiento(this);
        super.serCapturadoPor(a);
    }

}
