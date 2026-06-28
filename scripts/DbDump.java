import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbDump {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_trabajoParcial", "postgres", "postgres");
            Statement stmt = conn.createStatement();
            
            System.out.println("--- USERS ---");
            ResultSet rs = stmt.executeQuery("SELECT id, name, email FROM users");
            while (rs.next()) {
                System.out.println("User: ID=" + rs.getInt("id") + ", Name=" + rs.getString("name") + ", Email=" + rs.getString("email"));
            }
            
            System.out.println("--- PSYCHOLOGIST_PATIENTS ---");
            rs = stmt.executeQuery("SELECT id, psicologo_id, paciente_id, status FROM psychologist_patients");
            while (rs.next()) {
                System.out.println("Req: ID=" + rs.getInt("id") + ", Psico=" + rs.getInt("psicologo_id") + ", Paciente=" + rs.getInt("paciente_id") + ", Status=" + rs.getString("status"));
            }
            
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
