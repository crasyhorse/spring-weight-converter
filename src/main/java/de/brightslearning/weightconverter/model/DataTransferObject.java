package de.brightslearning.weightconverter.model;

import org.springframework.stereotype.Component;

@Component
public class DataTransferObject {

    private Double value;

    private String from;

    private String to;

    public DataTransferObject() {
    }

    public DataTransferObject(Double value, String from, String to) {
        this.value = value;
        this.from = from;
        this.to = to;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDisplayValue() {
        return String.format("%,.4f", value);
    }

    @Override
    public String toString() {
        return "DataTransferObject{" + "value=" + value + ", from='" + from + '\'' + ", to='" + to + '\'' + '}';
    }
}
