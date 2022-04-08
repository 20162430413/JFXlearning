package lkj.jfx.day10;


import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import lkj.jfx.utils.StageUtils;

/**
 * 文本框关键字查询和文本排序
 *
 */
public class KeyFindAndSortWordExe extends Application {

	private int end = 0;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		AnchorPane ap = new AnchorPane();
		ap.setStyle("-fx-backtround-color: #FFFFFF");
		
		TextField tf = new TextField();
		Button find = new Button("查询");
		Button sort = new Button("排序");
		
		HBox hb = new HBox(10);
		hb.setAlignment(Pos.CENTER);
		hb.getChildren().addAll(tf, find, sort);
		
		TextArea ta = new TextArea();
		ta.setFont(Font.font(16));
		ta.setText("asdrewgdsfbtrysdg\nuiyophjkhvjfguy\ncbcntyuryrt");
		// 自动换行
		ta.setWrapText(true);
		
		VBox vb = new VBox(20);
		vb.setPrefWidth(350);
		vb.getChildren().addAll(hb, ta);
		
		ap.getChildren().addAll(vb);
		AnchorPane.setTopAnchor(vb, 20.0);
		AnchorPane.setLeftAnchor(vb, 20.0);
		
		StageUtils.setStage(primaryStage, ap);
		
		// 查找实现思路：从文本框中获取查找内容，从文本域中获取要查找的范围
		find.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				String value = tf.getText();
				String find_range = ta.getText();
				if(find_range.contains(value)) {
					ta.requestFocus();
					int start = find_range.indexOf(value, end);
					start =  start == -1 ? find_range.indexOf(value, 0) : start;
					end = start + value.length();
					ta.selectRange(start, end);
				}
				// 获得多行文本中的段落对象（不可修改，且为可观察对象）
				ta.getParagraphs().forEach(new Consumer<CharSequence>() {
					
					@Override
					public void accept(CharSequence t) {
						String find_range = t.toString();
						System.out.println(find_range);
					}
				});;
			}
			
		});
		
		// 排序
		sort.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				ArrayList<Character> chars = new ArrayList<Character>();
				char[] text = ta.getText().toCharArray();
				for (char c : text) {
					if (c == '\n') {
						continue;
					}
					chars.add(c);
				}
				String string = chars.stream().sorted((c1, c2) -> c1.compareTo(c2)).map(String::valueOf).collect(Collectors.joining());
				ta.setText(string);
			}
			
		});
		
	}

}
