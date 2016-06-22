package model.bonus;

import model.algoformers.Algoformer;

public class DobleCanion extends Bonus {
    private static final int DURACION_DOBLECANION = 3;
    
    public DobleCanion() {
        super(DURACION_DOBLECANION);
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
