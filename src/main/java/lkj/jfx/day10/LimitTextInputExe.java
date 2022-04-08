package lkj.jfx.day10;


import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import lkj.jfx.utils.StageUtils;

/**
 * 文本框限制用户输入格式
 *
 */
public class LimitTextInputExe extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		VBox vb = new VBox(20);
		
		TextField tf = new TextField();
		TextArea ta = new TextArea();
		
		// 获取焦点
		tf.requestFocus();
		
		// 设置正则表达式格式化类，多行文本也可以
		tf.setTextFormatter(new TextFormatter<String>(new UnaryOperator<Change>() {
			@Override
			public Change apply(Change t) {
				String value = t.getText();
				System.out.println(value);
				if(value.matches("[0-9]*")) {
					return t;
				}
				return null;
			}
			
		}));
		
		Text text = new Text();
		text.setFont(Font.font("Segoe UI Emoji"));
		text.setText("\uD83D\uDE04法大师傅士大夫");
		
		
		vb.getChildren().addAll(tf, ta, text);
		vb.setAlignment(Pos.CENTER);
		
		StageUtils.setStage(primaryStage, vb);
		
		ta.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				
				// 限制输入：转换格式
				ta.setTextFormatter(new TextFormatter<String>(new StringConverter<String>() {
					// 数据从这里出去，然后放到text area里
					@Override
					public String toString(String object) {
						System.out.println("obj = " + object);
						return object;
					}

					// 数据从这里进入，将输入的1替换成emoji表情
					@Override
					public String fromString(String string) {
						if(string.contains("1")) {
							return string.replace("1", "\uD83D\uDE04");
						}
						return string;
					}
					
				}));
				// 提交值，与StringConverter配合使用
				ta.commitValue();
			}
			
		});
		
		
		
		
	}

}


































