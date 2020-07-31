package com.example.demo.controller;

import com.example.demo.entity.Equipment;
import com.example.demo.entity.Material;
import com.example.demo.service.EquipService;
import com.example.demo.service.MaterialService;
import com.example.demo.tools.MyJsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/api/bg/admin")
public class AdminEquipmentController {
    @Autowired
    private MaterialService materialService;
    @Autowired
    private EquipService equipService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping("/bg_add_material")
    @ResponseBody
    public MyJsonResult add_material(@RequestBody Material material){

        logger.info(material.toString());
        if(materialService.add_material_info(material))
            return MyJsonResult.buildData("ok");
        return MyJsonResult.errorMsg("error");
    }

    @PostMapping("/bg_update_material")
    @ResponseBody
    public MyJsonResult edit_material(@RequestBody Material material){

        logger.info(material.toString());
        if(materialService.update_material_info(material))
            return MyJsonResult.buildData("ok");
        return MyJsonResult.errorMsg("error");
    }

    @PostMapping("/bg_add_equipment")
    @ResponseBody
    public MyJsonResult add_equipment(@RequestBody Equipment equipment){


        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);

        equipment.setEq_create_time(dateString);
        equipment.setEq_add_time(dateString);
        equipment.setEq_state(0);

        logger.info(equipment.toString());
        if(equipService.add_equipment_info(equipment))
            return MyJsonResult.buildData("ok");
        return MyJsonResult.errorMsg("error");
    }

    @PostMapping("/bg_update_equipment")
    @ResponseBody
    public MyJsonResult edit_equipment(@RequestBody Equipment equipment){

        Equipment oldEq = equipService.get_one_info(equipment.getEq_id());

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);

        equipment.setEq_add_time(dateString);
        equipment.setEq_state(0);
        equipment.setEq_create_time(oldEq.getEq_create_time());
        equipment.setEq_state(oldEq.getEq_state());

        logger.info(equipment.toString());
        if(equipService.update_equipment_info(equipment))
            return MyJsonResult.buildData("ok");
        return MyJsonResult.errorMsg("error");
    }

    @PostMapping("/del_equipment")
    @ResponseBody
    public MyJsonResult del_Equipment(@RequestBody String eq_id){
        System.out.println(eq_id);
        logger.info("del_equipment----eq_id:"+eq_id);

        if(equipService.del_equipment_info(eq_id))
            return MyJsonResult.buildData("ok");

        return MyJsonResult.errorMsg("error");
    }

    @PostMapping("/del_material")
    @ResponseBody
    public MyJsonResult del_material(@RequestBody String material_id){
        logger.info("del_material----material_id:"+material_id);

        if(materialService.del_material_info(material_id))
            return MyJsonResult.buildData("ok");

        return MyJsonResult.errorMsg("error");
    }

    @PostMapping("/del_equipments")
    @ResponseBody
    public MyJsonResult del_Equipments(@RequestBody String[] arr){
        logger.info("del_equipments----arr");
        boolean result = true;
        for (String eq_id: arr) {
            if(!equipService.del_equipment_info(eq_id)){
                result = false;
                break;
                // 事务回滚
            }
        }
        if(result)
            return MyJsonResult.buildData("ok");

        return MyJsonResult.errorMsg("error");
    }

    @PostMapping("/del_materials")
    @ResponseBody
    public MyJsonResult del_materials(@RequestBody String[] arr){
        logger.info("del_materials----arr");
        boolean result = true;
        for (String material_id: arr) {
            if(!materialService.del_material_info(material_id)){
                result = false;
                break;
                // 事务回滚

            }
        }
        if(result)
            return MyJsonResult.buildData("ok");

        return MyJsonResult.errorMsg("error");
    }
}
