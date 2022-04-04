package lkj.jfx.day8;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lkj.jfx.utils.StageUtils;

public class MenuFeatureExe extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		AnchorPane ap = new AnchorPane();
		MenuBar mb = new MenuBar();
		Menu menu1 = new Menu("分割线");
		Menu menu2 = new Menu("单选框");
		Menu menu3 = new Menu("多选框");
		Menu menu4 = new Menu("禁用选项");
		Menu menu5 = new Menu("二级菜单");
		
		// 菜单选项分割器
		SeparatorMenuItem sp1 = new SeparatorMenuItem();
		SeparatorMenuItem sp2 = new SeparatorMenuItem();
		
		MenuItem item1 = new MenuItem("MenuItem1");
		MenuItem item2 = new MenuItem("MenuItem2");
		MenuItem item3 = new MenuItem("MenuItem3");
		MenuItem item4 = new MenuItem("MenuItem4");
		MenuItem item5 = new MenuItem("MenuItem5");
		MenuItem item6 = new MenuItem("MenuItem6");
		MenuItem item7 = new MenuItem("MenuItem7");
		
		item3.setVisible(false);
		item7.setDisable(true);
		
		
		// 单选组
		ToggleGroup tg = new ToggleGroup();
		// 单选菜单
		RadioMenuItem  rmi1 = new RadioMenuItem("RadioMenuItem1");
		RadioMenuItem  rmi2 = new RadioMenuItem("RadioMenuItem2");
		RadioMenuItem  rmi3 = new RadioMenuItem("RadioMenuItem3");
		rmi1.setToggleGroup(tg);
		rmi2.setToggleGroup(tg);
		rmi3.setToggleGroup(tg);
		
		// 多选框
		CheckMenuItem cmi1 = new CheckMenuItem("CheckMenuItem1");
		CheckMenuItem cmi2 = new CheckMenuItem("CheckMenuItem2");
		CheckMenuItem cmi3 = new CheckMenuItem("CheckMenuItem3");
		
		//默认选中
		rmi1.setSelected(true);
		
		
		mb.getMenus().addAll(menu1, menu2, menu3, menu4);
		menu1.getItems().addAll(item1, item2, sp1, menu5, item3, sp2, item4);
		menu2.getItems().addAll(rmi1, rmi2, rmi3);
		menu3.getItems().addAll(cmi1, cmi2, cmi3);
		menu4.getItems().add(item7);
		menu5.getItems().addAll(item5,item6);
		
		ap.getChildren().add(mb);
		mb.setPrefWidth(primaryStage.getWidth());
		
		
		
		
		// menubar宽度随窗口自动变化
		ap.widthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				mb.setPrefWidth(newValue.doubleValue());
			}
		});
		
		rmi1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				RadioMenuItem item = (RadioMenuItem) event.getSource();
				System.out.println(item.getText() + "当前选中状态" + item.isSelected());
			}
		});
		StageUtils.setStage(primaryStage, ap);
	}

}
