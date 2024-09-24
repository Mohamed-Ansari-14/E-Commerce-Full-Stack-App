import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth/auth.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserStorageService } from '../services/storage/user-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  loginForm!: FormGroup;

  hidePassword = true;

  constructor(private formBuilder: FormBuilder,
    private snackbar: MatSnackBar,
    private authService: AuthService,
    private router: Router){  }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      email: [null, [Validators.required]],
      password: [null, [Validators.required]],
    })
  }

  togglepasswordvisibility(){
    this.hidePassword = !this.hidePassword;
  }

  onSubmit(): void{
    const username = this.loginForm.get('email')!.value;
    const password = this.loginForm.get('password')!.value;

    this.authService.login(username, password).subscribe(
      (res) => {
        if(UserStorageService.isAdminLoggedIn()){
          this.router.navigateByUrl('admin/dashboard');
          this.snackbar.open('Login successful as admin.', 'Close', { duration: 2000 });
        }else if(UserStorageService.isCustomerLoggedIn()){
          this.router.navigateByUrl('customer/dashboard');
          this.snackbar.open('Login successful as customer.', 'Close', { duration: 2000 });
        }
      },
      (error) => {
        this.snackbar.open('Invalid credentials.', 'Close', { duration: 5000 });
      }
    )
  }

}
