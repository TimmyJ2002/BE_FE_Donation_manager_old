import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, tap} from "rxjs";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl = 'http://localhost:8080'; // Adjust the URL as needed

  constructor(private http: HttpClient, private router: Router) {

  }

  login(credentials: any): Observable<any> {
    // return this.http.post<any>(this.apiUrl + "/auth/login", credentials)
    return this.http.post<any>(this.apiUrl + "/auth/login", credentials, { withCredentials: true })
      .pipe(
        tap((response: any) => {
          if (response.message == "Password change required") {
            // Redirect to password change page
            // Replace 'change-password' with your actual route
            window.location.href = '/change-password';
          }
        })
      );
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

  changePassword(userId: number, newPassword: string): Observable<any> {
    const url = `${this.apiUrl}/auth/change-password`;
    const requestBody = { userId, newPassword };

    return this.http.post(url, requestBody);
  }

  updateUserLoginCount(userId: number, newLoginCount: number): Observable<any> {
    const url = `${this.apiUrl}/auth/update-login-count`; // Replace with your actual endpoint
    const params = { userId: userId.toString(), newLoginCount: newLoginCount.toString() };

    return this.http.put(url, null, { params });
  }
}
