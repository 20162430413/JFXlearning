package lkj.jfx.day9;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import lkj.jfx.utils.StageUtils;

public class RadioButtonExe extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		AnchorPane ap = new AnchorPane();
		ap.setStyle("-fx-backtround-color: #FFFFFF");
		
		HBox hb = new HBox(10);
		
		// 一个组
		ToggleGroup tg = new ToggleGroup();
		
		RadioButton r1 = new RadioButton("r1");
		RadioButton r2 = new RadioButton("r2");
		RadioButton r3 = new RadioButton("r3");
		RadioButton r4 = new RadioButton("r4");
		// 设置所属组
		r1.setToggleGroup(tg);
		r2.setToggleGroup(tg);
		r3.setToggleGroup(tg);
		r4.setToggleGroup(tg);
		// 设置默认选择
		r2.setSelected(true);
		// 设置默认选择
		tg.selectToggle(r3);
		
		hb.getChildren().addAll(r1, r2, r3, r4);
		
		ap.getChildren().addAll(hb);
		AnchorPane.setTopAnchor(hb, 100.0);
		AnchorPane.setLeftAnchor(hb, 100.0);
		
		StageUtils.setStage(primaryStage, ap);
		
		// 切换选择时也会触发
		r1.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				System.out.println(newValue);
			}
		});
		
		tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				RadioButton r = (RadioButton)newValue;
				System.out.println(r.getText() + "-" + r.isSelected());
			}
			
		});
		
	}

}
