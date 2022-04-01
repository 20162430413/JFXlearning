package lkj.jfx.day5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import lkj.jfx.utils.StageUtils;

/**
 * 网格布局
 *
 */
public class GridPaneExe extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {

		Button b1 = new Button("button1");
		Button b2 = new Button("button2");
		Button b3 = new Button("button3");
		Button b4 = new Button("button4");
		Button b5 = new Button("button5");
		Button b6 = new Button("button6");
		Button b7 = new Button("button7");
		Button b8 = new Button("button8");
		
		GridPane gp = new GridPane();
		gp.setStyle("-fx-background-color: #EE6AA7");
		
		// 网格布局添加子组件不需要getChildren
		// 设置网格布局的子组件在第几列第几行
		gp.add(b1, 0, 0);
		gp.add(b2, 1, 0);
		gp.add(b3, 2, 0);
		gp.add(b4, 3, 0);
		gp.add(b5, 0, 1);
		gp.add(b6, 1, 1);
		gp.add(b7, 2, 1);
		gp.add(b8, 3, 1);
		
		// 设置水平/垂直间距
		gp.setHgap(10);
		gp.setVgap(10);
		// 设置内边距
		gp.setPadding(new Insets(10));
		
		// 剧中对齐
		gp.setAlignment(Pos.CENTER);
		
		// 将b1放在第一列的第一行
//		gp.setConstraints(b1, 1, 1);
//		gp.getChildren().add(b1);
		
		// 指定放在哪个位置
//		gp.setRowIndex(b1,2);
//		gp.setColumnIndex(b1, 4);
//		gp.getChildren().add(b1);
		
		// 设置第一列的间距
		gp.getColumnConstraints().add(new ColumnConstraints(100));
		
		// 设置第一行间距
		gp.getRowConstraints().add(new RowConstraints(50));
		
		StageUtils.setStage(primaryStage, gp);
		
		
		
		
		
		
		
		
	}

}
