package com.example.demo.tools;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * FL 2018/9/27 总结
 */
public class pdfUtil {
	public static String pdfout(Map<String, Object> o) {
		String baseTemplatePath = "pdf/template/template.pdf";
		String bastOutputPath = "pdf/output/"+ UUID.randomUUID().toString()+".pdf";
		String bastFontPath = "pdf/resource/simsun.ttc,1";
		// 模板路径
		String templatePath = Tool.UPLOAD_PICTURE_PATH + baseTemplatePath;
		// 生成的新文件路径
		String newPDFPath = Tool.UPLOAD_PICTURE_PATH + bastOutputPath;
		// 设置字体路径
		String baseFont = Tool.UPLOAD_PICTURE_PATH+ bastFontPath;
		PdfReader reader;
		FileOutputStream out;
		ByteArrayOutputStream bos;
		PdfStamper stamper;
		try {
			BaseFont bf = BaseFont.createFont(baseFont, BaseFont.IDENTITY_H,
					BaseFont.EMBEDDED);
			Font FontChinese = new Font(bf, 5, Font.NORMAL);
			out = new FileOutputStream(newPDFPath);// 输出流
			reader = new PdfReader(templatePath);// 读取pdf模板
			bos = new ByteArrayOutputStream();
			stamper = new PdfStamper(reader, bos);
			AcroFields form = stamper.getAcroFields();
			Map<String, String> datemap = (Map<String, String>) o.get("datemap");
			form.addSubstitutionFont(bf);
			for (String key : datemap.keySet()) {
				String value = datemap.get(key);
				form.setField(key, value);
			}
			// 图片类的内容处理
			Map<String, String> imgmap = (Map<String, String>) o.get("imgmap");
			for (String key : imgmap.keySet()) {
				String value = imgmap.get(key);
				String imgpath = value;
				int pageNo = form.getFieldPositions(key).get(0).page;
				Rectangle signRect = form.getFieldPositions(key).get(0).position;
				float x = signRect.getLeft();
				float y = signRect.getBottom();
				// 根据路径读取图片
				Image image = Image.getInstance(imgpath);
				// 获取图片页面
				PdfContentByte under = stamper.getOverContent(pageNo);
				// 图片大小自适应
				image.scaleToFit(signRect.getWidth(), signRect.getHeight());
				// 添加图片
				image.setAbsolutePosition(x, y);
				under.addImage(image);
			}
			stamper.setFormFlattening(true);// 如果为false，生成的PDF文件可以编辑，如果为true，生成的PDF文件不可以编辑
			stamper.close();
			Document doc = new Document();
			Font font = new Font(bf, 32);
			PdfCopy copy = new PdfCopy(doc, out);
			doc.open();
			PdfImportedPage importPage = null;
			/// 循环是处理成品只显示一页的问题
			for (int i = 1; i <= reader.getNumberOfPages(); i++) {
				importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), i);
				copy.addPage(importPage);
			}
			doc.close();
			// 返回生成的报告路径
			return bastOutputPath;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}