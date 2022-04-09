package lkj.jfx.day11;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lkj.jfx.utils.StageUtils;

public class ColorPickerExe extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane ap = new AnchorPane();
		
		ColorPicker cp = new ColorPicker(Color.valueOf("#ffff55"));
		
		cp.valueProperty().addListener(new ChangeListener<Color>() {

			@Override
			public void changed(ObservableValue<? extends Color> observable, Color oldValue, Color newValue) {
				System.out.println("red = " + newValue.getRed());
				System.out.println("blue = " + newValue.getBlue());
				System.out.println("green = " + newValue.getGreen());
				
				System.out.println("hcolor : " + newValue.toString());
				ap.setStyle("-fx-background-color: #" + newValue.toString().substring(2));
			}
		});
		
		ap.getChildren().addAll(cp);
		AnchorPane.setTopAnchor(cp, 150.0);
		AnchorPane.setLeftAnchor(cp, 50.0);
		
		StageUtils.setStage(primaryStage, ap);
	}

}
