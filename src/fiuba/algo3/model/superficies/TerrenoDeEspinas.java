package model.superficies;


import model.algoformers.*;
import model.superficies.Terreno;

public class TerrenoDeEspinas extends Terreno {

    private static int DANIO_PORCENTUAL_ESPINAS = 5;
    private String nombre = "file:src/fotos/Terrenos/Espinas.png"; 
	public TerrenoDeEspinas() {
		super();
		agregarRutaDeImagen(nombre);
		super.setPasos_alterno(VELOCIDAD_ESPINAS);
		super.setPasos_humanoide(VELOCIDAD_ESPINAS);
	}

	public void aplicarEfectosSuperficieAlgoformer(Algoformer a){
                Ataque ataqueEspinas = new AtaquePorcentual(DANIO_PORCENTUAL_ESPINAS);
                ataqueEspinas.ataqueEjecutar(a);
	}
	

}