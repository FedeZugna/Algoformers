/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import model.Casillero;
import model.Coordenada;
import model.Interactuable;
import model.Juego;
import model.Jugador;
import model.Tablero;
import model.algoformers.Algoformer;
import model.bonus.Bonus;
import model.bonus.BurbujaInmaculada;
import model.bonus.DobleCanion;
import model.bonus.Flash;
import model.excepciones.*;
import view.eventos.OpcionSalirEventHandler;

/**
 *
 * @author Martin
 */
public class VBoxStatsYOrdenesDisponibles extends VBox {
	private static final String stringVida = "Vida: ";
	private static final String stringAtaque = "Ataque: ";
	private static final String stringAlcance = "Alcance: ";
	private static final String stringVelocidad = "Velocidad: ";
	private static final String stringCantMovsRestantes = "Cantidad de movimientos restantes: ";
	private static final String stringEnemigo = "Enemigo: ";
	Jugador jugadorActual;
	ArrayList<Algoformer> algoformers;
	Algoformer algoformerActual;
	Algoformer algoformerParaAtacar;
	Tablero tablero;
	Juego juegoGeneral;
	ContenedorPrincipal contenedor;
	Boolean atacar = false;
	ArrayList<Algoformer> equipoAutobots;
	ArrayList<Algoformer> equipoDecepticons;
	ArrayList<Algoformer> equipoEnemigo;
	ArrayList<Bonus> listaDeBonus;

	private Text stats[];
	private Text enemigo[];
	private Text nombreObjetivo;
	private Text separadorMovimientos = new Text("Mover:");
	private Text separadorParaSeleccionarGroso = new Text("Combinacion:");
	private Text separadorParaAtacar = new Text("Atacar:");
	private Text separadorPasarTurno = new Text("Fin de turno:");

