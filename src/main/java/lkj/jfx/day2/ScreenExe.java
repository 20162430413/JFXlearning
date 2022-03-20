package lkj.jfx.day2;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ScreenExe extends Application{

	/**
	 * 屏幕硬件信息
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		Screen screen = Screen.getPrimary();
		
		double dpi = screen.getDpi();
		System.out.println("当前dpi：" + dpi);
		
		// 获取整个屏幕的宽度和高度
		Rectangle2D bounds = screen.getBounds();
		// 获取可视范围屏幕的宽度和高度
		Rectangle2D visualBounds = screen.getVisualBounds();
		System.out.println("左上角x：" + bounds.getMinX() + "左上角y：" + bounds.getMinY());
		System.out.println("右下角x：" + bounds.getMaxX() + "右下角y：" + bounds.getMaxY());
		System.out.println("宽度：" + bounds.getWidth() + "高度：" + bounds.getHeight());
		System.out.println("可视范围---------");
		System.out.println("左上角x：" + visualBounds.getMinX() + "左上角y：" + visualBounds.getMinY());
		System.out.println("右下角x：" + visualBounds.getMaxX() + "右下角y：" + visualBounds.getMaxY());
		System.out.println("宽度：" + visualBounds.getWidth() + "高度：" + visualBounds.getHeight());
	
	}

}
