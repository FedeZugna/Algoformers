package model;

public class Optimus extends Algoformer{

	public Optimus() {
		this.vida=500;
		this.nombre="OPTIMUS";
		EstadoAlgoFormer estadoHumanoide = new EstadoHumanoide(50,2,2);//ataque, dist ataque, velocidad
		EstadoAlgoFormer estadoAlterno = new EstadoAlterno(15,4,5);//ataque, dist ataque, velocidad
	    ListaCircular estadosPosibles = new ListaCircular();
	    estadosPosibles.add(estadoHumanoide);
	    estadosPosibles.add(estadoAlterno);
	    this.estados=estadosPosibles;	
	}
	
}
