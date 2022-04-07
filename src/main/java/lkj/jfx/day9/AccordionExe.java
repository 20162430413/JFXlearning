package lkj.jfx.day9;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import lkj.jfx.utils.ImageUtils;
import lkj.jfx.utils.StageUtils;

/**
 * 通常与TitledPane一起使用，可以将多个TitledPane放在一起，类似单选框一样每次只能展开一个
 *
 */
public class AccordionExe extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		AnchorPane ap = new AnchorPane();
		
		Accordion acc = new Accordion();
		
		TitledPane tp1 = new TitledPane("titledPane1", new Button("button1", ImageUtils.getImage("/icon/learning.png", 20, 20)));
		TitledPane tp2 = new TitledPane();
		tp2.setText("titledpane2");
		tp2.setContent(new Button("button2"));
		
		HBox hb = new HBox();
		hb.setStyle("-fx-background-color: #FFB5C5");
		hb.getChildren().addAll(new Button("button3"), new Button("button4"), new Button("button5"));

		TitledPane tp3 = new TitledPane();
		tp3.setText("titledpane3");
		tp3.setContent(hb);
		
		acc.getPanes().addAll(tp1, tp2, tp3);
		ap.getChildren().addAll(acc);
		
		StageUtils.setStage(primaryStage, ap);
		
		// 此处有坑，如果收缩时，newValue为空，会有空指针，只有展开时才会有值
		// 因为acc只能展开一个，点击另一个时会自动收缩前一个，所以会有空指针报错
		acc.expandedPaneProperty().addListener(new ChangeListener<TitledPane>() {

			@Override
			public void changed(ObservableValue<? extends TitledPane> observable, TitledPane oldValue,
					TitledPane newValue) {
				// if (newValue == null) {return;}
				System.out.println("newValue：" + newValue.getText());
				
			}
			
		});
	}
	

}
