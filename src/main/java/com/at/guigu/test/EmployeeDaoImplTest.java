package com.at.guigu.test;

import com.at.guigu.bean.Employee;
import com.at.guigu.dao.EmplolyeeDao;
import com.at.guigu.dao.impl.EmplolyeeDaoImpl;
import org.junit.Test;

import java.util.List;

public class EmployeeDaoImplTest {
    EmplolyeeDao emplolyeeDao = new EmplolyeeDaoImpl();
    @Test
    public  void test(){

        List<Employee> employee = emplolyeeDao.getEmployee();
        for (Employee employee1 : employee) {
            System.out.println(employee1);
        }
    }
    @Test
    public void test2(){
        int i = emplolyeeDao.deleteEmploee(9);
        System.out.println(i);
    }
    @Test
    public void  test3(){
        Employee emploee = emplolyeeDao.findEmploee(52);
        System.out.println(emploee);
    }
    @Test
    public  void  test4(){
        int update = emplolyeeDao.saveEmployee(19, "马晓龙", "mxl@163.com", 5000.00, "采购部");
        System.out.println(update);
    }
    @Test
    public  void test5(){
        boolean flag = emplolyeeDao.exisName("韩延冰");
        System.out.println(flag);
    }
}
