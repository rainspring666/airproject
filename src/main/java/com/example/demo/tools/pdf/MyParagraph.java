package com.example.demo.tools.pdf;

import com.itextpdf.text.Paragraph;

public class MyParagraph extends Paragraph {

	private static final long serialVersionUID = 1L;

	public MyParagraph() {
		initParagraph();
	}

	public MyParagraph(String string) {
		initParagraph();
		this.add(string);
	}

	/**
	 * @describe: 实例化段落并初始化段落格式 @return void @throws
	 */
	private void initParagraph() {
		// 设置字体为宋体四号正常字体
		this.setFont(MyFontUtil.TEXT_NORMAL_FONT);
		// 设置文字居中 0靠左 1，居中 2，靠右
		this.setAlignment(0);
		// 设置左缩进
		this.setIndentationLeft(40f);
		// 设置右缩进
		this.setIndentationRight(40f);
		// 设置首行缩进
		this.setFirstLineIndent(24f);
		// 设置行间距
		this.setLeading(20f);
		// 设置段落上空白
		this.setSpacingBefore(6f);
		// 设置段落下空白
		this.setSpacingAfter(6f);
	}

}
