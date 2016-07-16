package model.bonus;

import model.algoformers.Algoformer;

public class DobleCanion extends Bonus {
    private static final int DURACION_DOBLECANION = 3;
    private static final String nombreDobleCanion = "Doble Canion";
    private static final String rutaImg = "file:src/fotos/Bonus/DobleC.png";
    
    public DobleCanion() {
        super(DURACION_DOBLECANION, nombreDobleCanion, rutaImg);
    }

    @Override
    public int aplicarModificador(int stat) {
        return 2 * stat;
    }

    @Override
    public void serCapturadoPor(Algoformer a) {
        a.agregarModificadorAtaque(this);
        super.serCapturadoPor(a);
    }

}
