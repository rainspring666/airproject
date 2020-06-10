package com.example.demo.service;

import com.example.demo.entity.Process;
import com.example.demo.mapper.ProcessMapper;
import org.apache.tomcat.jni.Proc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessService {
    @Autowired
    ProcessMapper processMapper;
    public Process get_one_info(String id){
        return processMapper.get_one_info(id);
    }
    public Process get_one_info2(String id){
        return processMapper.get_one_info2(id);
    }
    public boolean update_info(Process process){
        return processMapper.update_info(process);
    }
    public List<Process> get_my_process(String id){
        return processMapper.get_my_process(id);
    }
    public boolean add_process(Process process){
        return processMapper.add_process(process);
    }
}
