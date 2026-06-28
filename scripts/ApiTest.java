import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;


public class ApiTest {
    public static void main(String[] args) {
        try {
            // Login
            URL urlLogin = new URL("http://localhost:8081/api/v1/auth/login");
            HttpURLConnection connLogin = (HttpURLConnection) urlLogin.openConnection();
            connLogin.setRequestMethod("POST");
            connLogin.setRequestProperty("Content-Type", "application/json");
            connLogin.setDoOutput(true);
            String jsonInput = "{\"email\":\"psico_mock@staycool.com\",\"password\":\"psico123\"}";
            try(OutputStream os = connLogin.getOutputStream()) {
                byte[] input = jsonInput.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            
            if (connLogin.getResponseCode() == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(connLogin.getInputStream(), "utf-8"));
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("Login success!");
                
                // Get Token (Basic parsing)
                String resStr = response.toString();
                String token = resStr.substring(resStr.indexOf("\"token\":\"") + 9, resStr.indexOf("\"", resStr.indexOf("\"token\":\"") + 9));
                System.out.println("Token: " + token);
                
                // Call GET /requests
                URL urlReq = new URL("http://localhost:8081/api/v1/psychologist/requests?psicologoId=101");
                HttpURLConnection connReq = (HttpURLConnection) urlReq.openConnection();
                connReq.setRequestMethod("GET");
                connReq.setRequestProperty("Authorization", "Bearer " + token);
                
                if (connReq.getResponseCode() == 200) {
                    BufferedReader br2 = new BufferedReader(new InputStreamReader(connReq.getInputStream(), "utf-8"));
                    StringBuilder reqResponse = new StringBuilder();
                    String line;
                    while ((line = br2.readLine()) != null) {
                        reqResponse.append(line.trim());
                    }
                    System.out.println("Requests Response: " + reqResponse.toString());
                } else {
                    System.out.println("GET failed with: " + connReq.getResponseCode());
                }
            } else {
                System.out.println("Login failed with: " + connLogin.getResponseCode());
                BufferedReader brErr = new BufferedReader(new InputStreamReader(connLogin.getErrorStream(), "utf-8"));
                StringBuilder errResponse = new StringBuilder();
                String line;
                while ((line = brErr.readLine()) != null) {
                    errResponse.append(line.trim());
                }
                System.out.println("Error: " + errResponse.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
