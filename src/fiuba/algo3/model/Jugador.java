package model;

import java.util.ArrayList;

public class Jugador {

	Tablero tablero;
	ArrayList<Algoformer> equipo;
	public Jugador(Tablero tablero, String equipo){
		this.tablero=tablero;
		this.equipo= new ArrayList<Algoformer>();
		if (equipo=="AUTOBOTS"){
			this.equipo.add(new Optimus());
			this.equipo.add(new Bumblebee());
			this.equipo.add(new Ratchet());
		}
		if (equipo=="DECEPTICONS"){     //else
			this.equipo.add(new Megatron());
			this.equipo.add(new BoneCrusher());
			this.equipo.add(new Frenzy());
		}
	}
	public void mover(Algoformer algoTransf, Coordenada destino) {
		this.tablero.cambiar(algoTransf, algoTransf.getUbicacion(), destino);
		algoTransf.mover(this.tablero, destino);
		
		
	}
}
