package com.example.demo.tools.pdf;

import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;

public class MyForm extends Paragraph {

	private static final long serialVersionUID = 1L;

	/**
	 * @param string    内容
	 * @param font      字体
	 * @param alignment 0 靠左,1 居中, 2 靠右
	 */
	public MyForm(String string, Font font, int alignment) {
		this.setFont(font);
		this.setAlignment(alignment);
		this.add(string);
	}

	/**
	 * @description: 		设置排版
	 * @param left          左缩进
	 * @param right         右缩进
	 * @param leading       行间距
	 * @param spacingBefore 段落上空白
	 * @param spacingAfter  段落下空白
	 */
	public void setLayout(float left, float right, float leading, float spacingBefore, float spacingAfter) {
		// 设置左缩进
		this.setIndentationLeft(left);
		// 设置右缩进
		this.setIndentationRight(right);
		// 设置行间距
		this.setLeading(leading);
		// 设置段落上空白
		this.setSpacingBefore(spacingBefore);
		// 设置段落下空白
		this.setSpacingAfter(spacingAfter);
	}

}
