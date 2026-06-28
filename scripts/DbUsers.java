import java.sql.*;
public class DbUsers {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_trabajoParcial", "postgres", "postgres");
        ResultSet rs = conn.createStatement().executeQuery("SELECT id, name, email FROM users WHERE role_id = 2");
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") + " - Nombre: " + rs.getString("name") + " - Email: " + rs.getString("email"));
        }
        conn.close();
    }
}
