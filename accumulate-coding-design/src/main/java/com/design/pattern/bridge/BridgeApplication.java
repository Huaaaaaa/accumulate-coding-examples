package com.design.pattern.bridge;

import java.sql.*;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/14
 * Todo:  桥接模式在jdbc中的应用
 * Time 16:32
 */
public class BridgeApplication {

    public void operateDb() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");//加载及注册JDBC驱动程序
        String url = "jdbc:mysql://localhost:3306/test?user=root&password=123";
        Connection con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
        String query = "select * from test";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            rs.getString(1);
            rs.getInt(2);
        }
    }
}
