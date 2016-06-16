package model;

public class AtaquePorcentual extends Ataque {

//	public AtaquePorcentual(int danio, int descuento) {
//		super((int) (danio - danio * ((float) descuento / 100)));
//	}
	
	public AtaquePorcentual(int danio) {
		super(danio);
	}
	
	@Override
	public void ataqueEjecutar(Algoformer algoformer) {
		int danio = (int)((float)algoformer.getVida()*(float)this.getDanio()/100);
		if(danio == 0){
			danio = 1;
		}
		algoformer.recibirAtaque(danio);
	}

}
