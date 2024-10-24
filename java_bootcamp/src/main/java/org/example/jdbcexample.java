package org.example;

import java.sql.*;

public class jdbcexample {
    public static void main(String[] args) {

        String students[] = new String[3];
        students[0] = "rohit";
        students[1] = "raman";
        students[2] = "abhimanyu";
        System.out.println(students[1]);

        String url = "jdbc:mysql://localhost:3306/db_sgv";
        String user = "root";
        String password = "Sumit@23181508";
        try
        {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("insert into users (username, password, balance) values ('vikash','1234',16800)");
            stmt.executeUpdate("delete from users where id = 2;");
            ResultSet rs=stmt.executeQuery("select * from users");
            while(rs.next())
            {
                System.out.println(rs.getString("username"));
            }
            conn.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
