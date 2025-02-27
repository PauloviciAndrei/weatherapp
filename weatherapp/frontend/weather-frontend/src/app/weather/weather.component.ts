import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WeatherService } from '../weather.service';

@Component({
  selector: 'app-weather',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './weather.component.html',
  styleUrls: ['./weather.component.css'],
})
export class WeatherComponent implements OnInit {
  @Input() city: string = 'New York';
  weatherData: any;

  constructor(private weatherService: WeatherService) {} // Correct injection

  ngOnInit(): void {
    this.getWeather();
  }

  getWeather() {
    this.weatherService.getWeather(this.city).subscribe(
      (data) => {
        this.weatherData = {
          temperature: `${data.main.temp}°C`,
          humidity: `${data.main.humidity}%`,
          condition: data.weather[0].description,
        };
      },
      (error) => {
        console.error('Error fetching weather data:', error);
      }
    );
  }
}
