package by.clevertec.testwork.repository;

import by.clevertec.testwork.model.CurrentTemperature;
import io.micrometer.core.annotation.Timed;
import org.springframework.data.repository.CrudRepository;


import java.util.List;



public interface WeatherRepository extends CrudRepository<CurrentTemperature, Long> {
    @Timed("gettingAllTemperature")
    List<CurrentTemperature> findAll();

}
