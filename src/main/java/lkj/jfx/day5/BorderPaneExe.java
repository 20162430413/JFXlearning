package lkj.jfx.day5;

import java.net.URL;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * 方位布局：上、下、左、右、中间，其中每个方位还可以放其他的布局
 * 当四周的方位布局中的布局没有设置宽高的话，中间的布局会占据该没有宽高的布局
 *
 */
public class BorderPaneExe extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		AnchorPane a1 = new AnchorPane();
		a1.setPrefHeight(100);
		a1.setPrefWidth(100);
		a1.setStyle("-fx-background-color: #EE6AA7");
		AnchorPane a2 = new AnchorPane();
		a2.setPrefHeight(100);
		a2.setPrefWidth(100);
		a2.setStyle("-fx-background-color: #98FB98");
		AnchorPane a3 = new AnchorPane();
		a3.setPrefHeight(100);
		a3.setPrefWidth(100);
		a3.setStyle("-fx-background-color: #A0522D");
		AnchorPane a4 = new AnchorPane();
		a4.setPrefHeight(100);
		a4.setPrefWidth(100);
		a4.setStyle("-fx-background-color: #f00f00");
		AnchorPane a5 = new AnchorPane();
		a5.setPrefHeight(100);
		a5.setPrefWidth(100);
		a5.setStyle("-fx-background-color: #1E90FF");
		
		BorderPane bp = new BorderPane();
		bp.setTop(a1);
		bp.setBottom(a2);
		bp.setRight(a3);
		bp.setLeft(a4);
//		bp.setCenter(a5);
		Button b = new Button("button");
		bp.setCenter(b);
		bp.setStyle("-fx-background-color: #E40278");
		
		bp.setPadding(new Insets(10.0));
		bp.setMargin(a1, new Insets(10.0));
		// 对齐方式
		bp.setAlignment(b, Pos.CENTER);
		
		Button bb = (Button)bp.getCenter();
		System.out.println(bb.getText());
		
		
		Scene scene = new Scene(bp);
		primaryStage.setScene(scene);
		URL url = getClass().getResource("/icon/learning.png");
		primaryStage.getIcons().add(new Image(url.toExternalForm()));
		primaryStage.setTitle("JFXLearning");
		primaryStage.setWidth(500);
		primaryStage.setHeight(500);
		primaryStage.setX(0);
		primaryStage.setY(250);
		primaryStage.show();
		
	}

}
