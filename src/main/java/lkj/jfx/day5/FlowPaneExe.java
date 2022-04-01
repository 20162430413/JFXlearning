package lkj.jfx.day5;

import java.net.URL;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * 流式布局，缩小窗口会自动排列子组件，可根据窗口的变化自动排列占满布局
 *
 */
public class FlowPaneExe extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Button b1 = new Button("button1");
		Button b2 = new Button("button2");
		Button b3 = new Button("button3");
		Button b4 = new Button("button4");
		Button b5 = new Button("button5");
		Button b6 = new Button("button6");
		
		FlowPane fp = new FlowPane();
		fp.getChildren().addAll(b1, b2, b3, b4, b5, b6);
		fp.setStyle("-fx-background-color: #EE6AA7");
		fp.setPadding(new Insets(10.0));
		
		// 会将所有的button都距上方20
		FlowPane.setMargin(b3, new Insets(20));
		fp.setAlignment(Pos.CENTER);
		// 子组件间的水平间距
		fp.setHgap(10);
		// 子组件的垂直间距
		fp.setVgap(10);
		// 排列的方向
		fp.setOrientation(Orientation.VERTICAL);
		
		Scene scene = new Scene(fp);
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
