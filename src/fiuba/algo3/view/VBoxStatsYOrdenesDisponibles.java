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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import model.Casillero;
import model.Interactuable;
import model.Juego;
import model.Jugador;
import model.algoformers.Algoformer;
import view.eventos.OpcionSalirEventHandler;

/**
 *
 * @author Martin
 */
public class VBoxStatsYOrdenesDisponibles extends VBox{
    private static final String stringVida = "Vida: ";
    private static final String stringAtaque = "Ataque: ";
    private static final String stringAlcance = "Alcance: ";
    private static final String stringVelocidad = "Velocidad: ";
    private static final String stringCantMovsRestantes = "Cantidad de movimientos restantes: ";
    Jugador jugador;
    ArrayList<Algoformer> algoformers;
    Algoformer algoformerActual;
    
    
    
    private Text stats[];
    
    public VBoxStatsYOrdenesDisponibles(Jugador jugador){
        super();
        this.jugador= jugador;
        algoformers= jugador.devolverAlgoformersVivos();
        this.setPadding(new Insets(10));
        this.setSpacing(8);              // Gap between nodes
        this.setStyle("-fx-background-color: #336699;");    //color de fondo
        
        Text title = new Text(" ");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        this.getChildren().add(title);
        
        
        this.stats = new Text[]{
            new Text(stringVida),
            new Text(stringAtaque),
            new Text(stringAlcance),
            new Text(stringVelocidad),
            new Text(stringCantMovsRestantes)};
        
        for (int i=0; i<this.stats.length; i++) {
            // Add offset to left side to indent from title
            VBox.setMargin(this.stats[i], new Insets(0, 0, 0, 8));
            this.getChildren().add(this.stats[i]);
        }
        
        EventHandler<ActionEvent> seleccionarPrimero = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	algoformerActual= algoformers.get(0);
              	actualizarStatsObjetivo(algoformerActual.getVida(), algoformerActual.getAtaque(), algoformerActual.getAlcance(), algoformerActual.getVelocidad_despl(), algoformerActual.getMovimientosRestantes());				
            }
        };

        EventHandler<ActionEvent> seleccionarSegundo = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	algoformerActual= algoformers.get(1);
              	actualizarStatsObjetivo(algoformerActual.getVida(), algoformerActual.getAtaque(), algoformerActual.getAlcance(), algoformerActual.getVelocidad_despl(), algoformerActual.getMovimientosRestantes());				
            }
        };
        
        EventHandler<ActionEvent> seleccionarTercero = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	algoformerActual= algoformers.get(2);
              	actualizarStatsObjetivo(algoformerActual.getVida(), algoformerActual.getAtaque(), algoformerActual.getAlcance(), algoformerActual.getVelocidad_despl(), algoformerActual.getMovimientosRestantes());				
            }
        };
        
        EventHandler<ActionEvent> botonTransformarHandler = new EventHandler<ActionEvent>() {
        	@Override
        	public void handle (ActionEvent event) {
        		algoformerActual.transformar();
        	}
    	};
    	
        EventHandler<ActionEvent> botonMoverNorteHandler = new EventHandler<ActionEvent>() {
        	@Override
        	public void handle (ActionEvent event) {
        		//algoformerActual.mover(algoformerActual.getUbicacion().);;
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

        Button transformar = new Button();
        transformar.setText("Transformar");
        transformar.setOnAction(botonTransformarHandler);
        
        Button moverNorte = new Button();
        moverNorte.setPrefSize(50, 10);
        moverNorte.setText("Norte");
        moverNorte.setOnAction(botonMoverNorteHandler);
        
        Button moverOeste = new Button();
        moverOeste.setPrefSize(50, 10);
        moverOeste.setText("Oeste");
//        moverOeste.setOnAction(botonMoverOesteHandler);
        
        Button moverSur = new Button();
        moverSur.setPrefSize(50, 10);
        moverSur.setText("Sur");
//        moverSur.setOnAction(botonMoverSurHandler);
        
        Button moverEste = new Button();
        moverEste.setPrefSize(50, 10);
        moverEste.setText("Este");
//        moverEste.setOnAction(botonMoverEsteHandler);

        HBox botonesParaMoverse = new HBox();
        botonesParaMoverse.getChildren().addAll(moverNorte, moverOeste, moverSur, moverEste);

        
        botonesParaSeleccionarLosAlgoformers.getChildren().addAll(primerAlgoformer, segundoAlgoformer, tercerAlgoformer);
        this.getChildren().addAll(botonesParaSeleccionarLosAlgoformers, transformar, botonesParaMoverse);

        actualizarStatsObjetivo(0, 0, 0, 0, 0);
    }
    
    public void actualizarStatsConCasillero(Casillero cas) {
    	if (cas.casilleroOcupado()){
    		Interactuable ocupante = cas.devolverElemento();
    		if (ocupante.estaVivo()){
    			Algoformer ocupanteA = (Algoformer) cas.devolverElemento(); 
    			actualizarStatsObjetivo(ocupanteA.getVida(), ocupanteA.getAtaque(), ocupanteA.getAlcance() , ocupanteA.getVelocidad_despl(), ocupanteA.getMovimientosRestantes());
    		}
    		
    	}
	}
    
    public void actualizarStatsObjetivo(int vida,int atk,int rng, int vel, int movsRes){   //esto en un futuro recibe un algoformerView o algo así
        this.stats[0].setText(stringVida+vida);
        this.stats[1].setText(stringAtaque+atk);
        this.stats[2].setText(stringAlcance+rng);
        this.stats[3].setText(stringVelocidad+vel);
        this.stats[4].setText(stringCantMovsRestantes+movsRes);
    }
    
    private void actualizarOrdenesDisponiblesObjetivo(){
        String BANDO_PRUEBA1 = "Autobots";
        String BANDO_PRUEBA2 = "Decepticons";
        String BANDO_PRUEBA = BANDO_PRUEBA1; //ir probando, puede ser null
        
        //BOTONES.setVisible(false);
        try{
            if (BANDO_PRUEBA.equals(BANDO_PRUEBA1)){
                BANDO_PRUEBA = BANDO_PRUEBA; //no hace nada
                //BOTONES.setVIsible(true);
            }
        }
        catch(NullPointerException casillero_vacio){}   //A reemplazar por CasilleroVacioException
        
    }
	
}