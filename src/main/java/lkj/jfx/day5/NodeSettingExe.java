package lkj.jfx.day5;

import java.net.URL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NodeSettingExe extends Application {

	static boolean isManaged = false;
	static boolean isVisible = false;
	static double opacity = 0.0;
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Button b1 = new Button("b1");
		Button b2 = new Button("b2");
		Button b3 = new Button("b3");
		Button b4 = new Button("b4");
		
		Button b5 = new Button("b3.setManaged(isManaged)");
		Button b6 = new Button("b3.setVisible(isVisible");
		Button b7 = new Button("b3.setOpacity(opacity)");
		
		HBox hb = new HBox();
		hb.getChildren().addAll(b1, b2, b3, b4);
		hb.setPadding(new Insets(20));
		hb.setSpacing(10);
		
		VBox vb = new VBox();
		vb.getChildren().addAll(b5, b6, b7);
		
		
		AnchorPane ap = new AnchorPane();
		ap.setStyle("-fx-background-color: #ffff00");
		AnchorPane.setTopAnchor(vb, 100.0);
		AnchorPane.setLeftAnchor(vb, 20.0);
		ap.getChildren().addAll(hb, vb);
		
		Scene scene = new Scene(ap);
		primaryStage.setScene(scene);
		URL url = getClass().getResource("/icon/learning.png");
		primaryStage.getIcons().add(new Image(url.toExternalForm()));
		primaryStage.setTitle("JFXLearning");
		primaryStage.setWidth(500);
		primaryStage.setHeight(500);
		primaryStage.setX(0);
		primaryStage.setY(250);
		primaryStage.show();
		
		b5.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				isManaged = !isManaged;
				b3.setManaged(isManaged);
				b5.setText("b3 is managed = " + isManaged);
				Print.print(hb);
			}
		});
		
		b6.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				isVisible = !isVisible;
				b3.setVisible(isVisible);
				b6.setText("b3 is visible = " + isVisible);
				Print.print(hb);
			}
		});
		
		b7.setOnAction(new EventHandler<ActionEvent>() {
		
			@Override
			public void handle(ActionEvent event) {
				int i = (int) opacity;
				i ^= 1;
				System.out.println(i);
				opacity = (double) i;
				b3.setOpacity(opacity);
				b7.setText("b3's opacity = " + opacity);
				Print.print(hb);
			}
		});
		
	}

}

class Print{
	Print(HBox hb){
		
	}
	
	static void print(HBox hb) {
		System.out.println("当前HBox里的子组件数量 = " + hb.getChildren().size());
		
	}
}











