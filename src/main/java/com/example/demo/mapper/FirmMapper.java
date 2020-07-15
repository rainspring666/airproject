package com.example.demo.mapper;

import com.example.demo.entity.Firm;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FirmMapper {

    List<Firm> get_all_firm_info();

    boolean add_firm(Firm firm);

    boolean update_firm_info(Firm firm);
}
