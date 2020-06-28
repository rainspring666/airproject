package com.example.demo.service;

import com.example.demo.entity.Equipment;
import com.example.demo.mapper.EquipMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipService {
    @Autowired
    EquipMapper equipMapper;
    public Equipment get_one_info(String eq_id){

        return equipMapper.get_one_info(eq_id);
    }

    public List<Equipment> get_equipment_info(){

        return equipMapper.get_equipment_info();
    }
    public boolean update_equipment_info(Equipment equipment){

        return equipMapper.update_equipment_info(equipment);
    }

    public boolean add_equipment_info(Equipment equipment){

        return equipMapper.add_equipment_info(equipment);
    }

    public boolean del_equipment_info(String eq_id){

        return equipMapper.del_equipment_info(eq_id);
    }
}
