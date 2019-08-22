package com.at.guigu.dao;

import com.at.guigu.bean.Employee;

import java.util.List;

public interface EmplolyeeDao {
    List<Employee> getEmployee();
    int deleteEmploee(int id);
    Employee findEmploee(int id);
    int saveEmployee(int id,String lastName,String email,double salary,String dept);
    boolean exisName(String lastName);
}
