package lkj.jfx.day4;

import java.net.URL;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TextFieldExe extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {

		TextField text = new TextField();
		text.setLayoutX(100);
		text.setLayoutY(100);
		text.setPrefWidth(200);
		text.setPrefHeight(30);
		text.setFont(Font.font(14));
		
		Tooltip tip = new Tooltip("这是提示");
		text.setTooltip(tip);
		
		text.setPromptText("请输入信息");
		// 失去焦点
		text.setFocusTraversable(false);
		
		// 文本监听
		text.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				
				if (newValue.length() > 7) {
					text.setText(oldValue);
				}
				
			}
		});
		
		// 选中了几个字的事件
		text.selectedTextProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println(newValue);
			}
		});
		
		// 密码输入框
		PasswordField pst = new PasswordField();
		pst.setLayoutX(100);
		pst.setLayoutY(150);
		pst.setPrefWidth(200);
		pst.setPrefHeight(30);
		pst.setFont(Font.font(14));
		pst.setPromptText("请输入密码");
		
		// 标签
		Label label = new Label("我是标签");
		label.setLayoutX(100);
		label.setLayoutY(200);
		label.setPrefWidth(200);
		
		// text、psswordtext也可以设置
		label.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				System.out.println(event.getSource());
				
			}
		});
		
		
		
		Group group = new Group();
		group.getChildren().addAll(text, pst, label);
		Scene scene = new Scene(group);
		

		URL png = getClass().getResource("/icon/learning.png");
		primaryStage.getIcons().add(new Image(png.toExternalForm()));
		primaryStage.setScene(scene);
		primaryStage.setHeight(500);
		primaryStage.setWidth(500);
		primaryStage.setX(0);
		primaryStage.show();
		
	}
	

}
