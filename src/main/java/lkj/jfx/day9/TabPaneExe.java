package lkj.jfx.day9;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import lkj.jfx.utils.ImageUtils;
import lkj.jfx.utils.StageUtils;

public class TabPaneExe extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		AnchorPane ap = new AnchorPane();
		
		// 参数列表：颜色、圆角、内边距
		Background bg = new Background(new BackgroundFill(Paint.valueOf("#87CEEB"), new CornerRadii(10), new Insets(20)));
		// 设置边框，参数列表：颜色、边框样式、圆角、宽度
		Border border = new Border(new BorderStroke(Paint.valueOf("#EE2C2C"), BorderStrokeStyle.DASHED, new CornerRadii(10), new BorderWidths(3)));
		
		// 会以最大的子组件的大小作为默认大小
		TabPane tp = new TabPane();
		tp.setPrefHeight(200);
		tp.setPrefWidth(300);
		// tp.setStyle("-fx-background-color: #FFA07A");
		// 复习背景、边框
		tp.setBackground(bg);
		tp.setBorder(border);
		
		Tab tab1 = new Tab("tab1");
		Tab tab2 = new Tab("tab2");
		Tab tab3 = new Tab("tab3");
		
		HBox hb = new HBox(10);
		hb.setAlignment(Pos.CENTER);
		hb.setStyle("-fx-background-color: #FF23DE");
		hb.getChildren().addAll(new Button("b1"), new Button("b1"), new Button("b1"));
		
		VBox vb = new VBox(10);
		vb.setAlignment(Pos.CENTER);
		vb.setStyle("-fx-background-color: #B9D3EE");
		vb.getChildren().addAll(new Button("b1"), new Button("b1"), new Button("b1"));
		
		
		tab1.setContent(hb);
		tab1.setGraphic(ImageUtils.getImage("/icon/learning.png", 20, 20));

		tab2.setContent(vb);
		// 设置是否可以关闭
		tab2.setClosable(false);
		// 设置不可用
		tab3.setDisable(false);
		
		tp.getTabs().addAll(tab1, tab2, tab3);
		// 设置默认选中的tab，选择模式默认为单选，也可以多选
		tp.getSelectionModel().select(tab2);
		// 选中最后一个tab
		tp.getSelectionModel().selectLast();
		// 设置tab选择列表的吸附的边
		tp.setSide(Side.RIGHT);
		// 让tab选项中的图片方向也随着吸附的边的方向进行调整，但是需要让设置图片的语句(tab1.setGraphic)在show方法之前执行，不然不起效果
		tp.setRotateGraphic(false);
		// 设置所有的tab都可以关闭，UNAVAILABLE：全部不能关闭
		tp.setTabClosingPolicy(TabClosingPolicy.ALL_TABS);
		
		ap.getChildren().addAll(tp);
		AnchorPane.setTopAnchor(tp, 50.0);
		AnchorPane.setLeftAnchor(tp, 100.0);
		
		StageUtils.setStage(primaryStage, ap);
		
		// 切换的时候会触发
		tp.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {

			@Override
			public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {
				System.out.println(newValue.getText());
			}
			
		});
		
		// 选中和切换的时候都会触发该方法
		tab1.setOnSelectionChanged(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				Tab t = (Tab)event.getSource();
				System.out.println("这是：" + t.getText());
				System.out.println("是否选中：" + t.isSelected());
			}
			
		});
		
		// 动态添加tab
		ap.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				tp.getTabs().add(new Tab("hello"));
				
			}
		});
		// 关闭时也会触发选中状态的改变的监听方法
		tab1.setOnClosed(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				System.out.println("tab1 closed");
			}
		});
		// 两个监听方法都会触发，会导致事件传递给Onclosed()方法
		tab1.setOnCloseRequest(new EventHandler<Event>() {
			
			@Override
			public void handle(Event event) {
				System.out.println("tab1 setOnCloseRequest");
				// 可以阻止事件传递给OnClosed()方法，但是tab关不上了
				event.consume();
			}
		});
		
		
	}

}
