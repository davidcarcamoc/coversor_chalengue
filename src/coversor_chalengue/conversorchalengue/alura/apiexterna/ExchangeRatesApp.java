package conversorchalengue.alura.apiexterna;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ExchangeRatesApp {
	 private String de;
	 private  String hasta;
	 private double cantidad;
	 private static final String URL = "https://api.apilayer.com/exchangerates_data/convert?to={to}&from={from}&amount={amount}";
	 private static final String API_KEY = "ZAx5iQTPeP8qy8JRlpakw5M0f4zmIxtP";
	 private double campoDeseado;
     //Getter y setter de la clase
    public String getDe() {
		return de;
	}
	public void setDe(String de) {
		this.de = de;
	}
	public String getHasta() {
		return hasta;
	}
	public void setHasta(String hasta) {
		this.hasta = hasta;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad2) {
		this.cantidad = cantidad2;
		
	}
	//constructor de la clase
    public void getExchangeRates() {
       // obtener datos
       de = getDe();
       hasta = getHasta();
       cantidad =getCantidad();
       //verfificar que los datos no sean nulos en la peticion api
        if (de == null || de.isEmpty() || hasta == null || hasta.isEmpty() || cantidad <= 0) {
            System.out.println("Error: Datos de entrada inválidos");
            return;
        }

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL.replace("{to}", hasta).replace("{from}", de).replace("{amount}", String.valueOf(cantidad)))
                .addHeader("apikey", API_KEY)
                .method("GET", null)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String resultado = response.body().string();
                // Parsear la cadena JSON a un objeto JSONObject
                JSONObject json = new JSONObject(resultado);
                // Obtener el valor del campo "result" del JSON
                // ... código existente ...
                if (json.has("result")) {
                    Object result = json.get("result");
                    // Validar que el valor sea un número
                    if (result instanceof Number) {
                        // Convertir el valor a un double
                        campoDeseado = ((Number) result).doubleValue();
                        // Llamar al método para actualizar
                    } else {
                        System.out.println("Error: El campo 'result' no es un número");
                    }
                } else {
                    System.out.println("Error: El campo 'result' no existe en el JSON");
                }
            } else {
                System.out.println("Error: " + response.code() + " " + response.message());
            }
        } catch (IOException e) {
            System.out.println("Error al realizar la solicitud HTTP: " + e.getMessage());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
   //para obtener el dato result del la respuesta de la api
	public double obtenerDatosAPI() {
		return campoDeseado; 
	}
	
}
