package com.example.demo.mapper;

import com.example.demo.entity.Report;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportMapper {

    List<Report> get_all_report_info();

    boolean add_report(Report report);

    boolean update_report_info(Report report);

    Report get_report_by_report_id(String report_id);
}
