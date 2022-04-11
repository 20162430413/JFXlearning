package lkj.jfx.day12;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lkj.jfx.utils.StageUtils;

/**
 * 进度条
 *
 */
public class ProgressBarAndIndicatorExe extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane ap = new AnchorPane();
		
		// 进度条，进度在 0-1 之间
		ProgressBar bar = new ProgressBar(0.8);
		bar.setPrefWidth(300);
		bar.setPrefHeight(50);
		// 设置进度
		bar.setProgress(0.5);
		// 未知进度，表示加载中的状态
//		bar.setProgress(ProgressBar.INDETERMINATE_PROGRESS);
		
		// 进度指示器
		ProgressIndicator pi = new ProgressIndicator();
		pi.setMinWidth(200);
		pi.setMinHeight(200);

		// 未知进度，表示加载中的状态
//		pi.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);
		
		ap.getChildren().add(bar);
		ap.getChildren().add(pi);
		AnchorPane.setTopAnchor(bar, 210.0);
		
		StageUtils.setStage(primaryStage, ap);
		
		ScheduledService<Double> doTask = new ScheduledService<Double>() {

			ScheduledService<Double> innerDo = this;
			double i = 0;
			@Override
			protected Task<Double> createTask() {
				
				Task<Double> task = new Task<Double>() {

					@Override
					protected Double call() throws Exception {
						
						return i += 0.1;
					}

					@Override
					protected void updateValue(Double value) {
						
						super.updateValue(value);
						bar.setProgress(i);
						pi.setProgress(i);
						if(i >= 1) {
							innerDo.cancel();
							System.out.println("任务取消");
						}
					}
					
				};
				
				return task;
			}
		};
		
		doTask.setDelay(Duration.millis(0));
		doTask.setPeriod(Duration.millis(1000));
		doTask.start();
		
		bar.progressProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println(newValue);
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
