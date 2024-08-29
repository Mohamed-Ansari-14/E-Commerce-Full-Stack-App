import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AdminService } from '../../service/admin.service';
import { catchError, of, tap } from 'rxjs';

@Component({
  selector: 'app-post-category',
  templateUrl: './post-category.component.html',
  styleUrls: ['./post-category.component.scss']
})
export class PostCategoryComponent implements OnInit{  

  categoryForm! : FormGroup;

  constructor(
    private formbuilder: FormBuilder,
    private router: Router,
    private snackBar: MatSnackBar,
    private adminService: AdminService,
  ) { }

  ngOnInit(): void {
    this.categoryForm = this.formbuilder.group({
      name: [null, [Validators.required]],
      description: [null, [Validators.required]]
    });
  }

  addCategory(): void {
    console.log("Entered into method");
    
    if(this.categoryForm.valid) {
        console.log("Entered into valid");
        
        this.adminService.addCategory(this.categoryForm.value).pipe(
            tap(res => {
                if (res.id != null) {
                    console.log("Enter into Added");
                    this.snackBar.open('Category added successfully!', 'Close', { duration: 5000 });
                    this.router.navigateByUrl('/admin/dashboard');
                } else {
                    console.log("Exit From Adding");
                    this.snackBar.open(res.message, 'Close', { duration: 5000, panelClass: 'error-snackbar' });
                }
            }),
            catchError(error => {
                console.error('Error occurred', error);
                this.snackBar.open('Error occurred while adding category.', 'Close', { duration: 5000, panelClass: ['error-snackbar'] });
                return of(null); // Return an observable to keep the stream alive
            })
        ).subscribe();
    } else {
        console.log("Exit()...");
        this.categoryForm.markAllAsTouched();
    }
  }
}
