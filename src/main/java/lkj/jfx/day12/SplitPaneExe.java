package lkj.jfx.day12;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import lkj.jfx.utils.StageUtils;

/**
 * 可调整大小的pane 
 *
 */
public class SplitPaneExe extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		AnchorPane ap = new AnchorPane();
		
		Button b1 = new Button("b1");
		Button b2 = new Button("b2");
		Button b3 = new Button("b3");
		Button b4 = new Button("b4");
		
		// sp不能直接放node，需要先放一个pane的才能调整大小
		SplitPane sp = new SplitPane();
		sp.setPrefWidth(300);
		sp.setPrefHeight(300);
		sp.setOrientation(Orientation.VERTICAL);
		// 指定第几个索引空间上的默认占比大小
		sp.setDividerPosition(0, 0.25);
		sp.setDividerPosition(1, 0.5);
		sp.setDividerPosition(2, 0.75);
		sp.setDividerPosition(3, 1.0);
		// 获得各个位置的占比大小
		sp.getDividerPositions();
		
		StackPane sp1 = new StackPane();
		sp1.setMinSize(100,100);
		sp1.getChildren().add(b1);
		
		StackPane sp2 = new StackPane();
		sp2.getChildren().add(b2);
		sp2.setStyle("-fx-background-color: #FFEE66");
		
		StackPane sp3 = new StackPane();
		sp3.getChildren().add(b3);
		
		StackPane sp4 = new StackPane();
		sp4.getChildren().add(b4);
		
		sp.getItems().addAll(sp1, sp2, sp3, sp4);
		
		
		ap.getChildren().addAll(sp);
		
		
		StageUtils.setStage(primaryStage, ap);
	}

}
