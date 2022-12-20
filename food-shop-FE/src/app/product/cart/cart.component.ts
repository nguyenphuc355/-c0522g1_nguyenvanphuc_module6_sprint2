import {Component, OnInit} from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {CartDto} from '../../dto/cart-dto';
import {FoodService} from '../../service/food.service';
import {Router} from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cartList$: Observable<CartDto[]> | undefined;
  totalBill: number;
  nameDelete: string;

  constructor(
    private foodService: FoodService,
    private router: Router) {
  }

  ngOnInit(): void {
    this.getAllInCart();
    this.getTotalBill();
  }

  getAllInCart() {
    this.foodService.getCartList().subscribe(value => {
      console.log(value);
      if (value === null) {
        this.router.navigateByUrl('');
      }
      this.cartList$ = new BehaviorSubject<CartDto[]>(value);
    });
  }

  getTotalBill() {
    this.foodService.getTotalBill().subscribe(value => {
      console.log(value.totalBill);
      this.totalBill = value.totalBill;
    });
  }

  updateQty(cart: CartDto) {
    console.log(cart);
    this.foodService.updateQty(cart).subscribe(value => {
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
            'Sản phẩm ' + this.nameDelete + 'đã bị xóa.',
            'success'
          );
          this.ngOnInit();
        });
      }
    });
  }
}



