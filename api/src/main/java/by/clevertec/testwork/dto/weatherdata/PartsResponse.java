
package by.clevertec.testwork.dto.weatherdata;

import by.clevertec.testwork.dto.weatherdata.dayparts.*;
import lombok.Data;

@Data
public class PartsResponse {

    public DayShortResponse dayShort;
    public MorningResponse morning;
    public EveningResponse evening;
    public NightShortResponse nightShort;
    public DayResponse day;
    public NightResponse night;

}
