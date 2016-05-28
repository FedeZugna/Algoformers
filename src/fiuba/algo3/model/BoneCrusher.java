package model;

public class BoneCrusher extends Algoformer {
	public BoneCrusher(){
		this.vida=200;
		this.nombre="BONECRUSHER";
		EstadoAlgoFormer estadoHumanoide = new EstadoHumanoide(30,3,1);//ataque, dist ataque, velocidad
		EstadoAlgoFormer estadoAlterno = new EstadoAlterno(30,3,8);//ataque, dist ataque, velocidad
	    ListaCircular estadosPosibles = new ListaCircular();
	    estadosPosibles.add(estadoHumanoide);
	    estadosPosibles.add(estadoAlterno);
	    this.estados=estadosPosibles;	
	}
}
