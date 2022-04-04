package lkj.jfx.day8;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import lkj.jfx.utils.StageUtils;

/**
 * 自定义菜单
 *
 */
public class CustomMenuExe extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane ap = new AnchorPane();
		MenuBar mb = new MenuBar();
		Menu menu1 = new Menu("自定义菜单");
		Menu menu2 = new Menu("menu2");
		Menu menu3 = new Menu("menu3");
		
		MenuItem item1 = new MenuItem("MenuItem1");
		MenuItem item2 = new MenuItem("你好");
		MenuItem item3 = new MenuItem("右键菜单");
		MenuItem item4 = new MenuItem("其它选项");
		
		// 自定义菜单
		CustomMenuItem cm1 = new CustomMenuItem();
		Button b1 = new Button("custom item");
		cm1.setContent(b1);
		// 进度条
		CustomMenuItem cm2 = new CustomMenuItem();
		ProgressBar pb = new ProgressBar(0.5);
		cm2.setContent(pb);
		// 放一个布局
		CustomMenuItem cm3 = new CustomMenuItem();
		HBox hb = new HBox();
		hb.setPrefWidth(300);
		hb.setPrefHeight(100);
		hb.setStyle("-fx-background-color: #EECC33");
		hb.getChildren().addAll(new Button("b2"), new Button("b3"));
		cm3.setContent(hb);

		menu1.getItems().addAll(item1, cm1 ,cm2, cm3);
		
		// 菜单按钮
		MenuButton mbtn = new MenuButton("请选择");
		AnchorPane.setTopAnchor(mbtn, 200.0);
		mbtn.getItems().addAll(item2);
		mbtn.setPrefWidth(80);
		item2.setAccelerator(KeyCombination.valueOf("ctrl+/"));
		
		// 带有分割线的菜单按钮
		SplitMenuButton smb = new SplitMenuButton();
		AnchorPane.setTopAnchor(smb, 200.0);
		AnchorPane.setLeftAnchor(smb, 200.0);
		smb.getItems().addAll(item4);
		smb.setPrefWidth(80);
		smb.setText("确定");
		
		// 右键菜单
		Button cxtmbtn = new Button("cxtmbtn");
		ContextMenu cxtm = new ContextMenu();
		cxtm.getItems().addAll(item3);
		cxtmbtn.setContextMenu(cxtm);
		AnchorPane.setTopAnchor(cxtmbtn, 100.0);
		
		mb.getMenus().addAll(menu1, menu2, menu3);
		mb.setPrefWidth(primaryStage.getWidth());
		
		ap.getChildren().addAll(mb, mbtn, smb, cxtmbtn);
		
		// menubar宽度随窗口自动变化
		ap.widthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				mb.setPrefWidth(newValue.doubleValue());
			}
		});
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				mbtn.setText(((MenuItem)event.getSource()).getText());
				
			}
		});
		
		// 监听快捷键调用时的事件，快捷键触发时同时也触发单击事件
		item2.setOnMenuValidation(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				System.out.println("item4.setOnMenuValidation");
			}
		});
		
		// 当按钮的右键菜单触发时会触发
		cxtmbtn.setOnContextMenuRequested(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				System.out.println("cxtmbtn.setOnContextMenuRequested");
			}
		});
		
		StageUtils.setStage(primaryStage, ap);
	}

}
