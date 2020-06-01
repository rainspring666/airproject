package com.example.demo.mapper;

import com.example.demo.entity.Process;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessMapper {
    List<Process> get_my_process(String id);
}
