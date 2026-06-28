import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbInsert {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_trabajoParcial", "postgres", "postgres");
            Statement stmt = conn.createStatement();
            
            int inserted = stmt.executeUpdate("INSERT INTO psychologist_patients (psicologo_id, paciente_id, status, mensaje_solicitud, fecha_asignacion) VALUES (101, 102, 'PENDING', 'Hola Dra. Almendra', CURRENT_TIMESTAMP)");
            System.out.println("Insertado: " + inserted);
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
