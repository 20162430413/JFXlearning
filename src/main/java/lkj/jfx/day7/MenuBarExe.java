package lkj.jfx.day7;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.Mnemonic;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lkj.jfx.utils.ImageUtils;
import lkj.jfx.utils.StageUtils;

/**
 * MenuBar、Menu、MenuItem必须放在一起才能使用，单独不可使用
 * MenuBar：菜单栏
 * Menu：菜单选项，不是node子类
 * MenuItem：菜单子选项，不是node子类
 *
 */
public class MenuBarExe extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane ap = new AnchorPane();
		ap.setStyle("-fx-background-color: #E6CCF2");
		
		MenuBar bar = new MenuBar();
		
		Menu menu1 = new Menu("menu1");
		Menu menu2 = new Menu("menu2");
		Menu menu3 = new Menu("menu3", new Button("sdfs"));
		Menu menu4 = new Menu("menu4");
		
		MenuItem item1 = new MenuItem("item1");
		MenuItem item2 = new MenuItem("item2");
		// 给选项添加图标
		MenuItem item3 = new MenuItem("item3",ImageUtils.getImage("/icon/learning.png", 20, 20));
		MenuItem item4 = new MenuItem("item4");
		MenuItem item5 = new MenuItem("item5");

		// 给选项设置快捷键，其他绑定快捷键的方式可以看 ButtonExe.java，快捷键的设置需要在调用Stage.show()方法之前
		item3.setAccelerator(KeyCombination.valueOf("ctrl+alt+q"));
		
		bar.getMenus().addAll(menu1, menu2, menu3, menu4);
		menu1.getItems().addAll(item1, item2, item3);
		menu2.getItems().addAll(item4, item5);
		ap.getChildren().add(bar);
		
		StageUtils.setStage(primaryStage, ap);

		bar.setPrefWidth(primaryStage.getWidth());
		
		// menubar宽度随窗口自动变化
		ap.widthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				bar.setPrefWidth(newValue.doubleValue());
			}
		});
		
		// 正在显示中
		menu1.setOnShowing(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				System.out.println("menu1.setOnShowing");
				
			}
		});
		menu1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("menu1.setOnAction");
				
			}
		});
		
		// 添加点击事件
		item1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("item1.setOnAction");
			}
		});

		item3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("item3.setOnAction");
				
			}
		});
		
		
	}

}
