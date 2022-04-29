package lkj.jfx.day13;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import lkj.jfx.utils.StageUtils;

/**
 * 分割线 练习，无法设置颜色，可以使用2D图形设置
 *
 */
public class SeparatorExe extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane ap = new AnchorPane();
		Button b1 = new Button("b1");
		Button b2 = new Button("b2");
		Separator sep = new Separator();
		
		HBox hb = new HBox(10);		
		hb.getChildren().addAll(b1, sep, b2);
		
		sep.setPrefWidth(300);
		sep.setPrefHeight(300);
		sep.setOrientation(Orientation.VERTICAL);
		// 水平布局，居中
		sep.setHalignment(HPos.CENTER);
		// 垂直布局，居中
		sep.setValignment(VPos.BOTTOM);
		
		AnchorPane.setTopAnchor(hb, 50.0);
		ap.getChildren().addAll(hb);
		StageUtils.setStage(primaryStage, ap);
	}

}
