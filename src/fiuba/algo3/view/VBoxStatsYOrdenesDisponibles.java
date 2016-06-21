/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

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
    
    
    
    private Text stats[];
    
    public VBoxStatsYOrdenesDisponibles(){
        super();
        this.setPadding(new Insets(10));
        this.setSpacing(8);              // Gap between nodes
        this.setStyle("-fx-background-color: #336699;");    //color de fondo
        
        Text title = new Text("Data");
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