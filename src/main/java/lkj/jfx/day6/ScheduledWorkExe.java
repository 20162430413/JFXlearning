package lkj.jfx.day6;

import javafx.application.Application;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import lkj.jfx.utils.StageUtils;

public class ScheduledWorkExe extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Button btn = new Button("显示弹窗");
		AnchorPane ap = new AnchorPane();
		
		ap.setStyle("-fx-background-color: #E6AAF7");
		ap.getChildren().add(btn);
		AnchorPane.setTopAnchor(btn, 100.0);
		AnchorPane.setLeftAnchor(btn, 100.0);
		
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				// 会自动设置宽高
				DialogPane dp = new DialogPane();
				
				dp.setHeaderText("HeaderText");
				dp.setContentText("contentText");
				
				// 不属于node，直接继承object
				ImageView im = new ImageView(getClass().getResource("/icon/learning.png").toExternalForm());
				im.setFitHeight(50);
				im.setFitWidth(50);
				dp.setGraphic(im);
				
				Stage st = new Stage();
				st.setScene(new Scene(dp));
				st.setTitle("这是弹窗");
				st.initOwner(primaryStage);
				st.initModality(Modality.WINDOW_MODAL);
				st.setResizable(false);
				st.show();
				
				// 定时任务类
				MyScheduleService my = new MyScheduleService(dp, st);
				// start方法调用后多长时间后会执行
				my.setDelay(Duration.millis(0));
				// 每隔多长时间会执行一次
				my.setPeriod(Duration.millis(1000));
				my.start();
			}
		
				
		});
		
		
		StageUtils.setStage(primaryStage, ap);
		
	}

}

class MyScheduleService extends ScheduledService<Integer>{

	private int i = 0;
	private DialogPane dp;
	private Stage stage;
	
	public MyScheduleService(DialogPane pane, Stage stage){
		this.dp = pane;
		this.stage = stage;
	}
	
	@Override
	protected Task<Integer> createTask() {
		
		return new Task<Integer>() {
			// 无法在call方法里进行界面组件的更新，因为此线程不是java FX的渲染线程
			@Override
			protected Integer call() throws Exception {

				System.out.println("call method's tread name : " + Thread.currentThread().getName());
				return ++i;
			}
			
			// updateValue方法是使用Java Fx的渲染线程启动执行的
			@Override
			protected void updateValue(Integer value) {

				System.out.println("updateValue method's tread name : " + Thread.currentThread().getName());
				System.out.println("updateValue 的值：" + value);
				
				if(value < 11) {
					MyScheduleService.this.dp.setContentText(String.valueOf(value));
				} else {
					MyScheduleService.this.cancel();
					MyScheduleService.this.stage.close();
				}
			}
			
			
		};
	}
	
}
