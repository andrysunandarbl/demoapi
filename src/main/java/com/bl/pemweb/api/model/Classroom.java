
package com.bl.pemweb.api.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * Author andry on 11/11/17.
 */
public class Classroom {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-YYYY HH:mm:ss");

    private Date  date;
    private double temperature;
    private double humidity;
    private double pressure;


    public Classroom() {
        date = new Date();
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "date=" + dateFormat.format(new Date()) +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                '}';
    }
}
