package model;

public class Frenzy extends Algoformer {
	public Frenzy(){
		this.vida=400;
		this.nombre="FRENZY";
		EstadoAlgoFormer estadoHumanoide = new EstadoHumanoide(10,5,2);//ataque, dist ataque, velocidad
		EstadoAlgoFormer estadoAlterno = new EstadoAlterno(25,2,6);//ataque, dist ataque, velocidad
	    ListaCircular estadosPosibles = new ListaCircular();
	    estadosPosibles.add(estadoHumanoide);
	    estadosPosibles.add(estadoAlterno);
	    this.estados=estadosPosibles;	
	}
}
