package lkj.jfx.day3;

import java.net.URL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.Mnemonic;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ButtonExe extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Button b1 = new Button();
		b1.setText("第一个按钮");
		b1.setFont(Font.font("sans-serif", 14));
		b1.setTextFill(Paint.valueOf("#CD0000"));
		b1.setPrefHeight(100);
		b1.setPrefWidth(300);
		b1.setLayoutY(50);
		b1.setLayoutX(50);

		// 设置背景格式：颜色、圆角、距离边框的距离。#8FBC8F00（最后两位是透明度）
		BackgroundFill bgf = new BackgroundFill(Paint.valueOf("#8FBC8F"), new CornerRadii(5), new Insets(10, 20, 10, 20));
		Background bg = new Background(bgf);
		b1.setBackground(bg);
		BorderStroke bos = new BorderStroke(Paint.valueOf("#8A2BE2"), BorderStrokeStyle.DOTTED, new CornerRadii(20), new BorderWidths(5));
		Border bo = new Border(bos);
		b1.setBorder(bo);

		// 支持使用CSS的样式进行配置，通过搜索 javafx css 官网进行查看样例编写
		Button b2 = new Button();
		b2.setText("第二个按钮");
		b2.setFont(Font.font("sans-serif", 14));
		b2.setTextFill(Paint.valueOf("#CD0000"));
		b2.setPrefHeight(100);
		b2.setPrefWidth(300);
		b2.setLayoutY(250);
		b2.setLayoutX(50);
		b2.setStyle("-fx-background-color: #7CCD7C; " + "-fx-background-radius: 20;" + "-fx-text-fill: #5CACEE");

		// 单击监听事件
		b2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				// 获取事件源，返回button本身
				Button b = (Button) event.getSource();
				
				System.out.println(b.getText());
				
			}
		});

		// 设置双击事件，eventhandler是事件子类往父类进行传递，eventfilter是事件父类往子类传递
		b2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				
				if (event.getClickCount() == 2 && event.getButton().name().equals(MouseButton.PRIMARY.name())) {
					
					System.out.println("当前鼠标案件：" + event.getButton().name());
					
					System.out.println("b2 的双击事件");
				}
			}
		});

		// 键盘事件监听
		b2.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				
				System.out.println("key：" + event.getCode().name() + "按下");
				
			}
		});
		b2.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				
				System.out.println("key：" + event.getCode().name() + "释放");
				
			}
		});
		
		
		Group group = new Group();
		
		group.getChildren().add(b1);
		
		group.getChildren().add(b2);
		
		
		Scene scene = new Scene(group);
		
		// 设置组合快捷键，需要通过scene设置，中间绑定对象Mnemonic，不定参数
		// 第一种，有些平台兼容性不好，第二种兼容性最好
		KeyCombination kc1 = new KeyCodeCombination(KeyCode.C, KeyCombination.ALT_DOWN, KeyCombination.CONTROL_DOWN);
		Mnemonic m1 = new Mnemonic(b2, kc1);
		scene.addMnemonic(m1);
		
		
		// 第二种，Shortcut+C == Ctrl+C（on Windows） 或者 Meta+C（on Mac）
		KeyCombination kc2 = new KeyCodeCombination(KeyCode.Y, KeyCodeCombination.SHORTCUT_DOWN);
		scene.getAccelerators().put(kc2, new Runnable() { // 并没有新开一个线程进行处理
			
			@Override
			public void run() {
				
				System.out.println("run 方法执行" + Thread.currentThread().getName());
				
				b2.fire(); // 涉及到关系事件的问题
			}
		});
		
		// 第三种、第四种省略没写，不常用，可以查阅手册
		// 第五种
		KeyCombination kc = KeyCombination.valueOf("ctrl+r");
		Mnemonic m2 = new Mnemonic(b2, kc);
		scene.addMnemonic(m2);
		
		primaryStage.setScene(scene);
		primaryStage.setHeight(500);
		primaryStage.setWidth(500);
		primaryStage.setX(0);
		primaryStage.setTitle("JavaFx learning");
		URL png = getClass().getResource("/icon/learning.png");
		primaryStage.getIcons().add(new Image(png.toExternalForm()));
		primaryStage.show();

	}

}
