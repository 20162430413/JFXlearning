package lkj.jfx.day2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FxLaunchDay2 extends Application{

	@Override
	public void start(@SuppressWarnings("exports") Stage primaryStage) throws Exception {
		
		// 设置透明度
		primaryStage.setOpacity(1);
		// 置顶
		primaryStage.setAlwaysOnTop(false);
		// 设置窗口5种模式
		primaryStage.initStyle(StageStyle.UNIFIED);
		primaryStage.show();
		
		Stage s1 = new Stage();
		s1.initStyle(StageStyle.DECORATED);
		s1.setTitle("s1");
		
		// 设置窗口模态框形式，application形式就是当前焦点
//		s1.initModality(Modality.APPLICATION_MODAL);
		
		// initOwner与Modality.WINDOW_MODAL两个结合使用，也是保持焦点不改变的
//		s1.initOwner(primaryStage);
//		s1.initModality(Modality.WINDOW_MODAL);
		
		s1.show();
		
		
		// 关闭全部窗口
//		Platform.exit();
	}

}
