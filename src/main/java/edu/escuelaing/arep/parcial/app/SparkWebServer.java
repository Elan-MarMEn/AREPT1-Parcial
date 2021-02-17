package edu.escuelaing.arep.parcial.app;

import com.google.gson.JsonObject;
import edu.escuelaing.arep.parcial.app.Cache.WeatherCache;
import edu.escuelaing.arep.parcial.app.Connection.WeatherConnection;

import static spark.Spark.*;

public class SparkWebServer {

    public static void main(String[] args) {

        port(getPort());
        WeatherCache weatherCache= new WeatherCache();
        WeatherConnection weatherConnection = new WeatherConnection();

        get("/clima", (request, response) ->{
            String req = request.queryParams("lugar");
            JsonObject data = weatherCache.getCity(req);
            if (data != null){
                return data;
            }
            return weatherConnection.getWeatherbyCity(req);
        });


    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set(i.e. on localhost)
    }
}
