package lkj.jfx.day6;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lkj.jfx.utils.StageUtils;

/**
 * 真正使用对话框可以使用dialog类及其子类
 *
 */
public class DialogPaneExe extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Button btn = new Button("显示弹窗");
		AnchorPane ap = new AnchorPane();
		
		ap.setStyle("-fx-background-color: #ff00ff");
		ap.getChildren().add(btn);
		AnchorPane.setTopAnchor(btn, 100.0);
		AnchorPane.setLeftAnchor(btn, 100.0);
		
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				// 会自动设置宽高
				DialogPane dp = new DialogPane();
				
				dp.setHeaderText("HeaderText");
				dp.setContentText("contentText");
				dp.getButtonTypes().add(ButtonType.APPLY);
				dp.getButtonTypes().add(ButtonType.CANCEL);
				
				// 不属于node，直接继承object
				ImageView im = new ImageView(getClass().getResource("/icon/learning.png").toExternalForm());
				im.setFitHeight(50);
				im.setFitWidth(50);
				dp.setGraphic(im);
				
				// 设置扩展内容的默认值
				dp.setExpandableContent(new Text("这是扩展内容"));
				dp.setExpanded(false);
				
				dp.setPrefHeight(100);
				dp.setPrefWidth(300);
				
				Button apply = (Button)dp.lookupButton(ButtonType.APPLY);
				Button cancel = (Button)dp.lookupButton(ButtonType.CANCEL);
				
				apply.setOnAction( action ->{
					System.out.println("apply");
				});
				cancel.setOnAction( action ->{
					System.out.println("cancel");
				});
				
				// 无效
//				dp.getChildren().add(new Button("ddd"));
				
				Stage st = new Stage();
				
				st.setScene(new Scene(dp));
				
				st.setTitle("这是弹窗");
				st.initOwner(primaryStage);
				st.initModality(Modality.WINDOW_MODAL);
				st.setResizable(false);
				st.show();
			}
		
				
		});
		
		
		StageUtils.setStage(primaryStage, ap);
		
	}
	

}
