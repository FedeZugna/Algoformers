package model.superficies;

import model.superficies.Terreno;



public class TerrenoDeEspinas extends Terreno {

    public TerrenoDeEspinas() {
        super();
        super.setPasos_alterno(VELOCIDAD_ESPINAS);
        super.setPasos_humanoide(VELOCIDAD_ESPINAS);
    }
    
}