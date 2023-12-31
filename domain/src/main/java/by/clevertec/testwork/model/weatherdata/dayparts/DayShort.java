
package by.clevertec.testwork.model.weatherdata.dayparts;


import lombok.Data;

@Data
public class DayShort {

    public String source;
    public Integer temp;
    public Integer tempMin;
    public Integer windSpeed;
    public Double windGust;
    public String windDir;
    public Integer pressureMm;
    public Integer pressurePa;
    public Integer humidity;
    public Integer soilTemp;
    public Double soilMoisture;
    public Integer precMm;
    public Integer precProb;
    public Integer precPeriod;
    public Integer cloudness;
    public Integer precType;
    public Integer precStrength;
    public String icon;
    public String condition;
    public Integer uvIndex;
    public Integer feelsLike;
    public String daytime;
    public Boolean polar;
    public Integer freshSnowMm;

}
