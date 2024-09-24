import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserStorageService } from 'src/app/services/storage/user-storage.service';

const BASIC_URL = "http://localhost:8080/";

export interface User {
  id: number;
  email: string;
  password: string;
  name: string;
  role: string;
}

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http:HttpClient) { }

  addCategory(categoryDto: any): Observable<any> {
    return this.http.post(BASIC_URL + 'api/admin/category', categoryDto, {
      headers: this.createAuthorizationHeader(),
    });
  }

  getAllCategories(): Observable<any> {
    return this.http.get(BASIC_URL + 'api/admin', {
      headers: this.createAuthorizationHeader(),
    });
  }

  addProduct(productDto: any): Observable<any> {
    return this.http.post(BASIC_URL + 'api/admin/product', productDto, {
      headers: this.createAuthorizationHeader(),
    });
  }

  updateProduct(ProductId: any, productDto: any): Observable<any> {
    return this.http.put(BASIC_URL + `api/admin/product/${ProductId}`, productDto, {
      headers: this.createAuthorizationHeader(),  
    });
  }

  getAllProducts(): Observable<any> {
    return this.http.get(BASIC_URL + 'api/admin/products', {
      headers: this.createAuthorizationHeader(),
    });
  }

  getProductById(productId: number): Observable<any> {
    return this.http.get(BASIC_URL + `api/admin/product/${productId}`, {
      headers: this.createAuthorizationHeader(),
    });
  }

  getAllProductsByName(name: any): Observable<any> {
    return this.http.get(BASIC_URL + `api/admin/search/${name}`, {
      headers: this.createAuthorizationHeader(),
    });
  }

  deleteProduct(productId: any): Observable<any> {
    return this.http.delete(BASIC_URL + `api/admin/product/${productId}`, {
      headers: this.createAuthorizationHeader(),
    });
  }

  addCoupon(couponDto: any): Observable<any> {
    return this.http.post(BASIC_URL + 'api/admin/coupons', couponDto, {
      headers: this.createAuthorizationHeader(),
    });
  }

  getCoupons(): Observable<any> {
    return this.http.get(BASIC_URL + 'api/admin/coupons', {
      headers: this.createAuthorizationHeader(),
    });
  }

  getPlacedOrders(): Observable<any> {
    return this.http.get(BASIC_URL + 'api/admin/placedOrders', {
      headers: this.createAuthorizationHeader(),
    });
  }

  changeOrderStatus(orderId: number, status: string): Observable<any> {
    return this.http.get(BASIC_URL + `api/admin/order/${orderId}/${status}`, {
      headers: this.createAuthorizationHeader(),
    });
  }

  postFAQ(productId: number, faqDto: any): Observable<any> {
    return this.http.post(BASIC_URL + `api/admin/faq/${productId}`, faqDto, {
      headers: this.createAuthorizationHeader(),
    });
  }

  getAnalytics(): Observable<any> {
    return this.http.get(BASIC_URL + 'api/admin/order/analytics', {
      headers: this.createAuthorizationHeader(),
    });
  }

  getAllUsers(): Observable<any> {
    return this.http.get(BASIC_URL + 'api/admin/users', {
      headers: this.createAuthorizationHeader(),
    });
  }

  private createAuthorizationHeader(): HttpHeaders{
    // const token = UserStorageService.getToken();
    // console.log('Authorization token:', token);
    return new HttpHeaders().set(
      'Authorization', 'Bearer ' + UserStorageService.getToken()
    )
  }
}
