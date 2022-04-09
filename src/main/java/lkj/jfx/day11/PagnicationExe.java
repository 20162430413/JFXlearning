package lkj.jfx.day11;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import lkj.jfx.utils.StageUtils;

/**
 * 分页
 *
 */
public class PagnicationExe extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane root = new AnchorPane();
		Pagination pg = new Pagination();
		
		pg.setStyle("-fx-background-color: #ffff55");
		pg.setPrefWidth(300);
		pg.setPrefHeight(300);
		// 设置总页数
		pg.setPageCount(6);
		// 当前显示的最大页数
		pg.setMaxPageIndicatorCount(5);
		// 设置不确定页数
		pg.setPageCount(Pagination.INDETERMINATE);
		// 当前选中的页
		pg.setCurrentPageIndex(2);
//		 设置样式，可以跟css联系起来
//		pg.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);
		
		AnchorPane.setTopAnchor(pg, 50.0);
		AnchorPane.setLeftAnchor(pg, 100.0);
		root.getChildren().add(pg);
		StageUtils.setStage(primaryStage, root);
		
		// 监听事件
		pg.currentPageIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println("当前页=" + newValue);
			}
		});
		// 设置选中的页面的内容
		pg.setPageFactory(new Callback<Integer, Node>() {
			
			// param：当前页
			@Override
			public Node call(Integer param) {
				System.out.println(param);
				if(param == 0) {
					HBox hb = new HBox(10);
					hb.setAlignment(Pos.BOTTOM_CENTER);
					hb.getChildren().add(new Button("page : 0"));
					hb.setStyle("-fx-background-color: #FA8972");
					return hb;
				}
				return new Button("but");
			}
		});
	}

}
