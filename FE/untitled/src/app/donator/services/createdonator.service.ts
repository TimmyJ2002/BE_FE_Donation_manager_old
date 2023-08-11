import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CreateDonatorService {

  private apiUrl = 'http://localhost:8080/donator/create'; // Adjust the URL as needed
  private listUrl = 'http://localhost:8080/donator/edit';

  constructor(private http: HttpClient) {

  }
  addDonor(data: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, data);
  }
  getDonors(): Observable<any[]> {
    return this.http.get<any[]>(this.listUrl);
  }

}
