import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CustomerService } from '../../services/customer.service';
import { PlaceOrderComponent } from '../place-order/place-order.component';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent {

  cartItems: any[] = [];
  order: any;

  couponForm!: FormGroup; 

  constructor(
    private customerService: CustomerService,
    private snackBar: MatSnackBar,
    private fb: FormBuilder,
    private dialog: MatDialog,
  ) { }

  ngOnInit(): void {
    this.couponForm = this.fb.group({
      code: [null, [Validators.required]]
    })
    this.getCart();
  }

  applyCoupon(){
    this.customerService.applyCoupon(this.couponForm.get(['code'])!.value).subscribe(res => {
      this.snackBar.open("Coupon Applied Successfully!", 'Close', { duration: 5000 });
      this.getCart();
    }, error => {
      this.snackBar.open(error.error, 'Close', { duration: 5000 });
    })
  }

  getCart(){
    console.log("Coming method inside...");
    this.cartItems = [];
    console.log("Before Inside"); 
    this.customerService.getCartByUserId().subscribe(res => {
      console.log("Coming Inside");      
      this.order = res;
      console.log("API Call" ,res);
      
      res.cartItems.forEach(element => {
        element.processedImg = 'data:image/jpeg;base64,' + element.returnedImg;
        this.cartItems.push(element);
      });
    }, error=> {
      console.log("Error Occurred!!!!!!!!!!!!", error);
    })
  } 

  increaseQuantity(productId: any){
    this.customerService.increaseProductQuantity(productId).subscribe(res => {
      this.snackBar.open('product quantity increased.', 'Close', { duration: 5000 });
      this.getCart();
    })
  }

  decreaseQuantity(productId: any){
    this.customerService.decreaseProductQuantity(productId).subscribe(res => {
      this.snackBar.open('product quantity decreased.', 'Close', { duration: 5000 });
      this.getCart();
    })
  }

  placeOrder(){
    this.dialog.open(PlaceOrderComponent);
  }

}
