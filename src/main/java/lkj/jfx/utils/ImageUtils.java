package lkj.jfx.utils;

import javafx.scene.image.ImageView;

public class ImageUtils {
	
	public static ImageView getImage(String url) {
		return new ImageView(ImageUtils.class.getResource("/icon/learning.png").toExternalForm());
	}
	public static ImageView getImage(String url, double width, double height) {
		ImageView image = getImage(url);
		image.setFitWidth(width);
		image.setFitHeight(height);
		return image;
	}

}
