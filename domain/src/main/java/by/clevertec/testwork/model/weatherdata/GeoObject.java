
package by.clevertec.testwork.model.weatherdata;

import by.clevertec.testwork.model.weatherdata.geoproperties.Country;
import by.clevertec.testwork.model.weatherdata.geoproperties.District;
import by.clevertec.testwork.model.weatherdata.geoproperties.Locality;
import by.clevertec.testwork.model.weatherdata.geoproperties.Province;
import lombok.Data;

@Data
public class GeoObject {

    public District district;
    public Locality locality;
    public Province province;
    public Country country;

}
