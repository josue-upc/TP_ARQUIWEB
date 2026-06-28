import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbInsert2 {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_trabajoParcial", "postgres", "postgres");
            Statement stmt = conn.createStatement();
            
            // Insert for ID 14
            stmt.executeUpdate("INSERT INTO psychologist_patients (psicologo_id, paciente_id, status, mensaje_solicitud, fecha_asignacion) VALUES (14, 102, 'PENDING', 'Hola Dra. Almendra, soy Juan', CURRENT_TIMESTAMP)");
            System.out.println("Insertado para ID 14");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
