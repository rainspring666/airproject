package com.example.demo.mapper;

import com.example.demo.entity.Equipment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface EquipMapper {
    public List<Equipment> get_material_info();
    public boolean update_material_info(Equipment equipment);
    public boolean add_material_info(Equipment equipment);
    public boolean del_material_info(String ep_id);
    public Equipment get_one_info(String ep_id);
}
