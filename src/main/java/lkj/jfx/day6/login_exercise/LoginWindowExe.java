package lkj.jfx.day6.login_exercise;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoginWindowExe extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Label l_name = new Label("姓名：");
		l_name.setFont(Font.font(14));
		
		Label l_password = new Label("密码：");
		l_password.setFont(Font.font(14));
		
		TextField t_name = new TextField();
		PasswordField p_password = new PasswordField();

		// Node组件都有一些通用的方法，比如setUserData()、getProperties()等，用来设置一些绑定的数据
		t_name.setUserData("1111");
		t_name.setTooltip(new Tooltip("请输入账号"));
		p_password.setUserData("1234");
		p_password.setTooltip(new Tooltip("请输入密码"));
		
		
		Button login = new Button("登录");
		Button clear = new Button("清空");
		
		GridPane gr = new GridPane();
		gr.setStyle("-fx-background-color: #FFEFD5");
		gr.setAlignment(Pos.CENTER);
		
		gr.add(l_name, 0, 0);
		gr.add(l_password, 0, 1);
		gr.add(t_name, 1, 0);
		gr.add(p_password, 1, 1);
		gr.add(login, 0, 2);
		gr.add(clear, 1, 2);
		
		// 设置组件间的水平间距
		gr.setHgap(10);
		// 设置组件间的垂直间距
		gr.setVgap(15);
		GridPane.setMargin(clear, new Insets(0,0,0,120));
		
		clear.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				t_name.clear();
				p_password.clear();
				
			}
		});
		
		login.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String name = t_name.getText();
				String password = p_password.getText();
				
				if(t_name.getUserData().equals(name) && p_password.getUserData().equals(password)) {
					
					System.out.println("登录成功");
					new MainWindow(name, password);
					primaryStage.close();
					
				}else {
					System.out.println("登录失败");
					primaryStage.setTitle("账号或者密码错误");
					
					// 可以快速设置颜色，也可以通过setTextFill(Paint.valueOf(x,x,x))的方式设置颜色
					l_name.setTextFill(Color.RED);
					l_password.setTextFill(Color.RED);
					
					// 添加一点动画效果，FadeTransition：变化组件的颜色深浅，类似呼吸灯
					FadeTransition ft = new FadeTransition();
					// 设置变化的时间间隔
					ft.setDuration(Duration.seconds(1));
					// 会同时给所有子节点添加效果
					ft.setNode(gr);
					// 变化透明度的起始和终点
					ft.setFromValue(0);
					ft.setToValue(1);
					// 动画开始播放
					ft.play();
					
					
				}
			}
		});
		
		
		primaryStage.setScene(new Scene(gr));
		primaryStage.setTitle("登录窗口");
		primaryStage.setHeight(300);
		primaryStage.setWidth(500);
		primaryStage.setX(0);
		primaryStage.show();
		
	}

}

class MainWindow{
	private final Stage stage = new Stage();
	
	public MainWindow(String name, String password) {
		
		Text t = new Text("账号：" +name+ "密码：" +password+ "，欢迎登录！");
		BorderPane bp = new BorderPane();
		bp.setStyle("-fx-backtround-color: #DD21CC");
		bp.setCenter(t);
		
		Scene sc = new Scene(bp);
		stage.setScene(sc);
		stage.setHeight(500);
		stage.setWidth(500);
		stage.setTitle("登录成功");
		stage.show();
	}
}


















