/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author wlw
 * 
 * this class just for MySQL databases 
 * if you want to use this class, you should copy jdbc-odbc jar package to related folder
 * codes references: http://www.cnblogs.com/wuyuegb2312/p/3872607.html
 */


public class MySqlHandle {
    String driver;
    String url;
    String userName;
    String passwd;
    Connection con;
    public MySqlHandle()
    {
    }
    
    public MySqlHandle(String driver, String url, String userName, String passwd)
    {
        this.driver = driver;
        this.url = url;
        this.userName = userName;
        this.passwd = passwd;
        //加载驱动程序
        try {
            Class.forName(driver);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void SetSqlParam(String driver, String url, String userName, String passwd)
    {
        this.driver = driver;
        this.url = url;
        this.userName = userName;
        this.passwd = passwd;
        //加载驱动程序
        try {
            Class.forName(driver);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public Connection GetConnection()
    {
        try {
        con = (Connection) DriverManager.getConnection(url, userName, passwd);
        } catch(SQLException e)
        {
            e.printStackTrace();
        }
        return con;
    }
    
    public Connection GetConnection(String url,String userName, String passwd)
    {
        try {
        con = (Connection) DriverManager.getConnection(url, userName, passwd);
        } catch(SQLException e)
        {
            e.printStackTrace();
        }
        return con;
    }
    
    //增删改查
    public int insert(SqlDataModel data)
    {
        Connection conn = GetConnection();
        int i = 0;
        String sql = "insert into students (Name,Age) values(?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, data.getName());
            pstmt.setString(2, data.getAge());
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return i;
    }
    
    public int update(SqlDataModel data)
    {
        Connection conn = GetConnection();
        int i = 0;
        String sql = "update students set Age='" + data.getAge() + "' where Name='" + data.getName() + "'";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
            System.out.println("resutl: " + i);
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    
    public void query()
    {
        Connection conn = GetConnection();
        String sql = "select * from students";
        PreparedStatement pstmt;
        try 
        {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            while (rs.next())
            {
                for (int i = 1; i <= col; i++) 
                {
                    System.out.print(rs.getString(i) + "\t");
                    if ((i == 2) && (rs.getString(i).length() < 8)) 
                    {
                        System.out.print("\t");
                    }
                }
                System.out.println("");
            }
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
    
    public int delete(SqlDataModel data)
    {
        Connection conn = GetConnection();
        int i = 0;
        String sql = "delete from students where Name='" + data.name + "'";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
            System.out.println("resutl: " + i);
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    
    
    
}
