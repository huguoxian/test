package com.itheima.jdbcdemo;
import java.sql.*;

public class testMysql{
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "tiger";
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);
            String sql = "select * from emp";
            pstm =con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()) {
                int empno = rs.getInt("empno");
                String ename =rs.getString("ename");
                double sal = rs.getDouble("sal");
                Date hiredate =rs.getDate("hiredate");
                int deptno = rs.getInt(("deptno"));
                System.out.println(empno +"\t"+ ename +"\t"+ sal +"\t"+ hiredate +"\t"+ deptno);
            }

            flag = true;
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(pstm !=null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            try {
                if(con != null &&(!con.isClosed())) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(flag) {
            System.out.println("abc");
        } else {
            System.out.println("def");
        }
    }
}
