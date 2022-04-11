package lkj.jfx.day12;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.scene.control.Slider;

/**
 * 多任务更新进度条，定时任务 
 *
 */
public class ScheduleTaskExample extends ScheduledService<Integer>{

	int i = 0;
	Slider s;
	protected ScheduleTaskExample(Slider s) {
		this.s = s;
	}
	
	@Override
	protected Task<Integer> createTask() {
		
		// 匿名内部类
		Task<Integer> task = new Task<Integer>(){

			@Override
			protected Integer call() throws Exception {
				
				return i+=1;
			}

			// 从call() 方法中获取到的值会传入此方法，用来进行界面的更新
			@Override
			protected void updateValue(Integer value) {
				s.setValue(value);
				super.updateValue(value);
			}
			
		};
		
		return task;
	}

}
