import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MiLectorJson {

    public static void main(String[] args) {
        String filePath = "src/main/java/datosUsuario.json"; // Cambia esto por la ruta real de tu archivo JSON

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonObject = new JSONObject(content);

            // Acceder al elemento "nombre" y mostrarlo:
            String nombre = jsonObject.getString("nombre");
            System.out.println("El nombre en el JSON es: " + nombre);

            JSONArray habilidades = jsonObject.getJSONArray("habilidades");
            System.out.println("Habilidades de " + nombre + ":");
            for (int i = 0; i < habilidades.length(); i++) {
                System.out.println("- " + habilidades.getString(i));
            }

        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
        }
    }
}
