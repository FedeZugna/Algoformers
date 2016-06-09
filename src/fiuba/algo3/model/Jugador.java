package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Jugador {

	Tablero tablero;
	ArrayList<Algoformer> equipo;

	public Jugador(Tablero tablero, String equipo) {

		this.tablero = tablero;
		this.equipo = new ArrayList<Algoformer>();
		if (equipo == "AUTOBOTS") {
			this.equipo.add(new Optimus());
			this.equipo.add(new Bumblebee());
			this.equipo.add(new Ratchet());
		}
		if (equipo == "DECEPTICONS") { // else
			this.equipo.add(new Megatron());
			this.equipo.add(new BoneCrusher());
			this.equipo.add(new Frenzy());
		}
		/*
		 * System.out.println(
		 * "Ingresar ubicacion primero el largo luego el alto");
		 * Iterator<Algoformer> iterador = this.equipo.iterator(); while
		 * (iterador.hasNext()) { Algoformer current = iterador.next();
		 * System.out.println("Donde ubicar " + current.getNombre()); int largo,
		 * alto; try( Scanner reader = new Scanner(System.in) ){ largo =
		 * reader.nextInt(); alto = reader.nextInt(); }
		 * this.tablero.ubicarElemento( current, new Coordenada(largo,alto)); }
		 */
	}

	public void mover(Algoformer algoTransf, Casillero destino) {
		algoTransf.mover(destino);
		this.tablero.cambiar(algoTransf, algoTransf.getUbicacion(), destino);

	}

	public void atacar(Algoformer algoTransf, Coordenada objetivo) throws AtaqueInvalidoException {
		if (this.equipo.contains(this.tablero.devolverElemento(
				objetivo))) { /*
								 * || objetivo.equals(algoTransf.getUbicacion()))
								 */
			throw new AtaqueInvalidoException();

		}
		algoTransf.atacar((Algoformer) this.tablero.devolverElemento(objetivo));
	}

	public void ubicarElemento(Algoformer algoformer, Coordenada coord) {
		this.tablero.ubicarElemento(algoformer, coord);
	}

	public void OrdenaQueSeTranforme(Algoformer algoformer) throws AlgoformerCombinadoNoPuedeTransformarseException {
		if (algoformer.getNombre() == "Superion" || algoformer.getNombre() == "Menasor") {
			throw new AlgoformerCombinadoNoPuedeTransformarseException();
		}
		Iterator<Algoformer> iterador = this.equipo.iterator();
		while (iterador.hasNext()) {
			if (iterador.next() == algoformer) {
				algoformer.transformar();
				this.equipo.add(this.equipo.indexOf(algoformer), algoformer);
				this.equipo.remove(this.equipo.indexOf(algoformer) + 1);
			}
		}
	}

	public ArrayList<Algoformer> devolverAlgoformersVivos() {
		ArrayList<Algoformer> algoformersVivos = new ArrayList<Algoformer>();
		Iterator<Algoformer> iterador = equipo.iterator();
		while (iterador.hasNext()) {
			if (iterador.next().estaVivo()) {
				algoformersVivos.add(iterador.next());
			}
		}
		return algoformersVivos;
	}

	public ArrayList<Algoformer> devolverEquipo() {
		return equipo;
	}

	public void combinarAlgoformers(Algoformer algoformer1, Algoformer algoformer2, Algoformer algoformer3) {

		// algun metodo para buscar el algoformer del medio
		if (algoformer1.esCombinableCon(algoformer2) && algoformer1.esCombinableCon(algoformer3)) {
			// null a la posicion de los algoformers
			if (algoformer1.getNombre() == "Optimus" || algoformer1.getNombre() == "Bumblebee" || algoformer1.getNombre() == "Ratchet") {
				equipo.add(new Superion(algoformer1, algoformer2, algoformer3));
				this.posicionarAlgoformersPorCombinacion(algoformer1, algoformer2, algoformer3, equipo.get(3));
			}else{
				equipo.add(new Menasor(algoformer1, algoformer2, algoformer3));
				this.posicionarAlgoformersPorCombinacion(algoformer1, algoformer2, algoformer3, equipo.get(3));

			}
		}
	}

	private void posicionarAlgoformersPorCombinacion(Algoformer algoformer1, Algoformer algoformer2,
			Algoformer algoformer3, Algoformer algoformerCombinado) {
		Casillero casilleroCentral= algoformer1.getUbicacion();
		algoformer1.getUbicacion().removerElemento();
		algoformerCombinado.fueUbicadoEn(casilleroCentral);
		algoformer2.getUbicacion().removerElemento();// no cambia la ubicacion
		algoformer3.getUbicacion().removerElemento();// que conoce el algoformer
	}

	public void separarAlgoformers() {
		
		AlgoformerGroso algoformerCombinado= (AlgoformerGroso)equipo.get(3);
		System.out.println("Lucas");
		equipo.get(0).setVidaAlSeparar(algoformerCombinado.getVida1());
		equipo.get(1).setVidaAlSeparar(algoformerCombinado.getVida2());
		equipo.get(2).setVidaAlSeparar(algoformerCombinado.getVida3());
		this.posicionarAlgoformersPostCombinacion(equipo.get(0), equipo.get(1), equipo.get(2), algoformerCombinado);
	}

	private void posicionarAlgoformersPostCombinacion(Algoformer algoformer1,
			Algoformer algoformer2, Algoformer algoformer3,
			AlgoformerGroso algoformerCombinado) {
		
//AGREGAR UNA EXCEPCION POR SI NO SE PUEDE POSICIONAR EN ALGUNA POSICION
		Casillero casilleroCentral= algoformerCombinado.getUbicacion();
		algoformerCombinado.getUbicacion().removerElemento();
		Coordenada coordenadaCentral= algoformerCombinado.getUbicacion().getUbicacion();
		Coordenada coordenadaDerecha= new Coordenada(coordenadaCentral.getLargo()+1,coordenadaCentral.getAlto());
		Casillero casilleroDerecho= new Casillero(casilleroCentral.getTerreno());
		casilleroDerecho.setUbicacion(coordenadaDerecha);
		Coordenada coordenadaArriba= new Coordenada(coordenadaCentral.getLargo(),coordenadaCentral.getAlto()+1);
		Casillero casilleroArriba= new Casillero(casilleroCentral.getTerreno());
		casilleroArriba.setUbicacion(coordenadaArriba);
		algoformer1.fueUbicadoEn(casilleroCentral);
		algoformer2.fueUbicadoEn(casilleroDerecho);
		algoformer3.fueUbicadoEn(casilleroArriba);
		equipo.remove(equipo.get(3));
	}
}
