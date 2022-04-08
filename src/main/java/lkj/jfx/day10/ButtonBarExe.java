package lkj.jfx.day10;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lkj.jfx.utils.StageUtils;

/**
 * 一条button布局，其实也HBox是一样的道理，默认会以最大的按钮安排其他按钮的布局
 *
 */
public class ButtonBarExe extends Application implements EventHandler<ActionEvent>{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		AnchorPane ap = new AnchorPane();
		
		ButtonBar br = new ButtonBar();
		
		Button b1 = new Button("b1");
		Button b2 = new Button("b2");
		Button b3 = new Button("b3");
		
		// 给按钮添加标签，标签可以用来区别是哪个标签的按钮触发的事件
		ButtonBar.setButtonData(b1, ButtonData.APPLY);
		ButtonBar.setButtonData(b2, ButtonData.FINISH);
		ButtonBar.setButtonData(b3, ButtonData.NO);
		// 根据B1的尺寸统一设置其他按钮的尺寸
		ButtonBar.setButtonUniformSize(b1, true);
		b1.setPrefWidth(80);
		
		br.getButtons().addAll(b1, b2, b3);
		// 根据操作系统平台的不同排列不同的顺序
		br.setButtonOrder(ButtonBar.BUTTON_ORDER_NONE);
		
		ap.getChildren().addAll(br);
		
		StageUtils.setStage(primaryStage, ap);
		
		b1.setOnAction(this);
		b2.setOnAction(this);
		b3.setOnAction(this);
	}

	@Override
	public void handle(ActionEvent event) {
		Button bu = (Button)event.getSource();
		
		// 获取设置的标签
		if(ButtonBar.getButtonData(bu) == ButtonData.APPLY) {
			System.out.println("标签是APPLY： " +  bu.getText());
		}
		
	}

}











