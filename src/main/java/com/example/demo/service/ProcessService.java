package com.example.demo.service;

import com.example.demo.entity.Process;
import com.example.demo.mapper.ProcessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessService {
    @Autowired
    ProcessMapper processMapper;
    public List<Process> get_my_process(String id){
        return processMapper.get_my_process(id);
    }
}
