package lkj.jfx.day9;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import lkj.jfx.utils.ImageUtils;
import lkj.jfx.utils.StageUtils;

/**
 * 并不是传统的布局类
 *
 */
public class TitlePaneExe extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane ap = new AnchorPane();
		
		// 也可以给button设置图片
		TitledPane tp1 = new TitledPane("titledPane1", new Button("button1", ImageUtils.getImage("/icon/learning.png", 20, 20)));
		// 设置默认是否打开
		tp1.setExpanded(true);
		// 是否打开展开动画，默认为true
		tp1.setAnimated(true);
		// 是否可折叠，默认为true
		tp1.setCollapsible(true);
		// 控制箭头的方向：从左到右，从右到左
		tp1.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
		
		
		TitledPane tp2 = new TitledPane();
		tp2.setText("titledpane2");
		tp2.setContent(new Button("button2"));
		
		HBox hb = new HBox();
		hb.setStyle("-fx-background-color: #FFB5C5");
		hb.getChildren().addAll(new Button("button3"), new Button("button4"), new Button("button5"));

		TitledPane tp3 = new TitledPane();
		tp3.setText("titledpane3");
		tp3.setContent(hb);
		
		// 可以添加一个图片
		tp3.setGraphic(ImageUtils.getImage("/icon/learning.png",20,20));
		
		ap.getChildren().addAll(tp1, tp2, tp3);
		AnchorPane.setTopAnchor(tp2, 200.0);
		AnchorPane.setLeftAnchor(tp3, 100.0);
		
		
		StageUtils.setStage(primaryStage, ap);
		
		tp1.expandedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				System.out.println("newValue： " + newValue);
				
			}
			
		});
		
	}

}
