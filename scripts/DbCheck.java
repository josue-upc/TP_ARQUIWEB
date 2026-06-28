import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbCheck {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_trabajoParcial", "postgres", "postgres");
            Statement stmt = conn.createStatement();
            
            System.out.println("--- Roles ---");
            ResultSet rsRoles = stmt.executeQuery("SELECT id, name FROM roles");
            while (rsRoles.next()) {
                System.out.println(rsRoles.getInt("id") + " - " + rsRoles.getString("name"));
            }
            
            System.out.println("\n--- Vinculaciones ---");
            ResultSet rs = stmt.executeQuery("SELECT id, psicologo_id, paciente_id, status FROM psychologist_patients");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + " - Psico: " + rs.getInt("psicologo_id") + " - Paciente: " + rs.getInt("paciente_id") + " - Status: " + rs.getString("status"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
