package lkj.jfx.day4;

import java.net.URL;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * HBox：自动水平布局
 * VBox：自动垂直布局
 */
public class HBoxAndVBoxExe extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Button b1 = new Button("b1");
		Button b2 = new Button("b2");
		Button b3 = new Button("b3");
		
		AnchorPane ap = new AnchorPane();
		ap.setStyle("-fx-background-color: #AEEEEE");
		
		HBox hbox = new HBox();
		hbox.setPrefHeight(300);
		hbox.setPrefWidth(300);
		hbox.setStyle("-fx-background-color: #E066FF");
		
		// 设置自己的内边距
		hbox.setPadding(new Insets(10.0));
		// 设置自己内部的子组件间的间距
		hbox.setSpacing(10);
		// 设置指定子组件的外边距
		HBox.setMargin(b1, new Insets(10));
		// 设置对其方式
		hbox.setAlignment(Pos.BOTTOM_CENTER);
		
		// 会自动排列到一排
		hbox.getChildren().addAll(b1, b2, b3);
		
		ap.getChildren().add(hbox);
		
		Scene scene = new Scene(ap);
		URL png = getClass().getResource("/icon/learning.png");
		primaryStage.getIcons().add(new Image(png.toExternalForm()));
		primaryStage.setScene(scene);
		primaryStage.setHeight(500);
		primaryStage.setWidth(500);
		primaryStage.setX(0);
		primaryStage.show();
	}

}
