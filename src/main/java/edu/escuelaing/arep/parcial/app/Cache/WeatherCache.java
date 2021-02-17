package edu.escuelaing.arep.parcial.app.Cache;

import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alan Marin
 */
public class WeatherCache {
    private Map<String, JsonObject> cache = new HashMap<String, JsonObject>();

    /**
     * Guarda en el HashMap la informacion otenida
     * @param city
     * @param resp
     */
    public void save(String city, JsonObject resp){
        if (!cache.containsKey(city)){
            cache.put(city,resp);
        }
    }

    /**
     * Consulta lo que se haya guardado en cache
     * @param city
     * @return JsonObject
     */
    public JsonObject getCity(String city){
        if (cache.containsKey(city)){
            return cache.get(city);
        }
        return null;
    }
}
