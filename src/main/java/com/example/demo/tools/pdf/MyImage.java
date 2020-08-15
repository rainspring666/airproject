package com.example.demo.tools.pdf;

import com.itextpdf.text.Image;

public class MyImage {
	private Image image = null;

	/**
	 * @param path
	 */
	public MyImage(String path) {
		try {
			this.image = Image.getInstance(path);
			initImage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param path
	 * @param newHeight
	 */
	public MyImage(String path, float newHeight) {
		try {
			this.image = Image.getInstance(path);
			initImage();
			this.scaleAbsoluteImageHeight(newHeight);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Image getImage() {
		return image;
	}

	/**
	 * @description: 使用自定义的Image
	 * @param image
	 */
	public void setImage(Image image) {
		this.image = image;
		initImage();
	}

	/**
	 * @description: 使用自定义的Image 以及缩放比例
	 * @param image
	 * @param newHeight
	 */
	public void setImage(Image image, float newHeight) {
		this.image = image;
		initImage();
		this.scaleAbsoluteImageHeight(newHeight);
	}

	private void initImage() {
		this.image.setAlignment(Image.ALIGN_CENTER);
		this.image.setIndentationLeft(40f);
		this.image.setIndentationRight(40f);
	}

	/**
	 * @description: 将图像缩放到绝对高度，同时宽度等比例缩放
	 * @param newHeight
	 * @return void
	 */
	public void scaleAbsoluteImageHeight(float newHeight) {
		// 获得原始宽度
		final float width = image.getWidth();
		// 获得原始宽度
		final float height = image.getHeight();
		// 计算缩放比例
		float percent = height / newHeight;
		// 计算宽度缩放的绝对值
		float newWidth = width / percent;
		// 调用函数进行缩放
		image.scaleAbsolute(newWidth, newHeight);
	}

}
