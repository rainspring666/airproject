package com.example.demo.service;

import com.example.demo.entity.Data;
import com.example.demo.mapper.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    @Autowired
    DataMapper dataMapper;

    public boolean add_data(Data data){
        return dataMapper.add_data(data);
    }
}
