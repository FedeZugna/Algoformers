package model;

public class Bumblebee extends Algoformer {
	public Bumblebee (){
		this.vida=350;
		this.nombre="BUMBLEBEE";
		EstadoAlgoFormer estadoHumanoide = new EstadoHumanoide(40,1,2); //ataque, dist ataque, velocidad
		EstadoAlgoFormer estadoAlterno = new EstadoAlterno(20,3,5);//ataque, dist ataque, velocidad
	    ListaCircular estadosPosibles = new ListaCircular();
	    estadosPosibles.add(estadoHumanoide);
	    estadosPosibles.add(estadoAlterno);
	    this.estados=estadosPosibles;	
	}
}
