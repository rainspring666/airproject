package com.example.demo.tools.pdf;

import com.itextpdf.text.Paragraph;

public class MyHead extends Paragraph {

	private static final long serialVersionUID = 1L;

	/**
	 * @param string    文本内容
	 * @param font      字体
	 * @param alignment 0靠左 1，居中 2，靠右
	 */
	public MyHead(String string) {
		// 设置字体
		this.setFont(MyFontUtil.TEXT_BLOD_FONT);
		// 左对齐
		this.setAlignment(0);
		// 设置左缩进
		this.setIndentationLeft(40f);
		// 设置右缩进
		this.setIndentationRight(40f);
		// 设置行间距
		this.setLeading(10f);
		// 设置段落上空白
		this.setSpacingBefore(15f);
		// 设置段落下空白
		this.setSpacingAfter(15f);
		// 设置内容
		this.add(string);
	}

}
