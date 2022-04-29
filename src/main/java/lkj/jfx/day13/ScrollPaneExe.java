package lkj.jfx.day13;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lkj.jfx.utils.StageUtils;

/**
 * 滚动面板 练习
 *
 */
public class ScrollPaneExe extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		AnchorPane ap = new AnchorPane();
		VBox box = new VBox(10);
		Button btn = new Button("开始滚");
		
		HBox hb = new HBox(10);
		
		for(int i=0; i<10; i++) {
			hb.getChildren().add(new Button("b" + i));
		}
		
		VBox vb = new VBox(10);
		
		for(int i=0; i<10; i++) {
			vb.getChildren().add(new Button("b" + i));
		}
		
		box.getChildren().addAll(vb, hb);
		
		ScrollPane scp = new ScrollPane();
		scp.setPrefWidth(300);
		scp.setPrefHeight(300);
		scp.setContent(box);

		
		ap.getChildren().addAll(btn, scp);
		AnchorPane.setLeftAnchor(btn, 200.0);
		AnchorPane.setTopAnchor(scp, 50.0);
		StageUtils.setStage(primaryStage, ap);
		
		// 设置水平滚动监听
		scp.hvalueProperty().addListener(new ChangeListener<Number>() {

			// 打印 0.几 表示为移动的百分比
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println(newValue);
			}
			
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
