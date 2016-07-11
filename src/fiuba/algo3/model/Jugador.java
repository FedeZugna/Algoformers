package model;

import model.excepciones.AlgoformerCombinadoNoPuedeTransformarseException;
import model.excepciones.CasilleroOcupadoException;
import model.excepciones.AtaqueInvalidoException;
import java.util.ArrayList;
import model.algoformers.*;
import java.util.Iterator;

public class Jugador {

	private Tablero tablero;
	private ArrayList<Algoformer> equipo;
	public String nombreEquipo;

	public Jugador(Tablero tablero, String Nomequipo) {
		this.nombreEquipo = Nomequipo;
		this.tablero = tablero;
		this.equipo = new ArrayList<Algoformer>();
		if (Nomequipo== "AUTOBOTS") {
			this.equipo.add(new Optimus());
			this.equipo.add(new Bumblebee());
			this.equipo.add(new Ratchet());
		}
		if (Nomequipo== "DECEPTICONS") { // else
			this.equipo.add(new Megatron());
			this.equipo.add(new Bonecrusher());
			this.equipo.add(new Frenzy());
		}
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
		ArrayList<Algoformer> algoformersVivos = new ArrayList<>();
		Iterator<Algoformer> iterador = equipo.iterator();
		while (iterador.hasNext()) {
			Algoformer actual = iterador.next();
                        if (actual.estaVivo()) {
				algoformersVivos.add(actual);
			}
		}
		return algoformersVivos;
	}

	public ArrayList<Algoformer> devolverEquipo() {
		return equipo;
	}

	public void combinarAlgoformers(Algoformer algoformer1, Algoformer algoformer2, Algoformer algoformer3) {

		if (algoformer1.esCombinableCon(algoformer2) && algoformer1.esCombinableCon(algoformer3)) {
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
//cambio aca		
		this.tablero.ubicarElemento(algoformerCombinado, casilleroCentral.getUbicacion());

//		algoformerCombinado.ubicarEn(casilleroCentral);
		algoformer2.getUbicacion().removerElemento();// no cambia la ubicacion
		algoformer3.getUbicacion().removerElemento();// que conoce el algoformer
	}

	public void separarAlgoformers() {
		
		AlgoformerGroso algoformerCombinado= (AlgoformerGroso)equipo.get(3);
		equipo.get(0).setVidaAlSeparar(algoformerCombinado.getVida1());
		equipo.get(1).setVidaAlSeparar(algoformerCombinado.getVida2());
		equipo.get(2).setVidaAlSeparar(algoformerCombinado.getVida3());
		this.posicionarAlgoformersPostCombinacion(equipo.get(0), equipo.get(1), equipo.get(2), algoformerCombinado);
	}

	private void posicionarAlgoformersPostCombinacion(Algoformer algoformer1,
			Algoformer algoformer2, Algoformer algoformer3,
			AlgoformerGroso algoformerCombinado) {

		Coordenada coordenadaCentral= algoformerCombinado.getUbicacion().getUbicacion();
		algoformerCombinado.getUbicacion().removerElemento();
		equipo.remove(equipo.get(3));
		this.ubicarPorSeparacion(algoformer1, coordenadaCentral);
		this.ubicarPorSeparacion(algoformer2, coordenadaCentral);
		this.ubicarPorSeparacion(algoformer3, coordenadaCentral);
	}

	private void ubicarPorSeparacion(Algoformer algoformer,
			Coordenada coordenada) {
		try{
			this.tablero.ubicarElemento(algoformer, coordenada);
		}catch (CasilleroOcupadoException e){
			Coordenada coordenadaSiguiente= new Coordenada(coordenada.getLargo()+1, coordenada.getAlto()); //inverti estos
			this.ubicarPorSeparacion(algoformer, coordenadaSiguiente);
		}catch (NullPointerException e){
			Coordenada coordenadaSiguiente= new Coordenada(coordenada.getLargo()-7, coordenada.getAlto());//inverti estos
//			Coordenada coordenadaSiguiente= new Coordenada(coordenada.getLargo()-3, coordenada.getAlto());//inverti estos
			this.ubicarPorSeparacion(algoformer, coordenadaSiguiente);
/*
		}catch (StackOverflowError e){
			Coordenada coordenadaSiguiente= new Coordenada(coordenada.getLargo()-7, coordenada.getAlto());//inverti estos
			this.ubicarPorSeparacion(algoformer, coordenadaSiguiente);
*/
		}
	}

	public Tablero devolverTablero() {
		return this.tablero;
	}
}
