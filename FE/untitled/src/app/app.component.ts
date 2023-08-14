import {Component, OnInit} from '@angular/core';
import {AuthService} from "./services/auth.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'untitled';

  isLoggedIn: boolean = false;

  constructor(private authService: AuthService) {
    this.isLoggedIn = this.authService.isAuthenticated();
  }

  logout() {
    this.authService.logout().subscribe(
      () => {
        this.isLoggedIn = false;
        console.log('Logged out successfully');
      },
      (error) => {
        console.error('Error logging out:', error);
      }
    );
  }
ngOnInit(): void {
  }
}
