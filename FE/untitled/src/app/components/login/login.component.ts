import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  loginForm: FormGroup;

  constructor(private fb: FormBuilder, private authService: AuthService) {
    this.loginForm = this.fb.group({
      username: [''],
      password: ['']
    });
  }
  onSubmit() {
    const credentials = this.loginForm.value;
    this.authService.login(credentials).subscribe(
      (response) => {
        const accessToken = response.accessToken;
        this.authService.saveAccessToken(accessToken); // Save the accessToken to localStorage
        console.log('Access Token:', accessToken);
        this.loginForm.reset();
      },
      (error) => {
        console.error('Login Error:', error);
      }
    );
  }
  ngOnInit(): void {
  }

}
