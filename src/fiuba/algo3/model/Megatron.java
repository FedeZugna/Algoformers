package model;

public class Megatron extends Algoformer {
	
	public Megatron(){
		this.vida=550;
		this.nombre="MEGATRON";
		EstadoAlgoFormer estadoHumanoide = new EstadoHumanoide(10,3,1);//ataque, dist ataque, velocidad
		EstadoAlgoFormer estadoAlterno = new EstadoAlterno(55,2,8);//ataque, dist ataque, velocidad
	    ListaCircular estadosPosibles = new ListaCircular();
	    estadosPosibles.add(estadoHumanoide);
	    estadosPosibles.add(estadoAlterno);
	    this.estados=estadosPosibles;	
	}
}