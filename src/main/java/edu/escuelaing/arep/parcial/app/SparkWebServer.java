package edu.escuelaing.arep.parcial.app;

import edu.escuelaing.arep.parcial.app.Connection.WeatherConnection;

import static spark.Spark.*;

public class SparkWebServer {

    public static void main(String[] args) {

        port(getPort());
        staticFiles.location("/public");

        WeatherConnection weatherConnection = new WeatherConnection();

        get("/clima", (request, response) ->{
            request.queryParams("lugar");
            System.out.println(request.queryParams("lugar"));
            return request.queryParams("lugar");
//            return weatherConnection.getWeatherbyCity(request.queryParams("lugar"));
        });


    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set(i.e. on localhost)
    }
}
