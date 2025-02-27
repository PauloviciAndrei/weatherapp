package WeatherApp.weatherapp.model;

import java.util.List;

public class WeatherResponse {
    private Main main;
    private List<Weather> weather;

    // Default constructor
    public WeatherResponse() {}

    // Constructor
    public WeatherResponse(Main main, List<Weather> weather) {
        this.main = main;
        this.weather = weather;
    }

    // Getters and Setters
    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    // Static inner class for Main
    public static class Main {
        private double temp;
        private int humidity;

        // Default constructor
        public Main() {}

        // Constructor
        public Main(double temp, int humidity) {
            this.temp = temp;
            this.humidity = humidity;
        }

        // Getters and Setters
        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }
    }

    // Static inner class for Weather
    public static class Weather {
        private String description;

        // Default constructor
        public Weather() {}

        // Constructor
        public Weather(String description) {
            this.description = description;
        }

        // Getters and Setters
        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
