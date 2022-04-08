package lkj.jfx.day10;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import lkj.jfx.utils.StageUtils;

/**
 * 下拉列表系列，直接用即可
 *
 */
public class ChoiceBoxExe extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		AnchorPane ap = new AnchorPane();
		
		Student s1 = new Student("A", 23);
		Student s2 = new Student("B", 45);
		Student s3 = new Student("C", 12);
		Student s4 = new Student("D", 77);
		 
		ChoiceBox<String> cb = new ChoiceBox<String>();
		// 引用类型
		ChoiceBox<Student> cbt = new ChoiceBox<Student>();
		
		// 返回可观察列表项目
		cb.getItems().addAll("str1", "str2", "str3");
		cbt.getItems().addAll(s1, s2, s3, s4);
		
		// 也可以放一个分割符
//		cb.getItems().addAll("str1", "str2", new Separator(), "str3");
		
		// 设置默认选中
		cb.setValue("str2");
		// 设置选中第几个
		cb.getSelectionModel().select(0);
		cbt.getSelectionModel().select(0);
		
		cb.setPrefWidth(100);
		
		ap.getChildren().addAll(cb, cbt);
		AnchorPane.setTopAnchor(cb, 50.0);
		AnchorPane.setLeftAnchor(cb, 50.0);
		AnchorPane.setTopAnchor(cbt, 100.0);
		AnchorPane.setLeftAnchor(cbt, 50.0);
		
		
		 StageUtils.setStage(primaryStage, ap);
		 
		 // 展开下拉列表
		 cb.show();
		 // 关闭下拉列表
		 cb.hide();
		 
		 // 选择变化监听
		 cb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			}
		 });
		 
		 // 下拉列表转换显示名称为学生的名字
		 cbt.setConverter(new StringConverter<Student>() {
			
			 // 在出口方法上进行转换
			@Override
			public String toString(Student object) {
				String value = object.getName() + "-" + object.getAge();
				return value;
			}
			
			// 因为StringConverter不是为cb准备的，所以from方法的参数类型不能为student
			// 所以可以忽略没有使用该方法
			@Override
			public Student fromString(String string) {
				System.out.println("过了这个方法");
				return null;
			}
		});
		 
	}

}

class Student{
	private String name;
	private int age;
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
