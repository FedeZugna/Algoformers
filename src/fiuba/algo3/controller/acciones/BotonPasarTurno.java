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

/**
 *
 * @author Martin
 */
public class BotonPasarTurno extends Button{
    private static final String TEXTO_PASAR_TURNO = "Pasar Turno";
    
    
    public BotonPasarTurno(){
        super(TEXTO_PASAR_TURNO);
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                Master.getInstancia().terminarTurno();
            }
        });
    }
}

