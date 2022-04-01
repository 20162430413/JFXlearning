package lkj.jfx.utils;

import java.net.URL;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StageUtils {
	
	public static void setStage(Stage primaryStage, Pane pane) {
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		URL url = StageUtils.class.getResource("/icon/learning.png");
		primaryStage.getIcons().add(new Image(url.toExternalForm()));
		primaryStage.setTitle("JFXLearning");
		primaryStage.setWidth(500);
		primaryStage.setHeight(500);
		primaryStage.setX(0);
		primaryStage.setY(250);
		primaryStage.show();
	}

}
