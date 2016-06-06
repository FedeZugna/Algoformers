package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Jugador {

	Tablero tablero ;
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
		/*System.out.println("Ingresar ubicacion primero el largo luego el alto");
		Iterator<Algoformer> iterador = this.equipo.iterator();
		while (iterador.hasNext()) {
			Algoformer current = iterador.next();
			System.out.println("Donde ubicar " + current.getNombre());
			int largo, alto; 
			try( Scanner reader = new Scanner(System.in) ){
				largo = reader.nextInt();
				alto = reader.nextInt();	
			}			
			this.tablero.ubicarElemento( current, new Coordenada(largo,alto));		
		}*/
	}
	public void mover(Algoformer algoTransf, Casillero destino) {
		algoTransf.mover(destino);
		this.tablero.cambiar(algoTransf, algoTransf.getUbicacion(), destino);
		
		
		
	}
	
	public void atacar(Algoformer algoTransf, Coordenada objetivo) throws AtaqueInvalidoException {
		if(this.equipo.contains (this.tablero.devolverElemento(objetivo) ) ){ /*|| objetivo.equals(algoTransf.getUbicacion()))*/
			throw new AtaqueInvalidoException();
			
		}
		algoTransf.atacar((Algoformer)this.tablero.devolverElemento(objetivo));	
	}
	
	public void ubicarElemento(Algoformer algoformer, Coordenada coord) {
		this.tablero.ubicarElemento(algoformer, coord);
	}
	
	public void OrdenaQueSeTranforme(Algoformer algoformer) {
		Iterator<Algoformer> iterador = this.equipo.iterator();
		while(iterador.hasNext()){
			if (iterador.next() == algoformer){
				algoformer.transformar();
				this.equipo.add(this.equipo.indexOf(algoformer), algoformer);
				this.equipo.remove(this.equipo.indexOf(algoformer)+1);
			}
		}
	}
	public ArrayList<Algoformer> devolverAlgoformersVivos() {
		ArrayList<Algoformer> algoformersVivos= new ArrayList<Algoformer>();
		Iterator<Algoformer> iterador = equipo.iterator();
		while(iterador.hasNext()){
			if (iterador.next().estaVivo()){
				algoformersVivos.add(iterador.next() );
			}
		}
		return algoformersVivos;
	}
	public ArrayList<Algoformer> devolverEquipo() {
		return equipo;
	}
}
