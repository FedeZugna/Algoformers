/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;
import model.algoformers.*;
import view.ContenedorBienvenidos;
import view.ContenedorGanador;
import view.ContenedorPrincipal;
import view.eventos.AplicacionOnKeyPressEventHandler;

/**
 *
 * @author Martin
 */
public class Master {
        private Juego juego;
        private Stage escenarioJuego;
        private Scene escenaPrincipal;
        private Scene escenaBienvenidos;
        
	// singleton
	private Master() {
	}

	private static Master instancia = new Master();

	public static Master getInstancia() {
		return instancia;
	}

	private Algoformer algofActual;

	public Algoformer devolverAlgoformerActual() {
		return this.algofActual;
	}

	public Casillero pedirObjetivo() {
		// Interfaz grafica para que pida un casillero objetivo
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}
      
        public void decidirSiHayGanador(){
            Jugador ganador = this.juego.devolverGanador();
            if (ganador != null){
                this.terminarJuego(ganador);
            }
        }

    public void crearNuevoJuego(Stage escenario) {
              
    		this.escenarioJuego = escenario;
                this.juego = new Juego();
                
                this.escenarioJuego.setTitle("Algoformers");
                
                ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(this.escenarioJuego, this.juego);
                AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(this.escenarioJuego,
				contenedorPrincipal.getBarraDeMenu());
		
                this.escenaPrincipal = new Scene(contenedorPrincipal, 640, 480);
                this.escenaPrincipal.setOnKeyPressed(AplicacionOnKeyPressEventHandler);
             
                
                ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(this.escenarioJuego, this.escenaPrincipal);
                this.escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);
                
                 
    }
    
    public void iniciarJuego(){

		this.escenarioJuego.setScene(this.escenaBienvenidos);
		this.escenarioJuego.setFullScreen(true);

		this.escenarioJuego.show();

    }

    public String getNombreGanador() {
        return this.juego.devolverGanador().devolverNombreEquipo();
    }

    private void terminarJuego(Jugador ganador) {
        
                ContenedorGanador contenedorGanador = new ContenedorGanador(this.escenarioJuego, ganador);
                
                Scene escenaGanador = new Scene(contenedorGanador, 640, 480);
                this.escenarioJuego.setScene(escenaGanador);
                this.escenarioJuego.setFullScreen(true);
    }
        

}
