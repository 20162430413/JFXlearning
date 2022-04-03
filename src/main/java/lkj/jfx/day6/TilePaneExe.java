package lkj.jfx.day6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import lkj.jfx.utils.StageUtils;

/**
 * tile: 瓦片、瓷砖，组件会自动整齐排列，占用相同范围大小的空间
 * 
 */
public class TilePaneExe extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {

		Button b1 = new Button("button1");
		Button b2 = new Button("button2");
		Button b3 = new Button("button3");
		Button b4 = new Button("button4");
		Button b5 = new Button("button5");
		Button b6 = new Button("button5");
		Button b7 = new Button("button6");
		Button b8 = new Button("button7");
		
		TilePane tp = new TilePane();
		tp.setStyle("-fx-background-color: #EE6AA7");
		tp.getChildren().addAll(b1, b2, b3, b4, b5, b6, b7, b8);
		
		// 水平间距
		tp.setHgap(10);
		// 垂直间距
		tp.setVgap(10);
		
		tp.setPadding(new Insets(10));
		tp.setAlignment(Pos.CENTER);
		
		// 外边距的设置会应用到所有的子组件中，所有的子组件都会占据相同的范围空间，组件排列会更加整齐
		TilePane.setMargin(b1, new Insets(50));
		
		StageUtils.setStage(primaryStage, tp);
	}

	
	
	
	
	
	
	
	
	
	
}
