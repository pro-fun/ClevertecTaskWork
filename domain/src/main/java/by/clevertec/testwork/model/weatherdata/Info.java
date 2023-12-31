
package by.clevertec.testwork.model.weatherdata;


import lombok.Data;

@Data
public class Info {

    public Integer geoid;
    public String url;
    public Double lat;
    public Double lon;
    public Tzinfo tzinfo;
    public Integer defPressureMm;
    public Integer defPressurePa;
    public String slug;
    public Integer zoom;


}
