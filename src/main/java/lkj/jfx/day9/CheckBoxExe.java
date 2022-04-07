package lkj.jfx.day9;



import java.util.Iterator;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import lkj.jfx.utils.StageUtils;

/**
 * 多选，有三种状态，选中、未选中、不确定
 * 不确定状态又分两种状态：是不确定状态、不是不确定状态
 *
 */
public class CheckBoxExe extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		AnchorPane ap = new AnchorPane();
		ap.setStyle("-fx-backtround-color: #FFFFFF");
		
		HBox hb = new HBox(10);
		
		CheckBox c1 = new CheckBox("c1");
		CheckBox c2 = new CheckBox("c2");
		CheckBox c3 = new CheckBox("c3");
		CheckBox c4 = new CheckBox("c4");
		
		// 设置默认选中
		c1.setSelected(true);
		// 设置c2初始状态为不确定状态
		c2.setIndeterminate(true);
		// 设置是否可以出现不确定状态
		c3.setAllowIndeterminate(true);
		
		hb.getChildren().addAll(c1, c2, c3, c4);
		
		ap.getChildren().addAll(hb);
		AnchorPane.setTopAnchor(hb, 100.0);
		AnchorPane.setLeftAnchor(hb, 100.0);
		
		StageUtils.setStage(primaryStage, ap);
		
		c1.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				System.out.println(newValue);
			}
		});
		
		// 获取所有checkbox的状态，从HBox里拿比较方便
		ap.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				Iterator<Node> o = hb.getChildren().iterator();
				// 迭代器的使用
				while(o.hasNext()) {
					CheckBox next = (CheckBox)o.next();
					System.out.println(next.getText() + "-" + next.isSelected() +", 不确定状态为："+ next.isIndeterminate());
				}
			}
		});
	}

}
