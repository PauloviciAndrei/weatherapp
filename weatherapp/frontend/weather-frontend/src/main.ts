import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { provideHttpClient } from '@angular/common/http';
import { WeatherService } from './app/weather.service'; // Import WeatherService

bootstrapApplication(AppComponent, {
  providers: [
    provideHttpClient(), // Provide HttpClient
    WeatherService, // Explicitly provide WeatherService
  ],
}).catch((err) => console.error(err));
