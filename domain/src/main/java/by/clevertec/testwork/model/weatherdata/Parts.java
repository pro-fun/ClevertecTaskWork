
package by.clevertec.testwork.model.weatherdata;

import by.clevertec.testwork.model.weatherdata.dayparts.*;
import lombok.Data;

@Data
public class Parts {

    public DayShort dayShort;
    public Morning morning;
    public Evening evening;
    public NightShort nightShort;
    public Day day;
    public Night night;

}
