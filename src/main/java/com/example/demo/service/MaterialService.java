package com.example.demo.service;

import com.example.demo.entity.Material;
import com.example.demo.mapper.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {

    @Autowired
    MaterialMapper materialMapper;
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
        return materialMapper.add_material_info(material);
    }
    public boolean del_material_info(String material_id){
        return materialMapper.del_material_info(material_id);
    }
}
