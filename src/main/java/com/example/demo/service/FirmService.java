package com.example.demo.service;

import com.example.demo.entity.Firm;
import com.example.demo.mapper.FirmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirmService {

    @Autowired
    private FirmMapper firmMapper;

    List<Firm> get_all_firm(){
        return firmMapper.get_all_firm_info();
    }

    boolean add_firm(Firm firm){
        return firmMapper.add_firm(firm);
    }

    boolean update_firm_info(Firm firm){
        return firmMapper.update_firm_info(firm);
    }
}
