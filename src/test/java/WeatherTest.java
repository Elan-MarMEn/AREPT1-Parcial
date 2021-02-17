
import com.google.gson.JsonObject;
import edu.escuelaing.arep.parcial.app.Connection.WeatherConnection;
import org.junit.Assert;
import org.junit.Test;


public class WeatherTest {

    @Test
    public void WeatherConnectionTest(){


        WeatherConnection weatherConnection = new WeatherConnection();
        JsonObject jsonObject = weatherConnection.getWeatherbyCity("Bogota");
        Assert.assertEquals("200",jsonObject.get("cod").toString());

    }


}
