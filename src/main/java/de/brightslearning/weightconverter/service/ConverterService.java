package de.brightslearning.weightconverter.service;

import de.brightslearning.weightconverter.model.DataTransferObject;
import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.Map;

@Service
public class ConverterService {

    private Map<String, Map<String, Double>> conversionMatrix;

    public ConverterService() {
        this.initializeConversionMatrix();
    }

    public DataTransferObject convert(String from, String to, Double value) {
        return new DataTransferObject(value / conversionMatrix.get(from).get(to), from, to);
    }

    private void initializeConversionMatrix() {
        conversionMatrix = Map.ofEntries(new AbstractMap.SimpleEntry<>("t", Map.ofEntries(new AbstractMap.SimpleEntry<>("t", 1d), new AbstractMap.SimpleEntry<>("kg", 0.001d), new AbstractMap.SimpleEntry<>("g", 0.000001d), new AbstractMap.SimpleEntry<>("mg", 0.000000001d))), new AbstractMap.SimpleEntry<>("kg", Map.ofEntries(new AbstractMap.SimpleEntry<>("t", 1000d), new AbstractMap.SimpleEntry<>("kg", 1d), new AbstractMap.SimpleEntry<>("g", 0.001d), new AbstractMap.SimpleEntry<>("mg", 0.000001d))), new AbstractMap.SimpleEntry<>("g", Map.ofEntries(new AbstractMap.SimpleEntry<>("t", 1000000d), new AbstractMap.SimpleEntry<>("kg", 1000d), new AbstractMap.SimpleEntry<>("g", 1d), new AbstractMap.SimpleEntry<>("mg", 0.001d))), new AbstractMap.SimpleEntry<>("mg", Map.ofEntries(new AbstractMap.SimpleEntry<>("t", 1000000000d), new AbstractMap.SimpleEntry<>("kg", 1000000d), new AbstractMap.SimpleEntry<>("g", 1000d), new AbstractMap.SimpleEntry<>("mg", 1d))));
    }
}
