import {Injectable} from "@angular/core";
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Donator} from "../model/donator";

@Injectable({
  providedIn: 'root'
})

export class DonatorService{

  url:string = "http://localhost:8080/donator/create"

  constructor(
    private http: HttpClient
  ) {
  }
  addDonor(data: any): Observable<any> {
    return this.http.post(this.url, data);
  }

}
