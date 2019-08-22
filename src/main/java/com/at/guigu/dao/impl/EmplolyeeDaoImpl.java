package com.at.guigu.dao.impl;

import com.at.guigu.bean.Employee;
import com.at.guigu.dao.BaseDao;
import com.at.guigu.dao.EmplolyeeDao;

import java.util.List;

public class EmplolyeeDaoImpl extends BaseDao<Employee>implements EmplolyeeDao {
    @Override
    public List<Employee> getEmployee() {
        String sql = "select id,last_name lastName,email,salary,dept from employees";
        List<Employee> employeeList = getBeanList(sql);
        return employeeList;
    }

    @Override
    public int deleteEmploee(int id) {
        String sql = "delete from employees where id = ?";
        int update = update(sql, id);
        return update;
    }

    @Override
    public Employee findEmploee(int id) {
        String sql = "select id,last_name lastName,email,salary,dept from employees where id = ?";
        Employee bean = getBean(sql, id);
        return bean;
    }

    @Override
    public int saveEmployee(int id, String lastName, String email, double salary, String dept) {
        String sql = "update employees set last_name = ?,email = ?,salary = ?,dept = ? where id = ?";
        int update = update(sql, lastName, email, salary, dept, id);
        return update;
    }

    @Override
    public boolean exisName(String lastName) {
        String sql = "select id,last_name lastName,email,salary,dept from employees where last_name = ?";
        Employee bean = getBean(sql, lastName);
        return bean ==null;
    }
}
