package lkj.jfx.day10;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lkj.jfx.utils.StageUtils;

/**
 * 下拉列表联动
 *
 */
public class ChoiceBoxLinkActionExe extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {

		// 获取一个可观察的list
		ObservableList<String> list1 = FXCollections.observableArrayList();
		ObservableList<Object> list2 = FXCollections.observableArrayList();
		ObservableList<Object> list3 = FXCollections.observableArrayList();
		list1.addAll("数字", "字母");
		list2.addAll(1,2,3,4,5,6);
		list3.addAll('A', 'B', 'C');
		
		AnchorPane ap = new AnchorPane();

		ChoiceBox<String> cb1 = new ChoiceBox<>();
		ChoiceBox<Object> cb2 = new ChoiceBox<>();

		cb1.setItems(list1);
		
		cb1.setPrefWidth(100);
		cb2.setPrefWidth(100);
		
		ap.getChildren().addAll(cb1, cb2);
		AnchorPane.setTopAnchor(cb1, 100.0);
		AnchorPane.setLeftAnchor(cb1, 50.0);
		AnchorPane.setTopAnchor(cb2, 100.0);
		AnchorPane.setLeftAnchor(cb2, 200.0);
		StageUtils.setStage(primaryStage, ap);
		
		// 选择值触发事件
		cb1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				switch(newValue) {
					case "字母":cb2.setItems(list2);break;
					case "数字":cb2.setItems(list3);break;
				}
				cb2.getSelectionModel().select(0);
				cb2.show();
			}
		});
	}

}











