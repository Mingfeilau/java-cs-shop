package com.Jie.Dao;
import java.sql.*;
import java.util.ResourceBundle;
/**
 * Created by Jie on 2016/01/15.
 */
public class DBUtils {
    //数据库连接地址
    public static String URL;
    //用户名
    public static String USERNAME;
    //密码
    public static String PASSWORD;
    //mysql的驱动类
    public static String DRIVER;
    private DBUtils(){
    	
    }
    //使用静态块加载驱动程序
    static{
        URL = "jdbc:mysql://localhost:3306/shop";
        USERNAME = "root";
        PASSWORD = "root";
        DRIVER = "com.mysql.jdbc.Driver";
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //定义一个获取数据库连接的方法
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取连接失败");
        }
        finally {
            return conn;
        }
    }
    /**
     * 关闭数据库连接
     */
    public static void close(ResultSet rs,Statement stat,Connection conn){
        try {
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
            if(conn!=null)conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
