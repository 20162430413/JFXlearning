package lkj.jfx.day10;


import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import lkj.jfx.utils.StageUtils;

/**
 * 修改ChoiceBox列表选项，如果简单刷新列表会导致convert方法重复执行
 * 需要将Person中普通的String、int属性换成具有监听属性的SimpleXXXProperty
 * 当Person中具有监听属性的字段更新时，会触发相关的选项进行转换
 */
public class ChoiceBoxModifyItemExe extends Application{

	private Person p = new Person();
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		AnchorPane ap = new AnchorPane();
		
		TextField tf = new TextField();
		Button bu = new Button("修改名称");
		
		Person s1 = new Person("A", 23);
		Person s2 = new Person("B", 45);
		Person s3 = new Person("C", 12);
		Person s4 = new Person("D", 77);
		ChoiceBox<Person> cbt = new ChoiceBox<Person>();
		cbt.getItems().addAll(s1, s2, s3, s4);
		
		cbt.getSelectionModel().select(0);
		AnchorPane.setTopAnchor(cbt, 100.0);
		AnchorPane.setLeftAnchor(cbt, 50.0);
		AnchorPane.setLeftAnchor(tf, 10.0);
		AnchorPane.setLeftAnchor(bu, 180.0);
		
		ap.getChildren().addAll(cbt, tf, bu);
		StageUtils.setStage(primaryStage, ap);
		 
		 // 下拉列表转换显示名称为学生的名字
		 cbt.setConverter(new StringConverter<Person>() {
			
			// 在出口方法上进行转换
			@Override
			public String toString(Person object) {
				System.out.println("convert");
				String value = object.getName() + "-" + object.getAge();
				return value;
			}
			
			// 因为StringConverter不是为cb准备的，所以from方法的参数类型不能为student
			// 所以可以忽略没有使用该方法
			@Override
			public Person fromString(String string) {
				System.out.println("过了这个方法");
				return null;
			}
		});
		 
		 cbt.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Person>() {

			@Override
			public void changed(ObservableValue<? extends Person> observable, Person oldValue, Person newValue) {
				p = newValue;
				
			}
		});
		 
		 
		 bu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// 需要重新刷新列表，需要重新放一次元素
//				String value = tf.getText();
//				int indexOf = cbt.getItems().indexOf(p);
//				cbt.getItems().remove(p);
//				p.setName(value);
//				cbt.getItems().add(indexOf, p);
				
				// 如果是具有监听属性的字段进行更新，是可以重新刷新列表中指定位置的选项名字的
				String value = tf.getText();
				p.setName(value);
			}
		});
		 
	}

}

class Person{
//	private String name;
//	private int age;
	
	private SimpleStringProperty name = new SimpleStringProperty();
	private SimpleIntegerProperty age = new SimpleIntegerProperty();
	
	public Person() {};
	
	public Person(String name, int age) {
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