package com.example.demo.mapper;

import com.example.demo.entity.Data;
import org.springframework.stereotype.Repository;

@Repository
public interface DataMapper {
    public boolean add_data(Data data);
}
