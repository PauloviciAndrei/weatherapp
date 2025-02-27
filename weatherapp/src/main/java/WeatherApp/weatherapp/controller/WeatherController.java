package WeatherApp.weatherapp.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import WeatherApp.weatherapp.model.WeatherResponse;
import WeatherApp.weatherapp.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;
    private final ObjectMapper objectMapper; // Jackson ObjectMapper for pretty-printing

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
        this.objectMapper = new ObjectMapper();
    }

    @GetMapping("/{city}")
    public ResponseEntity<String> getWeather(@PathVariable String city) {
        try {
            WeatherResponse response = weatherService.getWeather(city);
            // Convert JSON object to pretty-printed JSON string
            String formattedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
            return ResponseEntity.ok(formattedJson);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }
}
