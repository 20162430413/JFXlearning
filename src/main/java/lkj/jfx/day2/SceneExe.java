package lkj.jfx.day2;

import java.net.URL;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SceneExe extends Application {

	/**
	 * stage包含scene，scene上放node，node类基本上是所有组件的父类，泛指所有组件
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Button b = new Button("按钮");
		b.setCursor(Cursor.MOVE);
		b.setPrefWidth(100);
		b.setPrefHeight(50);
		
		// 布局类用来排列组件的类
		Group group = new Group();
		group.getChildren().add(b);
		
		// 放到scene上的node，如果是一个根节点，默认都会铺满这个scene的范围
		Scene scene = new Scene(group);
		
		// 设置范围内鼠标的展示形式
//		scene.setCursor(Cursor.CLOSED_HAND);
		URL png = getClass().getResource("/icon/learning.png");
		scene.setCursor(Cursor.cursor(png.toExternalForm()));
		
		// 打开一个网页
		HostServices host = getHostServices();
		host.showDocument("www.baidu.com");
		
		
		primaryStage.setScene(scene);
		
		primaryStage.setWidth(500);
		primaryStage.setHeight(500);
		primaryStage.show();
	}

}
