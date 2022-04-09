package lkj.jfx.day11;


import java.util.function.Predicate;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import lkj.jfx.utils.StageUtils;

/**
 * 也是一个下拉列表，和choicebox长得一摸一样，基本用法也一样
 * ComboBox支持可编辑，且下拉列表可以定制化处理，加图片等操作
 *
 */
public class ComboBoxExe extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		AnchorPane ap = new AnchorPane();
		
		Button bu = new Button("bu");
		Monkey m1 = new Monkey("m1", 2);
		Monkey m2 = new Monkey("m2", 5);
		Monkey m3 = new Monkey("m3", 3);
		Monkey m4 = new Monkey("m4", 1);
		
		ComboBox<String> cbb = new ComboBox<String>();
		ComboBox<Monkey> cbm = new ComboBox<Monkey>();
		
		cbb.getItems().addAll("str1", "str2", "str3", "str4");
		cbm.getItems().addAll(m1, m2, m3, m4);
		ObservableList<Monkey> items = cbm.getItems();
		
		
		// 允许编辑，编辑的值会从converter的from方法传入
		cbb.setEditable(true);
		cbm.setEditable(true);
		// 提示信息
		cbb.setPromptText("请输入XXX");
		// 设置占位符，如果没有items会显示这个
		cbb.setPlaceholder(new Button("没有选项可选"));
		// 设置显示固定行数
		cbb.setVisibleRowCount(3);
		
		
		ap.getChildren().addAll(cbb, bu, cbm);

		AnchorPane.setTopAnchor(cbb, 100.0);
		AnchorPane.setLeftAnchor(cbb, 50.0);
		AnchorPane.setTopAnchor(cbm, 150.0);
		AnchorPane.setLeftAnchor(cbm, 50.0);
		AnchorPane.setLeftAnchor(bu, 10.0);
		
		StageUtils.setStage(primaryStage, ap);
		
		cbm.setConverter(new StringConverter<Monkey>() {
			
			@Override
			public String toString(Monkey object) {
				if(object == null) {
					return null;
				}
				System.out.println("gg");
				return object.getName() + "-" + object.getAge();
			} 
			
			@Override
			public Monkey fromString(String string) {
				if(string == null || string.isEmpty()) {
					return null;
				}
				System.out.println(string);
				Monkey m6 = new Monkey(string, 6);
				items.add(m6);
				return m6;
			}
		});
		
		// 下拉列表自动检索，cbm.editorProperty().get() 返回的是一个单行文本TextField
		cbm.editorProperty().get().textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println("enw:[" + newValue + "]");
				if(newValue == null) {
					cbm.setItems(null);
					cbm.setPlaceholder(new Label("没有找到"));
					return;
				}
				FilteredList<Monkey> newList = items.filtered(new Predicate<Monkey>() {
					
					@Override
					public boolean test(Monkey t) {
						return t.getName().contains(newValue);
					}
				});
				
				if(newList.isEmpty()) {
					System.out.println("newList is empty");
					cbm.setItems(null);
					cbm.setPlaceholder(new Label("没有找到"));
					return;
				}
				cbm.setItems(newList);
				cbm.hide();
				cbm.show();
				
			}
		});

	}

}

class Monkey{
	
	private SimpleStringProperty name = new SimpleStringProperty();
	private SimpleIntegerProperty age = new SimpleIntegerProperty();
	
	public Monkey() {};
	
	public Monkey(String name, int age) {
		this.name.set(name);;
		this.age.set(age);
		this.name.addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println("name : " + newValue);
			}
		});
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);;
	}

	public int getAge() {
		return age.get();
	}

	public void setAge(int age) {
		this.age.set(age);
	}
	
	
}