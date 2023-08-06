package de.brightslearning.weightconverter.model;

import org.springframework.stereotype.Component;

@Component
public class Unit {

    private String shortName;

    private String longName;

    public Unit() {
    }

    public Unit(String shortName, String longName) {
        this.shortName = shortName;
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    @Override
    public String toString() {
        return "Unit{" + "shortName='" + shortName + '\'' + ", longName='" + longName + '\'' + '}';
    }
}
