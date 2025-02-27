package WeatherApp.weatherapp.service;

import WeatherApp.weatherapp.model.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherResponse getWeather(String city) {
        String url = String.format(apiUrl, city, apiKey);

        // Log URL for debugging
        logger.info("Final API Request URL: {}", url);

        try {
            WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);

            if (response == null) {
                throw new RuntimeException("Received empty response from OpenWeatherMap.");
            }

            return response;
        } catch (HttpClientErrorException e) {
            logger.error("Error fetching weather data: {}", e.getResponseBodyAsString());
            throw new RuntimeException("Error fetching weather data: " + e.getMessage());
        }
    }
}
