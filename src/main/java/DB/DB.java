package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

    public static Statement stmt;
    public static Connection conn;

    public static void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/chams", "root", "0000");

            stmt = conn.createStatement();
            System.out.println("접속 완료");
        } catch (ClassNotFoundException e) {
            System.out.println("예외 발생 : 해당 드라이버가 없습니다.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("예외 발생 : 접속 정보 확인이 필요합니다.");
            e.printStackTrace();
        }

    }
    // 조회용
    public static ResultSet getResult(String sql) {
        try {
            stmt = conn.createStatement();
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 수정용
    public static void executeSQL(String sql) {
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
