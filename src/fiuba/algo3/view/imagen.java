package view;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Juego;
import view.eventos.AplicacionOnKeyPressEventHandler;

public class imagen extends Application{
	
	public static void main(String[] args) 
    {
        launch(args);
    }
	
	public void start(Stage stage) {
        stage.setTitle("Algoformers");

        Juego juego = new Juego();
        juego.inicializarTablero();
        
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, juego);
        Scene escenaJuego = new Scene(contenedorPrincipal, 640, 480);

        AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
        escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);

        
        
        stage.setScene(escenaBienvenidos);
        stage.show();
	}
}
//stage.setOnCloseRequest()
	
	
	/*public void start(Stage theStage) 
	{
	    theStage.setTitle( "Canvas Example" );
	         
	    Group root = new Group();
	    Scene theScene = new Scene( root );
	    theStage.setScene( theScene );
	         
	    Canvas canvas = new Canvas( 400, 200 );
	    root.getChildren().add( canvas );
	         
	    GraphicsContext gc = canvas.getGraphicsContext2D();
	         
	    gc.setFill( Color.RED );
	    gc.setStroke( Color.BLACK );
	    gc.setLineWidth(2);
	    Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 48 );
	    gc.setFont( theFont );
	    gc.fillText( "Hello, World!", 60, 50 );
	    gc.strokeText( "Hello, World!", 60, 50 );
	     
	    Image earth = new Image( "optimus.jpeg" );
	    gc.drawImage( earth, 180, 100 );
	         
	    theStage.show();
	}*/