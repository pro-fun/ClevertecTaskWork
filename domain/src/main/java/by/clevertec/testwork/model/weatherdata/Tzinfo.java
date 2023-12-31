
package by.clevertec.testwork.model.weatherdata;


import lombok.Data;

@Data
public class Tzinfo {

    public String name;
    public String abbr;
    public Boolean dst;
    public Integer offset;

}
