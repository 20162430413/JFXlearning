package lkj.jfx.day11;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import lkj.jfx.utils.ImageUtils;
import lkj.jfx.utils.StageUtils;

/**
 * ListCell是继承自label，具有label的特性，ListCell不是list
 * Cell用在TableVilew、ListView、TreeView组件上
 *
 */
public class ListCellExe extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane ap = new AnchorPane();
		setLabel(ap);
		setListCell(ap);
		setMyListCell(ap);
		StageUtils.setStage(primaryStage, ap);
	}
	
	// label的特性
	private void setLabel(AnchorPane ap) {
		// 可以指定一个图片或者布局
		Label l1 = new Label();
		l1.setText("这是Label");
		
		OrganizeStyle.organize(l1);
		
		ap.getChildren().add(l1);
		AnchorPane.setLeftAnchor(l1, 220.0);
		AnchorPane.setTopAnchor(l1, 30.0);
	}
	 
	// listCell的特性，不是list
	private void setListCell(AnchorPane ap) {
		// 可以指定一个图片或者布局
		ListCell<String> l1 = new ListCell<>();
		l1.setText("这是Label");
		
		OrganizeStyle.organize(l1);
	
		ap.getChildren().add(l1);
		AnchorPane.setLeftAnchor(l1, 30.0);
		AnchorPane.setTopAnchor(l1, 220.0);
	}
	
	private void setMyListCell(AnchorPane ap) {
		
		MyListCell<String> ml = new MyListCell<>();
		
		ml.updateItem("mylistcell", false);
		
		ap.getChildren().add(ml);
		AnchorPane.setLeftAnchor(ml, 220.0);
		AnchorPane.setTopAnchor(ml, 220.0);
	}

}

class MyListCell<T> extends ListCell<String>{

	@Override
	protected void updateItem(String item, boolean empty) {
		
		super.updateItem(item, empty);
		this.setText(item);
		
		OrganizeStyle.organize(this);
	}
}

// 统一的排列样式
class OrganizeStyle{
	
	public static void organize(Labeled ll) {
		HBox hb = new HBox(10);
		// 图片和按钮进行居中
		hb.setAlignment(Pos.TOP_CENTER);
		hb.setMinHeight(150);
		hb.setMinWidth(150);
		hb.setStyle("-fx-background-color: #ff82a8");
		hb.getChildren().addAll(ImageUtils.getImage("/icon/learning.png", 20, 20), new javafx.scene.control.Button("button"));
		
		ll.setGraphic(hb);
		// 调整图片和文字的位置顺序
		ll.setContentDisplay(ContentDisplay.CENTER);
		ll.setStyle("-fx-background-color: #ffff55");
		ll.setPrefWidth(180);
		ll.setPrefHeight(180);
		// hb在label中的居中
		ll.setAlignment(Pos.CENTER);
	}
}

