package lkj.jfx.day2;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.stage.Stage;

public class PlatformExe extends Application {

	@SuppressWarnings("exports")
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		System.out.println("current start: " + Thread.currentThread().getName());				
		
		// runLater实际上是个队列，可以用来更新一些组件，和start使用的是同一个线程
		// 可以在空闲的时候更新ui界面，但是大量的任务会产生阻塞的情况(例如下载的任务)，可以用来倒计时
		// 多任务处理有多任务处理的专用类
		Platform.runLater(new Runnable() {
			
			public void run() {
				System.out.println("current run: " + Thread.currentThread().getName());				
				
			}
		});
		
		// 为false时当最后一个窗口都退出之后程序也不退出，只能使用 exit() 方法退出
		Platform.setImplicitExit(true);
		
		// 当前电脑是否支持一些属性，是否支持3d效果
		System.out.println(Platform.isSupported(ConditionalFeature.SCENE3D));
		
		primaryStage.show();
		
	}

}
