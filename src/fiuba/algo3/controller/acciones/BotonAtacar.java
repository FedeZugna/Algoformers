/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.acciones;

import controller.Master;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import model.Casillero;
import model.algoformers.Algoformer;

/**
 *
 * @author Martin
 */
public class BotonAtacar extends Button{
    private static final String TEXTO_ATACAR = "Atacar";
    
    
    public BotonAtacar(){
        super(TEXTO_ATACAR);
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               /* 
                Casillero casilleroObjetivo = Master.getInstancia().pedirObjetivo();
                Algoformer algofObjetivo = casilleroObjetivo.devolverElemento();
                Algoformer algofActual = Master.getInstancia().devolverAlgoformerActual();
                algofActual.atacar(algofObjetivo);
                Master.getInstancia().terminarTurno();
               */ 
            }
        });
    }
}

