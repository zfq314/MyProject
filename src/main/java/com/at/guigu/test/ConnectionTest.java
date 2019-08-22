package com.at.guigu.test;

import com.at.guigu.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

public class ConnectionTest {
    @Test
    public void testConnection(){
        Connection connection = JDBCUtils.getConnection();
        System.out.println(connection);
    }
}
