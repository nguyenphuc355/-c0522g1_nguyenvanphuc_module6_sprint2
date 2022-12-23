import {Component, OnInit} from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {CartDto} from '../../dto/cart-dto';
import {FoodService} from '../../service/food.service';
import {Router} from '@angular/router';
import Swal from 'sweetalert2';
import {TokenStorageService} from '../../service/token-storage.service';
import {render} from 'creditcardpayments/creditCardPayments';
import {Title} from '@angular/platform-browser';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cartList$: Observable<CartDto[]> | undefined;
  totalBill: number;
  nameDelete: string;
  username: string;
  totalBillPayment: string;

  constructor(
    private foodService: FoodService,
    private router: Router,
    private tokenStorageService: TokenStorageService,
    private title: Title) {
    this.title.setTitle('Giỏ Hàng');
  }

  ngOnInit(): void {
    this.username = this.tokenStorageService.getUser().username;
    this.getAllInCart();
    this.getTotalBill();
  }


  getAllInCart() {
    this.foodService.getCartList(this.username).subscribe(value => {
      console.log(this.username);
      console.log(value);
      if (value === null) {
        this.router.navigateByUrl('/product/error');
      }
      this.cartList$ = new BehaviorSubject<CartDto[]>(value);
    });
  }

  getTotalBill() {
    this.foodService.getTotalBill(this.username).subscribe(value => {
      console.log(value.totalBill);
      this.totalBill = value.totalBill;
    });
  }

  updateQty(cart: CartDto) {
    console.log(cart);
    if (cart.quantity < 1) {
      this.removeProduct(cart);
    }
    this.foodService.updateQty(cart, this.username).subscribe(value => {
      this.getAllInCart();
      this.getTotalBill();
      this.ngOnInit();
    });
  }

  removeProduct(product: CartDto) {
    this.nameDelete = product.name;
    Swal.fire({
      title: 'Bạn chắc chắn muốn xóa sản phẩm?',
      text: this.nameDelete,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Có, xóa',
      cancelButtonText: 'Không'
    }).then((result) => {
      if (result.isConfirmed) {
        this.foodService.removeProduct(product.id).subscribe(value => {
          Swal.fire(
            'Đã xóa!',
            'Sản phẩm ' + this.nameDelete + ' đã bị xóa.',
            'success'
          );
          this.ngOnInit();
        });
      }
    });
  }

  payment(): void {
    this.foodService.payment(this.username).subscribe(value => {
      console.log(this.username);
      Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'Thanh toán thành công !',
        showConfirmButton: false,
        timer: 1000
      }).then(r => window.location.replace('/product/error'));
    });
  }

  sendInfoPayment(totalBill: number) {
    this.totalBillPayment = (totalBill / 23000).toFixed(2).toString();
    render(
      {
        id: '#myPaypal',
        value: '1000',
        currency: 'USD',
        onApprove: (details) => {
          this.payment();
        }
      }
    );
  }

  reload() {
    window.location.reload();
  }
}



