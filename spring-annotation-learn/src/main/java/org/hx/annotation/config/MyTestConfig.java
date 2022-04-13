package org.hx.annotation.config;

import org.hx.annotation.bean.Car;
import org.hx.annotation.bean.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Configuration
@Component
public class MyTestConfig {
    @Bean
    public Driver driver(){
        Driver driver = new Driver();
        driver.setCar(car());
        return driver;
    }

    @Bean
    public Car car(){
        Car car = new Car();
        return car;
    }
}
