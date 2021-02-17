package edu.escuelaing.arep.parcial.app;

import static spark.Spark.*;

public class SparkWebServer {

    public static void main(String[] args) {

        port(getPort());
        staticFiles.location("/public");

        get("/hello", (request, response) ->
            "prueba"
        );

    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set(i.e. on localhost)
    }
}
