package lkj.jfx.day9;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import lkj.jfx.utils.StageUtils;

/**
 * 多行文本，复制、粘贴、撤销都可以操作
 *
 */
public class TextAreaExe extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		AnchorPane ap = new AnchorPane();
		ap.setStyle("-fx-backtround-color: #FFFFFF");
		
		TextArea ta = new TextArea();
		ta.setFont(Font.font(16));
		ta.setText("abcde");
		// 设置是否可以自动换行，button也可使用，用来替换...的省略
		ta.setWrapText(false);
		// 设置初始行大小，设置宽高之后会覆盖该项
		ta.setPrefRowCount(3);
		// 设置初始列大小，设置宽高之后会覆盖该项
		ta.setPrefColumnCount(10);
		
		ta.appendText("追加文本");
		// 删除文本
		ta.deleteText(0, 3);
		// 插入文本
		ta.insertText(2, "insert");
		ta.replaceText(0, 1, "replacefsdfsfsdfsfsfdsf" );
//		ta.selectPositionCaret(4);          // 选定指定部分，有策略的
//		ta.getLength();
//		ta.selectRange(3, 5);               // 选定指定范围
//		ta.positionCaret(3);                // 光标移动到指定位置上
//		ta.home();                          // 光标移动到开始
//		ta.end();                           // 移动到末尾
//		ta.selectEnd();                     // 从当前位置选到结尾
//		ta.setEditable(false);              // 是否可编辑
//		ta.clear();                         // 清除 源码使用的也是  ta.setText("")
		
//		ta.selectAll();                     // 全选
//		ta.copy();                          // 拷贝选中的内容到剪切板，可以先全选，再复制
//		ta.setScrollLeft(20);               // 指定滚动条移动到的位置
	
		
		
		
		
		ap.getChildren().addAll(ta);
		
		
		
		StageUtils.setStage(primaryStage, ap);
		// 点击屏幕事件
		ap.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				ta.setScrollLeft(20);
			}
			
		});
		
		// 文本监听
		ta.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println("newValue: " + newValue);
			}
		});
		
		// 选中文本的监听方法
		ta.selectedTextProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println("选中的文本：" + newValue);
			}
		});
		// 滚动监听，当前滚动条的位置变化
		ta.scrollLeftProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println("scroll listener: " + newValue);
			}
			
		});
	}

}
