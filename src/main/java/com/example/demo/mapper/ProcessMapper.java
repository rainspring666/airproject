package com.example.demo.mapper;

import com.example.demo.entity.Process;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessMapper {
    List<Process> get_my_process(String id);

    Process get_one_info(String process_id);

    Process get_one_info2(String order_id);



    boolean update_info(Process process);

    boolean add_process(Process process);

}
