package lkj.jfx.day6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import lkj.jfx.utils.StageUtils;

/**
 * 图层的概念，有上下层覆盖的一个概念，类似栈
 *
 */
public class StackPaneExe extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Button b1 = new Button("button1");
		Button b2 = new Button("button2");
		Button b3 = new Button("button3");
		Button b4 = new Button("button4");
		Button b5 = new Button("button5");
		
		StackPane sp = new StackPane();
		sp.setStyle("-fx-background-color: #EE6AA7");
		sp.getChildren().addAll(b1, b2, b3, b4, b5);
		
		sp.setAlignment(Pos.BOTTOM_LEFT);
		
		sp.setPadding(new Insets(10.0));
		StackPane.setMargin(b1, new Insets(50));
		
		sp.getChildren().forEach((e)->{
			System.out.println(((Button)e).getText());
		});
		
		StageUtils.setStage(primaryStage, sp);
		
	}

}
