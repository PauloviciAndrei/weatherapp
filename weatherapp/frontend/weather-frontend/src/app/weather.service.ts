import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root' // Ensures it's globally available
})
export class WeatherService {
  private apiUrl = 'http://localhost:8080/weather'; // Your backend API

  constructor(private http: HttpClient) {console.log('WeatherService instantiated MUIE MUIE MUIE MUIE MUIE MUIE MUIE MUIE');console.log('WeatherService instantiated MUIE MUIE MUIE MUIE MUIE MUIE MUIE MUIE')} // Ensure HttpClient is injected

  getWeather(city: string): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${city}`);
  }
}
