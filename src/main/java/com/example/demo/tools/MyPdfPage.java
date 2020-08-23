package com.example.demo.tools;

import com.example.demo.tools.pdf.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyPdfPage {
	// main测试
	public static void main(String[] args) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("order_contact", "武汉理工大学");
		map.put("order_address", "湖北武汉洪山区珞狮路");
		map.put("service_item", "办公空间消毒杀菌");
		map.put("order_time", "2020-08-12");
		map.put("report_time", "2020-08-15");
		map.put("op_describe",
				"针对西班牙多地疫情近来出现反弹，西班牙卫生部14日与各自治区政府进行协商后就新的防疫政策达成一致，制订了11项措施。西班牙卫生大臣伊利亚在当天举行的新闻发布会上说，这些只是“最低限度”的防疫措施，各自治区可采取更加严格的措施。");
		map.put("op_situation",
				"根据西班牙卫生部颁布的新规，所有餐馆须在凌晨1点前关门，且午夜后不得接纳新顾客；在餐馆等场所，人与人之间须保持至少1.5米的安全距离；由于夜生活场所近来成为疫情聚集性传播的主要源头之一，迪厅、酒吧和舞厅等在疫情期间不能开门营业。此外，在该国境内所有街道上，如果行人不能与他人保持至少两米的安全距离，将禁止吸烟。");
		map.put("valid", "效果很好");
		map.put("op_id", "张三");
		map.put("checker", "李四");
		map.put("order_id", "123124124514341");
		String pdfPath = createPdfDoc(map);
		System.out.println(pdfPath);
	}

	public static String createPdfDoc(Map<String, String> map) {
		try {
			// 1. 1.新建document对象 A4
			Document document = new Document(PageSize.A4);// 建立一个Document对象
			// 2.建立一个书写器(Writer)与document对象关联
			String bastOutputPath = "pdf/output/"+map.get("order_id")+"/"+ UUID.randomUUID().toString()+".pdf";
			String pdfAbsolutePath = Tool.UPLOAD_PICTURE_PATH + bastOutputPath;
			File pdfFile = new File(pdfAbsolutePath);
			File fileParent = pdfFile.getParentFile();
			if (!fileParent.exists()) {
				// 能创建多级目录
				fileParent.mkdirs();
			}
			if (!pdfFile.exists()) {
				// 有路径才能创建文件
				pdfFile.createNewFile();
			}

			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfFile));
			// 3.打开文档
			document.open();
			document.addTitle("项目施工报告");// 标题
			document.addAuthor("Author@whut");// 作者
			document.addSubject("Subject@pdf");// 主题
			document.addKeywords("Keywords@iTextpdf");// 关键字
			document.addCreator("Creator@hhm");// 创建者

			createFirstPage(document, map);

			document.add(new MyHead("一、概述"));
			document.add(new MyParagraph(map.get("op_describe")));

			document.add(new MyHead("二、标的现场情况描述"));
			document.add(new MyParagraph(map.get("op_situation")));

			document.add(new MyHead("三、 消杀作业"));
			document.add(new MyParagraph(delHTMLTag(map.get("op_process"))));

			document.add(new MyParagraph("1.消毒消杀点位"));
			String pro_generator = map.get("pro_generator");
			String[] generators = pro_generator.split("@");
			int length = generators.length;
			int count  = length / 2;
			int even = length % 2;
			for (int i =0; i< 2*count; i=i+2){
				MyImage image0 = new MyImage(Tool.UPLOAD_PICTURE_PATH+generators[i]);
				MyImage image1 = new MyImage(Tool.UPLOAD_PICTURE_PATH+generators[i+1]);
				image0.scaleAbsoluteImageHeight(100f);
				image1.scaleAbsoluteImageHeight(100f);
				MyTable table = new MyTable(2);
				table.addImage(image0.getImage());
				table.addImage(image1.getImage());
				document.add(table);
			}
			// 如果是奇数张图
			if (even == 1){
				MyImage image = new MyImage(Tool.UPLOAD_PICTURE_PATH+generators[length-1]);
				image.scaleAbsoluteImageHeight(100f);
				MyTable table = new MyTable(1);
				table.addImage(image.getImage());
				document.add(table);
			}

			document.add(new MyParagraph("2.作业描述"));
			String describes = map.get("describes");
			String[] str_describes = describes.split("#");
			length = str_describes.length;
			for (int i = 0; i<length; i++){
				document.add(new MyParagraph(str_describes[i]));
			}

			document.add(new MyParagraph("3.作业现场图片"));
			String picurl = map.get("picurl");
			String[] pictureUrls = picurl.split("@#");
			length = pictureUrls.length;
			count  = length / 2;
			even   = length % 2;
			for (int i =0; i< 2*count; i=i+2){
				MyImage image0 = new MyImage(Tool.UPLOAD_PICTURE_PATH+pictureUrls[i]);
				MyImage image1 = new MyImage(Tool.UPLOAD_PICTURE_PATH+pictureUrls[i+1]);
				image0.scaleAbsoluteImageHeight(100f);
				image1.scaleAbsoluteImageHeight(100f);
				MyTable table = new MyTable(2);
				table.addImage(image0.getImage());
				table.addImage(image1.getImage());
				document.add(table);
			}
			// 如果是奇数张图
			if (even == 1){
				MyImage image = new MyImage(Tool.UPLOAD_PICTURE_PATH+pictureUrls[length-1]);
				image.scaleAbsoluteImageHeight(100f);
				MyTable table = new MyTable(1);
				table.addImage(image.getImage());
				document.add(table);
			}

			document.add(new MyHead("四、 效果验证"));
			document.add(new MyParagraph(map.get("valid")));
			final String blank = "                                                ";
			MyForm myForm = new MyForm("现场负责：" + map.get("op_id") + blank + "审核：" + map.get("checker"),
					MyFontUtil.TEXT_NORMAL_FONT, 0);
			myForm.setLayout(80f, 40f, 20f, 40f, 40f);

			MyForm myForm1 = new MyForm("黑龙江省祥汇健康科技有限公司", MyFontUtil.TEXT_NORMAL_FONT, 0);
			myForm1.setLayout(80f, 40f, 20f, 8f, 8f);

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date reportDate = formatter.parse(map.get("report_time"));
			formatter = new SimpleDateFormat("yyyy 年  MM 月  dd 日");
			final String stringDate = formatter.format(reportDate);
			MyForm myForm2 = new MyForm(stringDate + blank + "空气治理溯源二维码", MyFontUtil.TEXT_NORMAL_FONT, 0);
			myForm2.setLayout(80f, 40f, 20f, 8f, 8f);

			final String path = "C:/Users/mhh/Desktop/A/QRCode.png";
			PdfPTable qrTable = addQRCodeImage(path);

			document.add(myForm);
			document.add(myForm1);
			document.add(myForm2);
			document.add(qrTable);
			// 5.关闭文档
			document.close();
			return bastOutputPath;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private  static  String delHTMLTag(String htmlStr){
		String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式
		String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式
		String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式

		Pattern p_script= Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
		Matcher m_script=p_script.matcher(htmlStr);
		htmlStr=m_script.replaceAll(""); //过滤script标签

		Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
		Matcher m_style=p_style.matcher(htmlStr);
		htmlStr=m_style.replaceAll(""); //过滤style标签

		Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
		Matcher m_html=p_html.matcher(htmlStr);
		htmlStr=m_html.replaceAll(""); //过滤html标签

		return htmlStr.trim(); //返回文本字符串
	}

	private static PdfPTable addQRCodeImage(String path) {
		MyImage qrCodeImage = new MyImage(path);
		qrCodeImage.scaleAbsoluteImageHeight(100f);
		qrCodeImage.getImage().setAlignment(2);
		qrCodeImage.getImage().setIndentationRight(85f);

		PdfPCell pdfCell = new PdfPCell();
		pdfCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		pdfCell.setBorder(0);
		pdfCell.setPaddingRight(85f);
		pdfCell.addElement(qrCodeImage.getImage());

		PdfPTable table = new PdfPTable(1);
		table.setHorizontalAlignment(2);
		table.addCell(pdfCell);
		return table;
	}

	private static void createFirstPage(Document document, Map<String, String> map) throws DocumentException {
		// 4.向文档中添加内容
		MyForm myForm1 = new MyForm("黑龙江省祥汇健康科技有限公司", MyFontUtil.TEXT_BLOD_FONT, 0);
		myForm1.setLayout(40f, 40f, 10f, 0f, 10f);
		MyForm myForm2 = new MyForm(map.get("order_contact"), MyFontUtil.TITLE_FONT, 1);
		myForm2.setLayout(85f, 85f, 40f, 60f, 60f);
		MyForm myForm3 = new MyForm("办公空间消毒杀菌作业报告", MyFontUtil.SUB_TITLE_FONT, 1);
		myForm3.setLayout(40f, 40f, 40f, 60f, 120f);
		MyForm myForm4 = new MyForm("客户名称：   " + map.get("order_contact"), MyFontUtil.TEXT_NORMAL_FONT, 0);
		myForm4.setLayout(130f, 130f, 10f, 8f, 8f);
		MyForm myForm5 = new MyForm("施工地址：   " + map.get("order_address"), MyFontUtil.TEXT_NORMAL_FONT, 0);
		myForm5.setLayout(130f, 130f, 10f, 8f, 8f);
		MyForm myForm6 = new MyForm("服务项目：   " + map.get("service_item"), MyFontUtil.TEXT_NORMAL_FONT, 0);
		myForm6.setLayout(130f, 130f, 10f, 8f, 8f);
		MyForm myForm7 = new MyForm("实施日期：   " + map.get("order_time"), MyFontUtil.TEXT_NORMAL_FONT, 0);
		myForm7.setLayout(130f, 130f, 10f, 8f, 8f);
		MyForm myForm8 = new MyForm("报告日期：   " + map.get("report_time"), MyFontUtil.TEXT_NORMAL_FONT, 0);
		myForm8.setLayout(130f, 130f, 10f, 8f, 8f);
		MyForm myForm9 = new MyForm("黑龙江省祥汇健康科技有限公司", MyFontUtil.TEXT_NORMAL_FONT, 1);
		myForm9.setLayout(40f, 40f, 10f, 100f, 0f);

		MyForm myForm10 = new MyForm("  ", MyFontUtil.TEXT_BLOD_FONT, 0);

		document.add(myForm1);
		document.add(myForm2);
		document.add(myForm3);
		document.add(myForm4);
		document.add(myForm5);
		document.add(myForm6);
		document.add(myForm7);
		document.add(myForm8);
		document.add(myForm9);
		document.add(myForm10);
		document.add(myForm10);
		document.add(myForm10);
		document.add(myForm10);
		document.add(myForm10);
		document.add(myForm10);
		document.add(myForm10);
	}
}
