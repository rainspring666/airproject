package com.example.demo.mapper;

import com.example.demo.entity.Material;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface MaterialMapper {
    public List<Material> get_material_info();
    public boolean update_material_info(Material material);
    public boolean add_material_info(Material material);
    public boolean del_material_info(String material_id);
    public Material get_one_info(String material_id);
}
