package edu.escuelaing.arep.parcial.app.Connection;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * @author Alan Marin
 */
public class WeatherConnection {

    /**
     * Obtiene informacion de la API
     * @param city
     * @return
     */
    public JsonObject getWeatherbyCity(String city) {
        Request request = new Request.Builder()
                .url("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=d729e17844904bad642984f1d42ef559")
                .get()
                .build();
        OkHttpClient httpClient = new OkHttpClient();
        String respuestaApi = null;
        Response respuesta = null;

        try {
            respuesta = httpClient.newCall(request).execute();
            if (respuesta.isSuccessful()) {
                respuestaApi = respuesta.body().string();
            }
        } catch (IOException e) {
            System.out.println("Fallo");
        }

        JsonObject jsonObject = new JsonParser().parse(respuestaApi).getAsJsonObject();
        return jsonObject;
    }
}
