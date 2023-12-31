package by.clevertec.testwork.dto.weatherdata;

import lombok.Data;

@Data
public class FactResponse {
    public Integer obsTime;
    public Integer uptime;
    public Integer temp;
    public Integer feelsLike;
    public String icon;
    public String condition;
    public Double cloudness;
    public Integer precType;
    public Integer precProb;
    public Integer precStrength;
    public Boolean isThunder;
    public Double windSpeed;
    public String windDir;
    public Integer pressureMm;
    public Integer pressurePa;
    public Integer humidity;
    public String daytime;
    public Boolean polar;
    public String season;
    public String source;
    public Double soilMoisture;
    public Integer soilTemp;
    public Integer uvIndex;
    public Double windGust;
}
