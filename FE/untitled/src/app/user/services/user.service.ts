import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable, tap} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {User} from "../model/user";
import {AuthService} from "../../services/auth.service";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url:string="http://localhost:8080/getUsers";
  url2:string="http://localhost:8080/user/update/";

  userList$:BehaviorSubject<User[]> = new BehaviorSubject<User[]>([]);
  userList:User[] = [
    new User(1, 'user1', 'user_email1@yahoo.com', '1234'),
    new User(2, 'user2', 'user_email2@yahoo.com', '1234'),
    new User(3, 'user3', 'user_email3@yahoo.com', '1234')
  ]

  loadUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.url).pipe(
      tap(users => this.userList$.next(users))
    );
  }

  getUsers():Observable<User[]>{
    return this.userList$.asObservable();
  }

  updateUser(user:User):Observable<User>{
    return this.http.put<User>(this.url2 + user.id, user);
  }
  constructor(private http: HttpClient, private authService: AuthService) {
  }


}
