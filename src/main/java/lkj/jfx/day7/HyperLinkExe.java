package lkj.jfx.day7;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lkj.jfx.utils.StageUtils;

public class HyperLinkExe extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		AnchorPane ap = new AnchorPane();
		
		// 构造方法里也可以放一个组件
		Hyperlink hl = new Hyperlink("www.baidu.com", new Button("点我"));
		
		hl.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// 使用javaFx的方式打开默认浏览器
				HostServices host = HyperLinkExe.this.getHostServices();
				host.showDocument(hl.getText());
			}
		});
		
		ap.getChildren().add(hl);

		StageUtils.setStage(primaryStage, ap);
		
	}

}
