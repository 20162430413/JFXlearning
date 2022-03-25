package lkj.jfx.day4;

import java.net.URL;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AnchorPaneExe extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		Button b1 = new Button("b1");
		Button b2 = new Button("b2");
		
		// group其实并不算是布局类，只是一个简单的容器
		Group group = new Group();
		
		// Anchor：类似于绝对布局，锚点的意思，只能管理子组件，不能管理子组件的子组件
		AnchorPane ap = new AnchorPane();
		ap.getChildren().addAll(b1, b2);
		
		// 设置目标节点距离对应位置对应距离，会覆盖节点设置的坐标
		// 表明距离父控件的距离，父控件是AnchorPane，不是窗体
		ap.setTopAnchor(b1, 10.0);
		ap.setLeftAnchor(b1, 10.0);
		// 设置的节点会自动适应父组件
		ap.setBottomAnchor(b1, 10.0);
		ap.setRightAnchor(b1, 10.0);
		
		// 设置内边距padding时，需要和setXXAnchor配合使用，不然会没有效果，距离是两者相加
		ap.setPadding(new Insets(30));
		
		
		ap.setTopAnchor(b2, 10.0);
		ap.setLeftAnchor(b2, 60.0);
		
		ap.setStyle("-fx-background-color: #FF3E96");
		ap.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				System.out.println("ap clicked");
				
			}
		});
		

		Button b3 = new Button("b3");
		AnchorPane ap2 = new AnchorPane();
		ap2.setStyle("-fx-background-color: #00FF00");
		ap2.getChildren().add(b3);
		ap2.setRightAnchor(b3, 0.0);
		ap2.setBottomAnchor(b3, 0.0);
		
		// setManged表示该节点不受父节点的管理，并且在这个位置消失，其他组件可以占用这个位置
		//b3.setManaged(false);
		// setVisible是否可见，其他组件不可以占用这个位置
		//b3.setVisible(true);
		// 设置透明度
		//b3.setOpacity(1);
		
		ap.getChildren().add(ap2);
		
		
		
		
		Scene scene = new Scene(ap);
		URL png = getClass().getResource("/icon/learning.png");
		primaryStage.getIcons().add(new Image(png.toExternalForm()));
		primaryStage.setScene(scene);
		primaryStage.setHeight(500);
		primaryStage.setWidth(500);
		primaryStage.setX(0);
		primaryStage.show();
		
		// ap的宽度和高度只有在调用了 primaryStage.show();方法之后才能获得值
		// 此处只赋值了一次
		ap.setTopAnchor(ap2, ap.getWidth() / 2);
		ap.setLeftAnchor(ap2, ap.getHeight() / 2);
		ap.setRightAnchor(ap2, 0.0);
		ap.setBottomAnchor(ap2, 0.0);
		
	}

}
