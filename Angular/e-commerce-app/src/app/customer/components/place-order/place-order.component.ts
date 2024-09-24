import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { CustomerService } from '../../services/customer.service';

@Component({
  selector: 'app-place-order',
  templateUrl: './place-order.component.html',
  styleUrls: ['./place-order.component.scss']
})
export class PlaceOrderComponent {

  orderForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private snackBar: MatSnackBar,
    private customerService: CustomerService,
    public dialog: MatDialog,
  ) { }

  ngOnInit(){
    this.orderForm = this.fb.group({
      address: [null, [Validators.required]],
      orderDescription: [null],
    })
  }

  placeOrder(){
    this.customerService.placeOrder(this.orderForm.value).subscribe(res => {
      console.log("Response: ", res);  // Debugging
      if(res.id != null){
        console.log("Order placed");  // Debugging
        this.snackBar.open("Order placed successfully.", "Close", { duration: 5000});
        this.router.navigateByUrl("/customer/my_orders");
        this.closeForm();
      }else{
        console.log("Error placing order");  // Debugging
        this.snackBar.open("Something went wrong!", "Close", { duration: 5000 });
      }
    }, err => {
      console.error("Error: ", err);  // Handle any errors
      this.snackBar.open("Order failed!", "Close", { duration: 5000 });
    });
  }

  closeForm(){
    this.dialog.closeAll();
  }

}
