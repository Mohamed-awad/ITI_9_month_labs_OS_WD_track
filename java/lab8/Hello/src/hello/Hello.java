package hello;


import java.util.Vector;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Hello extends Application{

	public Hello() {
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Text tt = new Text("Hello World");
		
		tt.setId("tt");
		
		Reflection r = new Reflection();
		
		r.setFraction(0.7f); 
		tt.setEffect(r);
		tt.setTranslateY(30);
		
		Rectangle rr = new Rectangle();
		
		rr.setId("rr");
		rr.setWidth(450);
		rr.setHeight(450);
		
		Vector<Stop> stops= new Vector<>();
		
		stops.add(new Stop(0.1f, Color.rgb(0, 0, 0, 1)));
		stops.add(new Stop(.6f, Color.rgb(255, 255, 255, 1)));
		stops.add(new Stop(1.0f, Color.rgb(0, 0, 0, 1)));
		LinearGradient linearGrad = new LinearGradient(0, 0, 450, 450, false,CycleMethod.NO_CYCLE,  stops);

		rr.setFill(linearGrad);
		
		StackPane root_pane = new StackPane(rr, tt);
		Scene scene = new Scene(root_pane, 500, 500);
		scene.getStylesheets().add(getClass().getResource("st.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.show();	
	}
	
	public static void main(String [] args) {
		Application.launch(args);
	}

}
