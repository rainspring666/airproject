package com.example.demo.tools.pdf;

import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;

public class MyFontUtil {
	// 定义全局的字体静态变量
	public static Font TITLE_FONT; // 文档标题字体
	public static Font SUB_TITLE_FONT; // 小标题的字体
	public static Font HEAD_FONT; // 章节标题字体
	public static Font TEXT_BLOD_FONT; // 正文加粗字体
	public static Font TEXT_NORMAL_FONT; // 正文正常字体
	// 静态代码块
	static {
		try {
			// 不同字体（这里定义为同一种字体：包含不同字号、不同style）
			BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			TITLE_FONT = new Font(bfChinese, 24f, Font.BOLD);
			SUB_TITLE_FONT = new Font(bfChinese, 20f, Font.BOLD);
			HEAD_FONT = new Font(bfChinese, 14f, Font.BOLD);
			TEXT_BLOD_FONT = new Font(bfChinese, 13.5f, Font.BOLD);
			TEXT_NORMAL_FONT = new Font(bfChinese, 13.5f, Font.NORMAL);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
