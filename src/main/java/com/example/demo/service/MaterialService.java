package com.example.demo.service;

import com.example.demo.entity.Material;
import com.example.demo.mapper.MaterialMapper;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;



@Service
public class MaterialService {


    @Autowired
    MaterialMapper materialMapper;

    public boolean pdf_operator() throws IOException, DocumentException {

        Document document = new Document(PageSize.A4);
        PdfWriter instance = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\申岩松\\Desktop\\new.pdf"));

        document.open();
        BaseFont bfComic = BaseFont.createFont("c://windows//fonts//SIMHEI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font font = new Font(bfComic, 14);
        String text1 = "我是第一段";
        document.add(new Paragraph(text1, font));
        return true;
    }



    public List<Material> get_material_by_params(String material_id, String ma_name){
        if(material_id.equals("") && ma_name.equals(""))
            return get_material_info();
        List<Material> materialList = new LinkedList<>();
        List<Material> materialList_id = new LinkedList<>(), materialList_name = new LinkedList<>();
        if(!material_id.equals("")){
            materialList_id = materialMapper.get_material_by_material_id(material_id);
        }
        if(!ma_name.equals("")){
            materialList_name = materialMapper.get_material_by_ma_name(ma_name);
        }
        for (Material i: materialList_id) {
            materialList.add(i);
        }
        for (Material i: materialList_name) {
            boolean contain = false;
            for (Material j: materialList_id) {
                if(i.getMaterial_id().equals(j.getMaterial_id())){
                    contain = true; break;
                }
            }
            if(!contain)
                materialList.add(i);
        }
        return materialList;
    }

    public List<Material> get_material_info(){

        return materialMapper.get_material_info();
    }
    public Material get_one_info(String materail_id){

        return materialMapper.get_one_info(materail_id);
    }
    public boolean update_material_info(Material material){

        return materialMapper.update_material_info(material);
    }

    public boolean add_material_info(Material material){

        // 检查是否编号重复
        // 是否要保证物料名称独立？？？？？

        Material old_material = get_one_info(material.getMaterial_id());
        if(old_material != null)
            return false;
        return materialMapper.add_material_info(material);
    }
    public boolean del_material_info(String material_id){

        return materialMapper.del_material_info(material_id);
    }

    public List<Material> get_exist_material(){
        List<Material> materialList = new LinkedList<>();
        List<Material> allMaterial = materialMapper.get_material_info();
        for (Material i: allMaterial) {
            if(i.getMa_number() >= 0)
                materialList.add(i);
        }
        return materialList;
    }
}
