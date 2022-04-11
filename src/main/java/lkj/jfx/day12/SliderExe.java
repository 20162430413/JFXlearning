package lkj.jfx.day12;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.StringConverter;
import lkj.jfx.utils.StageUtils;

/**
 * 可拖拽的进度条，拖动条
 *
 */
public class SliderExe extends Application {

	int t = 0;
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		AnchorPane ap = new AnchorPane();
		ap.setStyle("-fx-background-color: #ffffff");
		
		// min max  value
		Slider sli = new Slider(0, 100, 50);
		sli.setPrefWidth(300);
		// 一般不设置高度
		sli.setPrefHeight(300);
		// 显示刻度
		sli.setShowTickMarks(true);
		// 显示刻度值
		sli.setShowTickLabels(true);
		// 刻度代表的大小
		sli.setMajorTickUnit(10);
		// 指定特定的值
		sli.setValue(20);
		// 设置水平竖直
		sli.setOrientation(Orientation.VERTICAL);
		// 没有单击事件，但是可以设置鼠标监听
		sli.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				System.out.println("mouse clicked");
			}
		});
		// 设置转换器
		sli.setLabelFormatter(new StringConverter<Double>() {
			
			// 传入当前刻度代表的值，返回的为label转换之后的类型
			@Override
			public String toString(Double object) {
				
				if(object.doubleValue() == 0) {
					return "零";
				}
				if(object.doubleValue() == 10) {
					return "拾";
				}
				return "未知";
			}
			
			@Override
			public Double fromString(String string) {
				System.out.println("此处没有调用，文本输入的时候才会被调用");
				return null;
			}
		});
		
		ap.getChildren().add(sli);
		AnchorPane.setTopAnchor(sli, 50.0);
		AnchorPane.setLeftAnchor(sli, 50.0);
		
		StageUtils.setStage(primaryStage, ap);
		// 监听当前改变的值
		sli.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

				// 当值发生变化之后通过此方法告诉下面的监听器发生了变化
				sli.setValueChanging(true);
				System.out.println(newValue);
			}
		});
		// 检测是否发生了改变，如果开始改变就为true，结束改变为false
		sli.valueChangingProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				System.out.println(newValue);
			}
		});
		// 不建议这样使用多线程，使用的不是渲染进程，关闭窗口之后进程还在。有专门的多任务处理类
//		new Thread(new Runnable(){
//			public void run() {
//				for(int i = 0; i<100; i++) {
//					t=i;
//					// 此时使用的是java FX的渲染进程，不建议将下载任务都放到这里，会卡死，网络请求会放在单独的多线程类中
//					// 是一个队列，不是多线程
//					Platform.runLater(new Runnable() {
//						public void run() {
//							sli.setValue(t);
//							System.out.println("Thread name: " + Thread.currentThread().getName());
//						}
//					});
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {}
//				}
//			}
//		}).start();
		
		// 使用定时任务更新
		ScheduleTaskExample task = new ScheduleTaskExample(sli);
		// 多长时间后启动
		task.setDelay(Duration.millis(0));
		task.setPeriod(Duration.millis(1000));
		task.start();
		
		// 而且，可以给定时任务添加监听，拿到更新后的值（在监听里更新界面值），也是运行在Java FX的线程里
		// 如果重写的定时任务类的 updateValue 方法中没有调用 super.updateValue() 时，不会此监听没有作用
		// 会通知两次，一次通知新值（旧值为空），一次更旧值（新值为空）
		task.valueProperty().addListener(new ChangeListener<Integer>() {

			@Override
			public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
				System.out.println(Thread.currentThread().getName() + " new :" + newValue);
			}
		});
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
