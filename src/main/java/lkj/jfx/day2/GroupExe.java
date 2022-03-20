package lkj.jfx.day2;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class GroupExe extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Button b1 = new Button("b1");
		Button b2 = new Button("b2");
		Button b3 = new Button("b3");
		
		b1.setLayoutX(0);
		b1.setLayoutY(10);
		
		b1.setPrefWidth(50);
		b1.setPrefHeight(30);
		
		b2.setLayoutX(200);
		b2.setLayoutY(10);
		
		b3.setLayoutX(400);
		b3.setLayoutY(10);
		
		Group group = new Group();
		group.getChildren().addAll(b1, b2, b3);
		
		// 清除节点
//		group.getChildren().remove(0);
//		group.getChildren().clear();
		
		// group组设置的透明度会对其所有的子节点生效
		group.setOpacity(0.5);
		
		group.getChildren().addListener(new ListChangeListener<Node>() {

			public void onChanged(Change<? extends Node> c) {
				System.out.println("当前子节点数量：" + c.getList().size());
			}
			
		});
		
		b1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				group.getChildren().add(new Button("bu8"));
						
			}
		});
		
		
		
		
		Scene scene = new Scene(group);
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("learn FX");
		primaryStage.setHeight(800);
		primaryStage.setWidth(800);
		primaryStage.getIcons().add(new Image(getClass().getResource("/icon/learning.png").toExternalForm()));
		
		
		
		primaryStage.show();
		
	}

}
