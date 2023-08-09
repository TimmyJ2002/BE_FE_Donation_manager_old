import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CreateDonatorService {

  private apiUrl = 'http://localhost:8080/donator/create'; // Adjust the URL as needed

  constructor(private http: HttpClient) {

  }

  addDonor(data: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, data);
  }

  // Save the accessToken to localStorage
  saveAccessToken(accessToken: string): void {
    localStorage.setItem('accessToken', accessToken);
  }

  // Retrieve the accessToken from localStorage
  getAccessToken(): string | null {
    return localStorage.getItem('accessToken');
  }

  // Clear the accessToken from localStorage on logout
  clearAccessToken(): void {
    localStorage.removeItem('accessToken');
  }
}
