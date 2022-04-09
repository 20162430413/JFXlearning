package lkj.jfx.day11;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import lkj.jfx.utils.ImageUtils;
import lkj.jfx.utils.StageUtils;

/**
 * 自定义单元格格式样式，包括下拉列表、table等，
 * ListCell是继承自label，具有label的特性，ListCell不是list
 * Cell用在TableVilew、ListView、TreeView组件上
 */
public class CellFactoryExe extends Application {


	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		ComboBox<String> cbm = new ComboBox<String>();
		cbm.getItems().addAll("str1", "str2", "str3");
		cbm.getSelectionModel().select(0);
		
		ComboBox<Person> cbp = new ComboBox<>(); 
		cbp.getItems().addAll(new Person("小明", 23),new Person("小红", 45),new Person("小绿", 42));
		cbp.getSelectionModel().select(0);
		
		
		AnchorPane ap = new AnchorPane();
		ap.getChildren().addAll(cbm, cbp);
		
		AnchorPane.setTopAnchor(cbm, 30.0);
		AnchorPane.setLeftAnchor(cbm, 30.0);
		AnchorPane.setTopAnchor(cbp, 60.0);
		AnchorPane.setLeftAnchor(cbp, 30.0);
		StageUtils.setStage(primaryStage, ap);
		
		// 设置名称转换
		cbp.setConverter(new StringConverter<Person>() {
			
			@Override
			public String toString(Person object) {
				if(object == null) {
					return "";
				}
				return object.getName() + "-" + object.getAge();
			}
			
			@Override
			public Person fromString(String string) {
				return null;
			}
		});
		
		// 设置工厂方法，可以自定义单元格
		cbm.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
			
			@Override
			public ListCell<String> call(ListView<String> param) {
				ListCell<String> lc = new ListCell<String>() {

					@Override
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if(!empty) {
							this.setText(item + "- B");
						}
					}
					
				};
				return lc;
				
			}
		});
		
		// 此方法会覆盖上面的方法，上面的方法是此方法的一个简化版
		cbm.cellFactoryProperty().set(new Callback<ListView<String>, ListCell<String>>() {

			@Override
			public ListCell<String> call(ListView<String> param) {
				// 这里的自定义ListCell必须实现updateItem方法才能被调用
				CusListCell<String> cus = new CusListCell<>();
				
				System.out.println(param.getItems());
				
				return cus;
			}
		});
		
		// 设置工厂方法，自定义单元格格式
		cbp.setCellFactory(new Callback<ListView<Person>, ListCell<Person>>() {

			@Override
			public ListCell<Person> call(ListView<Person> param) {
				ListCell<Person> listP = new ListCell<Person>() {

					@Override
					protected void updateItem(Person item, boolean empty) {
						super.updateItem(item, empty);
						if(!empty) {
							// 如果要保持一致可以从converter中获得对应的选项显示名称
//							this.setText(cbp.getConverter().toString(item));
							HBox hb  = new HBox(5);
							hb.setPadding(new Insets(0,0,0,30));
							hb.getChildren().addAll(ImageUtils.getImage("/icon/learning.png", 20, 20));
							hb.getChildren().addAll(new Label(item.getName()),new Label(String.valueOf(item.getAge())));
							this.setGraphic(hb);
						}
					}
					
				};
				return listP;
			}
		});
	}
}

class CusListCell<T> extends ListCell<String>{

	@Override
	protected void updateItem(String item, boolean empty) {
		
		super.updateItem(item, empty);
		
		System.out.println("empty = " + empty + "  item = " + item);
		
		if(!empty) {
			this.setText(item);
			OrganizeStyle.organize(this);
		}
		
	}
	
}

class Person{
	private String name;
	private int age;
	
	public Person(String name, int age) {
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

























