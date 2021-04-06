package Step1;


import java.sql.Connection;
import java.sql.DriverManager;

public class TheApplication {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "hbstudent";
        String password = "hbstudent";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl,username,password);
            System.out.println();
            System.out.println("Cool");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
