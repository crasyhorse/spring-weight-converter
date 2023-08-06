package de.brightslearning.weightconverter;

import de.brightslearning.weightconverter.model.Unit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.AbstractMap;
import java.util.Map;

@SpringBootApplication
public class WeightConverterApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeightConverterApplication.class, args);
    }

    @Bean
    public Map<String, Unit> units() {
        Map<String, Unit> units = Map.ofEntries(
                new AbstractMap.SimpleEntry<>("t", new Unit("t", "Tonne")),
                new AbstractMap.SimpleEntry<>("kg", new Unit("kg", "Kilogram")),
                new AbstractMap.SimpleEntry<>("g", new Unit("g", "Gram")),
                new AbstractMap.SimpleEntry<>("mg", new Unit("mg", "Milligram"))
        );

        return units;
    }

}
