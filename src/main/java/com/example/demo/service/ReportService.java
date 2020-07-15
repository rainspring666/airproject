package com.example.demo.service;

import com.example.demo.entity.Report;
import com.example.demo.mapper.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportMapper reportMapper;

    List<Report> get_all_report(){
        return reportMapper.get_all_report_info();
    }

    boolean add_report(Report report){
        return reportMapper.add_report(report);
    }

    boolean update_report(Report report){
        return reportMapper.update_report_info(report);
    }

    Report get_report_by_id(String report_id){
        return reportMapper.get_report_by_report_id(report_id);
    }
}
