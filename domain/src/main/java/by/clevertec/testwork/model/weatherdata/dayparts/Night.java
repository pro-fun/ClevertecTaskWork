
package by.clevertec.testwork.model.weatherdata.dayparts;


import lombok.Data;

@Data
public class Night {

    public String source;
    public Integer tempMin;
    public Integer tempAvg;
    public Integer tempMax;
    public Double windSpeed;
    public Double windGust;
    public String windDir;
    public Integer pressureMm;
    public Integer pressurePa;
    public Integer humidity;
    public Integer soilTemp;
    public Double soilMoisture;
    public Double precMm;
    public Integer precProb;
    public Integer precPeriod;
    public Integer cloudness;
    public Integer precType;
    public Double precStrength;
    public String icon;
    public String condition;
    public Integer uvIndex;
    public Integer feelsLike;
    public String daytime;
    public Boolean polar;
    public Integer freshSnowMm;
}
