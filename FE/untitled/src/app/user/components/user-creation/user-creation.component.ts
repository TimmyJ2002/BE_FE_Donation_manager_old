import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {User} from "../../model/user";
import {UserService} from "../../services/user.service";
import {error} from "@angular/compiler-cli/src/transformers/util";



@Component({
  selector: 'app-user-creation',
  templateUrl: './user-creation.component.html',
  styleUrls: ['./user-creation.component.css']
})
export class UserCreationComponent implements OnInit{
  userForm!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService
  ) {}
  ngOnInit(): void {
    this.initUserForm();
  }

  private initUserForm(): void{
    this.userForm = this.formBuilder.group({
      firstName: ['', [
        Validators.required,
        Validators.maxLength(50), // Change the length limit as needed
        Validators.pattern(/^[a-zA-Z\s]*$/) // Allows only alphabetic characters and spaces
      ]],
      lastName: ['', [
        Validators.required,
        Validators.maxLength(50), // Change the length limit as needed
        Validators.pattern(/^[a-zA-Z\s]*$/) // Allows only alphabetic characters and spaces
      ]],
      email: ['', [Validators.required, Validators.pattern(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/)]],
      mobileNumber: ['', [Validators.required, Validators.pattern(/^(00407\d{8}|07\d{8}|\+407\d{8})$/)]]
      // TODO:roles and other things i need to add later + Validators
    });
  }

  onSubmit():void {
    if (this.userForm.invalid){
      return;
    }

    const user: User = this.userForm.value;

    this.userService.createUser(user).subscribe(
      (createdUser: User) => {
        console.log("User created succesfully:", createdUser);
      },
      (error) => {
        console.error("Failed to create User:", error);
      }
    );
  }
}
