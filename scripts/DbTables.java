import java.sql.*;
public class DbTables {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_trabajoParcial", "postgres", "postgres");
        ResultSet rs = conn.getMetaData().getTables(null, null, "%", new String[]{"TABLE"});
        while (rs.next()) {
            System.out.println(rs.getString("TABLE_NAME"));
        }
        
        System.out.println("\n--- Contenido paciente_a_psicologo_entidad ---");
        try {
            ResultSet rs2 = conn.createStatement().executeQuery("SELECT * FROM paciente_a_psicologo_entidad");
            while (rs2.next()) {
                System.out.println("ID: " + rs2.getInt("id") + " - Psico: " + rs2.getInt("psicologo_id") + " - Paciente: " + rs2.getInt("paciente_id") + " - Status: " + rs2.getString("status"));
            }
        } catch (Exception e) {
            System.out.println("No existe paciente_a_psicologo_entidad o no tiene esas columnas.");
        }
        conn.close();
    }
}
