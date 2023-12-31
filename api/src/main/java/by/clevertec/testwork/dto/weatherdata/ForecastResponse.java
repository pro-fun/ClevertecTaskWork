package by.clevertec.testwork.dto.weatherdata;

import lombok.Data;

@Data
public class ForecastResponse {
    public String date;
    public Integer dateTs;
    public Integer week;
    public String sunrise;
    public String sunset;
    public String riseBegin;
    public String setEnd;
    public Integer moonCode;
    public String moonText;
    public PartsResponse parts;
}
