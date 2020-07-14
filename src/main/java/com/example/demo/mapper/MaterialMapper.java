package com.example.demo.mapper;

import com.example.demo.entity.Material;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface MaterialMapper {
    List<Material> get_material_info();

    boolean update_material_info(Material material);

    boolean add_material_info(Material material);

    boolean del_material_info(String material_id);

    Material get_one_info(String material_id);

    List<Material> get_material_by_material_id(String material_id);

    List<Material> get_material_by_ma_name(String ma_name);

}
