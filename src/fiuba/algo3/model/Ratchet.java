package model;

public class Ratchet extends Algoformer {
	public Ratchet (){
		this.vida=150;
		this.nombre="RATCHET";
		EstadoAlgoFormer estadoHumanoide = new EstadoHumanoide(5,5,1); //ataque, dist ataque, velocidad
		EstadoAlgoFormer estadoAlterno = new EstadoAlterno(35,2,8);//ataque, dist ataque, velocidad
	    ListaCircular estadosPosibles = new ListaCircular();
	    estadosPosibles.add(estadoHumanoide);
	    estadosPosibles.add(estadoAlterno);
	    this.estados=estadosPosibles;	
	}
}
