package lkj.jfx.day13;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lkj.jfx.utils.StageUtils;

/**
 * 滚动条、滚动布局、分割线练习
 *
 */
public class ScrollBarExe extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		AnchorPane ap = new AnchorPane();
		Button btn = new Button("开始滚");
		
		VBox vb = new VBox(10);
		
		for(int i=0; i<10; i++) {
			vb.getChildren().add(new Button("b" + i));
		}
			
		ScrollBar scb = new ScrollBar();
		scb.setOrientation(Orientation.VERTICAL);
		
		// 设置滚动条内部的水珠的长度
		scb.setVisibleAmount(50);
		// 设置初始位置
		scb.setValue(20);
		
		scb.valueProperty().addListener(new ChangeListener<Number>() {
			
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
			  System.out.println(newValue);
			  vb.setLayoutY(-newValue.doubleValue());
			}
			
		});
		
		ap.getChildren().addAll(scb, vb, btn);
		AnchorPane.setLeftAnchor(scb, 100.0);
		AnchorPane.setLeftAnchor(btn, 200.0);
		StageUtils.setStage(primaryStage, ap);
		
		// 获取组件高度和宽度的时候需要在 stage.show()方法之后才有值
		scb.setPrefHeight(vb.getHeight());
		// 默认可拖到的最大的值为100，最小值为0
		scb.setMax(vb.getHeight());
		// 设置每次触发动作时移动的步长
		scb.setUnitIncrement(10);
		// 设置每一次点击时移动的步长
		scb.setBlockIncrement(30);
		
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// 滚动条增加值
				scb.increment();
				// 滚动条减小值
//				scb.decrement();
			}
			
		});
		
	}

}
