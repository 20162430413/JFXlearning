package lkj.jfx.day1;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class FxLaunchDay1 extends Application{
	
	@Override
	public void start(@SuppressWarnings("exports") Stage primaryStage) {
		
		System.out.println("开始start");
		
		// Stage: 窗口对象
		
		primaryStage.setTitle("Learning");
		
//		primaryStage.getIcons().add(new Image(this.getClass().getClassLoader().getResourceAsStream("./icon/learning.png")));
		
		primaryStage.setMaximized(false); // 设置窗口最大化
		
		primaryStage.setWidth(500);
		
		primaryStage.setHeight(500);
		
		primaryStage.setResizable(true); // 是否可以调整窗口大小
		
//		primaryStage.close(); // 关闭窗口
		
		// 设置监听
		primaryStage.heightProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println("height: " + newValue.doubleValue());
				
			}
		});
		
		// 设置全屏，需要设置一个scene场景，在场景上进行内容的展示
		primaryStage.setFullScreen(false);
		primaryStage.setScene(new Scene(new Group()));
		
		primaryStage.show();
	}

	@Override
	public void init() throws Exception {
		System.out.println("init");
	}

	@Override
	public void stop() throws Exception {
		System.out.println("stop");
	}
	
}
