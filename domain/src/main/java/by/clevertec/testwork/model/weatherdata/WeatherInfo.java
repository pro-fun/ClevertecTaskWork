
package by.clevertec.testwork.model.weatherdata;

import lombok.Data;

import java.util.List;



@Data
public class WeatherInfo {
    public Integer now;
    public String nowDt;
    public Info info;
    public GeoObject geoObject;
    public Yesterday yesterday;
    public Fact fact;
    public List<Forecast> forecasts;
}
