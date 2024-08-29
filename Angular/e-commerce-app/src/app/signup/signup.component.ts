import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth/auth.service';
import { catchError, of, tap } from 'rxjs';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent {

  signupForm!: FormGroup;
  hidePassword = true;

  constructor(private fb: FormBuilder,
    private snackbar: MatSnackBar,
    private authService: AuthService,
    private router: Router){  }

  ngOnInit(): void {
    this.signupForm = this.fb.group({
      name: [null, [Validators.required]],
      email: [null, [Validators.required, Validators.email]],
      password: [null, [Validators.required]],
      confirmpassword: [null, [Validators.required]],
    })
  }

  togglepasswordvisibility(){
    this.hidePassword = !this.hidePassword;
  }

  onSubmit(): void{
    const password = this.signupForm.get('password')?.value;
    const confirmpassword = this.signupForm.get('confirmpassword')?.value;

    console.log('Form Submitted', this.signupForm.value);

    if(password !== confirmpassword){
      this.snackbar.open('Passwords do not match.', 'Close', { duration: 5000, panelClass: ['error-snackbar'] });
      return;
    }

    this.authService.register(this.signupForm.value).pipe(
      tap(response => {
        console.log('Sign up successful', response);
        this.snackbar.open('Sign up successful.', 'Close', { duration: 5000 });
        this.router.navigateByUrl('/login');
      }),
      catchError(error => {
        console.error('Sign up error', error);
        const errorMessage = error?.error?.message || 'Sign up failed. Please try again.';
        this.snackbar.open(errorMessage, 'Close', { duration: 5000, panelClass: ['error-snackbar'] });
        return of(error);
      })
    ).subscribe();
    
  }
  
}
