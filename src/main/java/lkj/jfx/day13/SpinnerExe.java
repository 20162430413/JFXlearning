package lkj.jfx.day13;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import lkj.jfx.utils.StageUtils;

/**
 * 数字选择器，但是没有下拉列表
 *
 */
public class SpinnerExe extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FlowPane ap = new FlowPane();
		ap.setOrientation(Orientation.VERTICAL);
		
		Spinner<Integer> sp = new Spinner<>(0, 10, 5);
		Spinner<Integer> sp2 = new Spinner<>(0, 10, 5, 2);
		
		// 是否可编辑，默认为false
		sp2.setEditable(true);
		
		ObservableList <String> list =  FXCollections.observableArrayList();
		list.addAll("A", "B");
		Spinner<String> sp3 = new Spinner<>(list);
		
		sp3.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			  System.out.println(newValue);
			}
		});
		
		// 调整样式
		sp3.getStyleClass().add(Spinner.STYLE_CLASS_ARROWS_ON_LEFT_HORIZONTAL);
		
		// 展示一个对象内部的数据，JavaBean数据展示
		Spinner<Student> sp4 = new Spinner<>();
		
		Student s1 = new Student("A", 15);
		Student s2 = new Student("B", 23);
		Student s3 = new Student("C", 22);
		
		// 直接将此list放到Spinner的构造方法里不会显示出来，数据源
		ObservableList <Student> students =  FXCollections.observableArrayList();
		students.addAll(s1, s2, s3);
		
		// SpinnerValueFactory是一个抽象类，可以使用内部的一个setConverter()方法
		CustomSpinnerValueFactory csvf = new CustomSpinnerValueFactory(students);
		
		csvf.setConverter(new StringConverter<Student>() {

			@Override
			public String toString(Student object) {
				String res = object.getName() + "-" + object.getAge();
				System.out.println(res);
				return res;
			}

			// 只有在组件可编辑的时候此方法才有效，不可编辑则无效，setEditable(true)
			@Override
			public Student fromString(String string) {
				
				System.out.println(string);
				return new Student(string, 34);
			}
			
		});
		
		sp4.setValueFactory(csvf);
		

		// 也可以使用内部实现的一个factory类
		Spinner<Student> sp5 = new Spinner<>();
		
		// 此方法是Spinner使用list数据源构造方法时的源码，可以自动计算下一个对象信息
		SpinnerValueFactory.ListSpinnerValueFactory<Student> lvf = new SpinnerValueFactory.ListSpinnerValueFactory<Student>(students);
		
		lvf.setConverter(new StringConverter<Student>() {

			@Override
			public String toString(Student object) {
				
				if(object == null) {
					return "";
				}
				
				return object.getName() +":"+object.getAge();
			}

			@Override
			public Student fromString(String string) {
				
				return null;
			}
			
		});
		
		sp5.setValueFactory(lvf);
		
		
		ap.getChildren().addAll(sp, sp2, sp3, sp4, sp5);
		
		StageUtils.setStage(primaryStage, ap);
		
	}
	
}

// 自定义实现的一个Factory类
// SpinnerValueFactory是一个抽象类，可以使用内部的一个setConverter()方法
class CustomSpinnerValueFactory extends SpinnerValueFactory<Student>{

	private int index = -1;
	
	private ObservableList<Student> list ;
	
	// 设置数据源
	public CustomSpinnerValueFactory(ObservableList<Student> list) {
		this.list = list;
	}
	
	// 递减
	@Override
	public void decrement(int steps) {
		
		System.out.println("decrement");
		
		int cur = index - steps;
		
		index = cur > 0 ? cur : 0;
		
		this.setValue(list.get(index));
	}

	// 递增
	@Override
	public void increment(int steps) {
		System.out.println("increment");
		
		int cur = index + steps;
		
		index = cur < list.size() ? cur: list.size()-1;
		
		this.setValue(list.get(index));

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