	public VBoxStatsYOrdenesDisponibles(Jugador jugador, Juego juego, ContenedorPrincipal cont) {
		super();
		this.jugadorActual = jugador;
		this.algoformers = jugadorActual.devolverAlgoformersVivos();
		this.tablero = jugador.devolverTablero();
		this.juegoGeneral = juego;
		this.contenedor = cont;
		this.setPadding(new Insets(10));
		this.setSpacing(8); // Gap between nodes
		this.setStyle("-fx-background-color: #336699;"); // color de fondo

		this.nombreObjetivo = new Text("");
		this.nombreObjetivo.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		this.getChildren().add(this.nombreObjetivo);

		this.separadorMovimientos.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		this.separadorParaSeleccionarGroso.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		this.separadorParaAtacar.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		this.separadorPasarTurno.setFont(Font.font("Arial", FontWeight.BOLD, 14));

		this.stats = new Text[] { new Text(stringVida), new Text(stringAtaque), new Text(stringAlcance),
				new Text(stringVelocidad), new Text(stringCantMovsRestantes) };

		for (int i = 0; i < this.stats.length; i++) {
			// Add offset to left side to indent from title
			VBox.setMargin(this.stats[i], new Insets(0, 0, 0, 8));
			this.getChildren().add(this.stats[i]);
		}

		equipoAutobots = jugador.devolverEquipo();
		equipoDecepticons = juego.pasarTurno().devolverEquipo();
		equipoEnemigo = equipoDecepticons;
		juego.pasarTurno();

		EventHandler<ActionEvent> seleccionarPrimero = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				algoformerActual = algoformers.get(0);
				actualizarNombreObjetivo(algoformerActual.getNombre());
				actualizarStatsObjetivo(algoformerActual.getVida(), algoformerActual.getAtaque(),
						algoformerActual.getAlcance(), algoformerActual.getVelocidad_despl(),
						algoformerActual.getMovimientosRestantes());
				imprimirPantalla();
			}
		};

		EventHandler<ActionEvent> seleccionarSegundo = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				algoformerActual = algoformers.get(1);
				actualizarNombreObjetivo(algoformerActual.getNombre());
				actualizarStatsObjetivo(algoformerActual.getVida(), algoformerActual.getAtaque(),
						algoformerActual.getAlcance(), algoformerActual.getVelocidad_despl(),
						algoformerActual.getMovimientosRestantes());
				imprimirPantalla();
			}
		};

		EventHandler<ActionEvent> seleccionarTercero = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				algoformerActual = algoformers.get(2);
				actualizarNombreObjetivo(algoformerActual.getNombre());
				actualizarStatsObjetivo(algoformerActual.getVida(), algoformerActual.getAtaque(),
						algoformerActual.getAlcance(), algoformerActual.getVelocidad_despl(),
						algoformerActual.getMovimientosRestantes());
				imprimirPantalla();
			}
		};

		EventHandler<ActionEvent> seleccionarGroso = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				algoformerActual = algoformers.get(3);
				actualizarNombreObjetivo(algoformerActual.getNombre());
				actualizarStatsObjetivo(algoformerActual.getVida(), algoformerActual.getAtaque(),
						algoformerActual.getAlcance(), algoformerActual.getVelocidad_despl(),
						algoformerActual.getMovimientosRestantes());
				imprimirPantalla();
			}
		};

		EventHandler<ActionEvent> seleccionarPrimeroParaAtacar = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (algoformerActual.getNombre() == "Optimus" || algoformerActual.getNombre() == "Bumblebee"
						|| algoformerActual.getNombre() == "Ratchet" || algoformerActual.getNombre() == "Superion") {
					algoformerParaAtacar = equipoDecepticons.get(0);
				} else {
					algoformerParaAtacar = equipoAutobots.get(0);
				}
				actualizarStatsEnemigo(algoformerParaAtacar.getNombre(), algoformerParaAtacar.getVida());
				imprimirPantalla();
			}
		};

		EventHandler<ActionEvent> seleccionarSegundoParaAtacar = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (algoformerActual.getNombre() == "Optimus" || algoformerActual.getNombre() == "Bumblebee"
						|| algoformerActual.getNombre() == "Ratchet" || algoformerActual.getNombre() == "Superion") {
					algoformerParaAtacar = equipoDecepticons.get(1);
				} else {
					algoformerParaAtacar = equipoAutobots.get(1);
				}
				actualizarStatsEnemigo(algoformerParaAtacar.getNombre(), algoformerParaAtacar.getVida());
				imprimirPantalla();
			}
		};

		EventHandler<ActionEvent> seleccionarTerceroParaAtacar = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (algoformerActual.getNombre() == "Optimus" || algoformerActual.getNombre() == "Bumblebee"
						|| algoformerActual.getNombre() == "Ratchet" || algoformerActual.getNombre() == "Superion") {
					algoformerParaAtacar = equipoDecepticons.get(2);
				} else {
					algoformerParaAtacar = equipoAutobots.get(2);
				}
				actualizarStatsEnemigo(algoformerParaAtacar.getNombre(), algoformerParaAtacar.getVida());
				imprimirPantalla();
			}
		};

		EventHandler<ActionEvent> seleccionarGrosoParaAtacar = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (algoformerActual.getNombre() == "Optimus" || algoformerActual.getNombre() == "Bumblebee"
						|| algoformerActual.getNombre() == "Ratchet" || algoformerActual.getNombre() == "Superion") {
					algoformerParaAtacar = equipoDecepticons.get(3);
				} else {
					algoformerParaAtacar = equipoAutobots.get(3);
				}
				actualizarStatsEnemigo(algoformerParaAtacar.getNombre(), algoformerParaAtacar.getVida());
				imprimirPantalla();
			}
		};

		EventHandler<ActionEvent> botonTransformarHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				algoformerActual.transformar();
				actualizarStatsObjetivo(algoformerActual.getVida(), algoformerActual.getAtaque(),
						algoformerActual.getAlcance(), algoformerActual.getVelocidad_despl(),
						algoformerActual.getMovimientosRestantes());
				imprimirPantalla();
			}
		};

		EventHandler<ActionEvent> botonCombinarHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				jugadorActual.combinarAlgoformers(algoformers.get(0), algoformers.get(1), algoformers.get(2));
				algoformers = jugadorActual.devolverEquipo();
				algoformerActual = algoformers.get(3);
				actualizarNombreObjetivo(algoformerActual.getNombre());
				actualizarStatsObjetivo(algoformerActual.getVida(), algoformerActual.getAtaque(),
						algoformerActual.getAlcance(), algoformerActual.getVelocidad_despl(),
						algoformerActual.getMovimientosRestantes());
				imprimirPantalla();
			}
		};

		EventHandler<ActionEvent> botonMoverNorteHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Coordenada coordenadaNorte = new Coordenada(algoformerActual.getUbicacion().getUbicacion().getLargo(),
						algoformerActual.getUbicacion().getUbicacion().getAlto() - 1);
				Casillero casilleroNorte = tablero.devolverCasillero(coordenadaNorte);
				try {
					algoformerActual.mover(casilleroNorte);
					actualizarStatsObjetivo(algoformerActual.getVida(), algoformerActual.getAtaque(),
							algoformerActual.getAlcance(), algoformerActual.getVelocidad_despl(),
							algoformerActual.getMovimientosRestantes());
					imprimirPantalla();

				} catch (NoPuedeMoverseException e) {

				} catch (CasilleroOcupadoException ex) {

				} catch (NullPointerException exc) {

				} catch (ChispaCapturadaException win) {

				}
			}
		};

		EventHandler<ActionEvent> botonMoverOesteHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Coordenada coordenadaOeste = new Coordenada(
						algoformerActual.getUbicacion().getUbicacion().getLargo() - 1,
						algoformerActual.getUbicacion().getUbicacion().getAlto());
				Casillero casilleroOeste = tablero.devolverCasillero(coordenadaOeste);
				try {
					algoformerActual.mover(casilleroOeste);
					actualizarStatsObjetivo(algoformerActual.getVida(), algoformerActual.getAtaque(),
							algoformerActual.getAlcance(), algoformerActual.getVelocidad_despl(),
							algoformerActual.getMovimientosRestantes());
					imprimirPantalla();

				} catch (NoPuedeMoverseException e) {

				} catch (CasilleroOcupadoException ex) {

				} catch (NullPointerException exc) {

				}
			}
		};

		EventHandler<ActionEvent> botonMoverSurHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Coordenada coordenadaSur = new Coordenada(algoformerActual.getUbicacion().getUbicacion().getLargo(),
						algoformerActual.getUbicacion().getUbicacion().getAlto() + 1);
				Casillero casilleroSur = tablero.devolverCasillero(coordenadaSur);
				try {
					algoformerActual.mover(casilleroSur);
					actualizarStatsObjetivo(algoformerActual.getVida(), algoformerActual.getAtaque(),
							algoformerActual.getAlcance(), algoformerActual.getVelocidad_despl(),
							algoformerActual.getMovimientosRestantes());
					imprimirPantalla();

				} catch (NoPuedeMoverseException e) {

				} catch (CasilleroOcupadoException ex) {

				} catch (NullPointerException exc) {

				}
			}
		};

		EventHandler<ActionEvent> botonMoverEsteHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Coordenada coordenadaEste = new Coordenada(
						algoformerActual.getUbicacion().getUbicacion().getLargo() + 1,
						algoformerActual.getUbicacion().getUbicacion().getAlto());
				Casillero casilleroEste = tablero.devolverCasillero(coordenadaEste);
				try {
					algoformerActual.mover(casilleroEste);
					actualizarStatsObjetivo(algoformerActual.getVida(), algoformerActual.getAtaque(),
							algoformerActual.getAlcance(), algoformerActual.getVelocidad_despl(),
							algoformerActual.getMovimientosRestantes());
					imprimirPantalla();

				} catch (NoPuedeMoverseException e) {

				} catch (CasilleroOcupadoException ex) {

				} catch (NullPointerException exc) {

				}
			}
		};

		EventHandler<ActionEvent> botonPasarTurnoHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				jugadorActual = juegoGeneral.pasarTurno();
				if (jugadorActual.getTurnosCombinado() >= 2) {
					jugadorActual.separarAlgoformers();
				} else if (jugadorActual.getTurnosCombinado() != 0) {
					jugadorActual.sumarTurnosCombinado();
				}
				algoformers = jugadorActual.devolverAlgoformersVivos();
				if (algoformerActual != null) {
					actualizarStatsObjetivo(algoformerActual.getVida(), algoformerActual.getAtaque(),
							algoformerActual.getAlcance(), algoformerActual.getVelocidad_despl(),
							algoformerActual.getMovimientosRestantes());
				}
				actualizarStatsVacio();
				actualizarNombreObjetivo("");
				algoformerActual.transformar();
				algoformerActual.transformar();// se reestablecen los valores de
												// los movimientos
				if (equipoEnemigo == equipoDecepticons) {
					equipoEnemigo = equipoAutobots;
				} else {
					equipoEnemigo = equipoDecepticons;
				}
				imprimirPantalla();
			}

		};

		EventHandler<ActionEvent> botonAtacarHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				algoformerActual.atacar(algoformerParaAtacar);
				actualizarStatsEnemigo(algoformerParaAtacar.getNombre(), algoformerParaAtacar.getVida());
				imprimirPantalla();
			}
		};

		HBox botonesParaSeleccionarLosAlgoformers = new HBox();

		Button primerAlgoformer = new Button(algoformers.get(0).getNombre());
		primerAlgoformer.setPrefSize(80, 20);
		primerAlgoformer.setOnAction(seleccionarPrimero);

		Button segundoAlgoformer = new Button(algoformers.get(1).getNombre());
		segundoAlgoformer.setPrefSize(80, 20);
		segundoAlgoformer.setOnAction(seleccionarSegundo);

		Button tercerAlgoformer = new Button(algoformers.get(2).getNombre());
		tercerAlgoformer.setPrefSize(80, 20);
		tercerAlgoformer.setOnAction(seleccionarTercero);

		Button botonSeleccionarGroso = new Button();
		if (algoformers.size() == 4) {
			botonSeleccionarGroso.setText(algoformers.get(3).getNombre());
		}
		botonSeleccionarGroso.setPrefSize(80, 20);
		botonSeleccionarGroso.setOnAction(seleccionarGroso);

		Button botonTransformar = new Button();
		botonTransformar.setText("Transformar");
		botonTransformar.setOnAction(botonTransformarHandler);

		Button botonCombinar = new Button();
		botonCombinar.setText("Combinar");
		botonCombinar.setOnAction(botonCombinarHandler);
		botonCombinar.setOnMouseClicked(e -> {
			botonSeleccionarGroso.setText(algoformers.get(3).getNombre());
		});

		Button moverNorte = new Button();
		moverNorte.setPrefSize(50, 10);
		moverNorte.setText("Norte");
		moverNorte.setOnAction(botonMoverNorteHandler);

		Button moverOeste = new Button();
		moverOeste.setPrefSize(50, 10);
		moverOeste.setText("Oeste");
		moverOeste.setOnAction(botonMoverOesteHandler);

		Button moverSur = new Button();
		moverSur.setPrefSize(50, 10);
		moverSur.setText("Sur");
		moverSur.setOnAction(botonMoverSurHandler);

		Button moverEste = new Button();
		moverEste.setPrefSize(50, 10);
		moverEste.setText("Este");
		moverEste.setOnAction(botonMoverEsteHandler);

		HBox botonesParaMoverse = new HBox();
		botonesParaMoverse.getChildren().addAll(moverNorte, moverOeste, moverSur, moverEste);

		Button botonAtacar = new Button();
		botonAtacar.setPrefSize(50, 10);
		botonAtacar.setText("Atacar");
		botonAtacar.setOnAction(botonAtacarHandler);

		HBox botonesParaSeleccionarLosAlgoformersParaAtacar = new HBox();

		Button primerAlgoformerParaAtacar = new Button(equipoEnemigo.get(0).getNombre());
		primerAlgoformerParaAtacar.setPrefSize(80, 20);
		primerAlgoformerParaAtacar.setOnAction(seleccionarPrimeroParaAtacar);

		Button segundoAlgoformerParaAtacar = new Button(equipoEnemigo.get(1).getNombre());
		segundoAlgoformerParaAtacar.setPrefSize(80, 20);
		segundoAlgoformerParaAtacar.setOnAction(seleccionarSegundoParaAtacar);

		Button tercerAlgoformerParaAtacar = new Button(equipoEnemigo.get(2).getNombre());
		tercerAlgoformerParaAtacar.setPrefSize(80, 20);
		tercerAlgoformerParaAtacar.setOnAction(seleccionarTerceroParaAtacar);

		Button botonSeleccionarGrosoParaAtacar = new Button();
		if (algoformers.size() == 4) {
			botonSeleccionarGrosoParaAtacar.setText(equipoEnemigo.get(3).getNombre());
		} /*
			 * else{ botonSeleccionarGrosoParaAtacar.setDisable(true); }
			 */
		botonSeleccionarGrosoParaAtacar.setPrefSize(80, 20);
		botonSeleccionarGrosoParaAtacar.setOnAction(seleccionarGrosoParaAtacar);

		botonesParaSeleccionarLosAlgoformersParaAtacar.getChildren().addAll(primerAlgoformerParaAtacar,
				segundoAlgoformerParaAtacar, tercerAlgoformerParaAtacar);

		Button pasarTurno = new Button();
		pasarTurno.setPrefSize(80, 15);
		pasarTurno.setText("Pasar Turno");
		pasarTurno.setOnAction(botonPasarTurnoHandler);
		pasarTurno.setOnMouseClicked(e -> {
			primerAlgoformer.setText(algoformers.get(0).getNombre());
			segundoAlgoformer.setText(algoformers.get(1).getNombre());
			tercerAlgoformer.setText(algoformers.get(2).getNombre());
			if (algoformers.size() == 4) {
				botonSeleccionarGroso.setText(algoformers.get(3).getNombre());
			} else {
				botonSeleccionarGroso.setText("");
			}
			primerAlgoformerParaAtacar.setText(equipoEnemigo.get(0).getNombre());
			segundoAlgoformerParaAtacar.setText(equipoEnemigo.get(1).getNombre());
			tercerAlgoformerParaAtacar.setText(equipoEnemigo.get(2).getNombre());
			if (equipoEnemigo.size() == 4) {
				botonSeleccionarGrosoParaAtacar.setText(equipoEnemigo.get(3).getNombre());
			} else {
				botonSeleccionarGrosoParaAtacar.setText("");
			}
		});

		botonesParaSeleccionarLosAlgoformers.getChildren().addAll(primerAlgoformer, segundoAlgoformer,
				tercerAlgoformer);
		this.getChildren().addAll(botonesParaSeleccionarLosAlgoformers, botonTransformar);

		this.getChildren().add(this.separadorMovimientos);
		this.getChildren().addAll(botonesParaMoverse);

		this.getChildren().add(this.separadorParaSeleccionarGroso);
		this.getChildren().addAll(botonCombinar, botonSeleccionarGroso);

		this.getChildren().add(this.separadorParaAtacar);
		this.getChildren().addAll(botonesParaSeleccionarLosAlgoformersParaAtacar, botonSeleccionarGrosoParaAtacar,
				botonAtacar);

		this.getChildren().add(this.separadorPasarTurno);
		this.getChildren().add(pasarTurno);

		this.enemigo = new Text[] { new Text(stringEnemigo), new Text(stringVida) };

		for (int i = 0; i < this.enemigo.length; i++) {
			// Add offset to left side to indent from title
			VBox.setMargin(this.enemigo[i], new Insets(0, 0, 0, 8));
			this.getChildren().add(this.enemigo[i]);
		}

		actualizarStatsVacio();
	}

	public void actualizarStatsConCasillero(Casillero cas) {
		// if (cas.casilleroOcupado()){
		Interactuable ocupante = cas.devolverElemento();
		try {
			if (ocupante.estaVivo()) {
				Algoformer ocupanteA = (Algoformer) cas.devolverElemento();
				actualizarStatsObjetivo(ocupanteA.getVida(), ocupanteA.getAtaque(), ocupanteA.getAlcance(),
						ocupanteA.getVelocidad_despl(), ocupanteA.getMovimientosRestantes());
				actualizarNombreObjetivo(ocupanteA.getNombre());
			}
		} catch (AccionInvalidaException a) {
			actualizarStatsVacio();
			actualizarNombreObjetivo(ocupante.getNombre());
		} catch (NullPointerException a) {
			actualizarStatsVacio();
			actualizarNombreObjetivo("");
		}
		// }
	}

	private void actualizarStatsObjetivo(int vida, int atk, int rng, int vel, int movsRes) {
		this.stats[0].setText(stringVida + vida);
		this.stats[1].setText(stringAtaque + atk);
		this.stats[2].setText(stringAlcance + rng);
		this.stats[3].setText(stringVelocidad + vel);
		this.stats[4].setText(stringCantMovsRestantes + movsRes);
	}

	private void actualizarStatsEnemigo(String nombre, int vida) {
		this.enemigo[0].setText(stringEnemigo + nombre);
		this.enemigo[1].setText(stringVida + vida);
	}

	private void actualizarOrdenesDisponiblesObjetivo() {
		String BANDO_PRUEBA1 = "Autobots";
		String BANDO_PRUEBA2 = "Decepticons";
		String BANDO_PRUEBA = BANDO_PRUEBA1; // ir probando, puede ser null

		// BOTONES.setVisible(false);
		try {
			if (BANDO_PRUEBA.equals(BANDO_PRUEBA1)) {
				BANDO_PRUEBA = BANDO_PRUEBA; // no hace nada
				// BOTONES.setVIsible(true);
			}
		} catch (NullPointerException casillero_vacio) {
		} // A reemplazar por CasilleroVacioException

	}

	private void actualizarStatsVacio() {
		this.stats[0].setText(stringVida);
		this.stats[1].setText(stringAtaque);
		this.stats[2].setText(stringAlcance);
		this.stats[3].setText(stringVelocidad);
		this.stats[4].setText(stringCantMovsRestantes);
	}

	private void actualizarNombreObjetivo(String nombre) {
		this.nombreObjetivo.setText(nombre);
	}

	private void imprimirPantalla() {
		if (algoformerActual.devuelveNombreCont() == "file:src/fotos/Algoformers/MegatronA.png"
				|| algoformerActual.devuelveNombreCont() == "file:src/fotos/Algoformers/RatchetA.png") {
			contenedor.vistaCasillerosUpdateAereo();
		} else {
			contenedor.vistaCasillerosUpdate();
		}
	}

}
