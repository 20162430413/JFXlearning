package lkj.jfx.day11;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import lkj.jfx.utils.StageUtils;

public class DatePickerExe extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane ap = new AnchorPane();
		
		DatePicker dp = new DatePicker(LocalDate.now());
		
		// 获取当前值
		dp.getValue();
		dp.setEditable(false);
		
		ap.getChildren().addAll(dp);
		AnchorPane.setTopAnchor(dp, 150.0);
		AnchorPane.setLeftAnchor(dp, 50.0);
		
		StageUtils.setStage(primaryStage, ap);
		
		dp.valueProperty().addListener(new ChangeListener<LocalDate>() {

			@Override
			public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue,
					LocalDate newValue) {
				
				System.out.println("year: " + newValue.getYear());
				System.out.println("month: " + newValue.getMonthValue());
				System.out.println("day: " + newValue.getDayOfMonth());
				System.out.println("week: " + newValue.getDayOfWeek().getValue());
				
			}
		});
		
		// 单元格格式工厂
		dp.setDayCellFactory(new Callback<DatePicker, DateCell>() {
			
			@Override
			public DateCell call(DatePicker param) {
				
				DateCell cell = new DateCell() {

					@Override
					public void updateItem(LocalDate item, boolean empty) {
						
						super.updateItem(item, empty);
						this.setGraphic(new Label(item.now().toString()));
					}
					
				};
				
				return cell;
			}
		});
		
		dp.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("onaction");
			}
		});
	}

}
