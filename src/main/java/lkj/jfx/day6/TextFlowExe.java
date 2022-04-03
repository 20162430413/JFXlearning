package lkj.jfx.day6;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.effect.Blend;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.Effect;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import lkj.jfx.utils.StageUtils;

/**
 * 一般不会将此作为根节点，伸缩窗口时可以将字自动换行
 *
 */
public class TextFlowExe extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Text t1 = new Text("这是JAVA FX学习，学习学习学习\n");
		Text t2 = new Text("这是JAVA FX 教程\n");
		Text t3 = new Text("Hello world!");
		Text t4 = new Text("AnchorPane text4");
		
		t1.setFont(Font.font(20));
		// 设置字体颜色
		t1.setFill(Paint.valueOf("#FF82AB"));
		
		// 字体加粗
		t2.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
		// 修改字体
		t3.setFont(Font.font("Helvetica", FontPosture.REGULAR, 40));
		
		t4.setFont(Font.font(30));
		
		TextFlow tf = new TextFlow();
		tf.getChildren().addAll(t1, t2, t3);
		tf.setStyle("-fx-background-color: #EECFA1");
		
		// 内间距
		tf.setPadding(new Insets(10));
		tf.setTextAlignment(TextAlignment.CENTER);
		tf.setLineSpacing(40);

		TextFlow tf2 = new TextFlow();
		tf2.getChildren().add(t4);

		AnchorPane ap = new AnchorPane();
		ap.getChildren().addAll(tf, tf2);
		
		// 调整位置
		AnchorPane.setTopAnchor(tf, 100.0);
		AnchorPane.setLeftAnchor(tf, 50.0);
		
		primaryStage.widthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				
				// ap.getPrefWidth()：使用setPrefWidth时才会有值
				// ap.getWidth()：会有一个初始的宽度
				System.out.println("ap 的宽度：" + ap.getWidth());
				System.out.println("tf 的宽度：" + tf.getWidth());
			}
		});
		
		// 手动监听anchorpane的宽度变化调整textflow的变化
		ap.widthProperty().addListener( new ChangeListener<Number>(){

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println("tf.getlayoutx： " + tf.getLayoutX());
				tf.setPrefWidth(newValue.doubleValue() - tf.getLayoutX());
			}
			
		});
		
		// Node类都有一个setEfect()设置效果的方法，包括模糊，阴影，切割，旋转等等
		tf.setEffect(new Bloom());
		
		
		
		StageUtils.setStage(primaryStage, ap);
		
	}
	

}
