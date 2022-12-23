import {Component, OnInit} from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {IFood} from '../../model/i-food';
import {NavigationEnd, Router} from '@angular/router';
import {Title} from '@angular/platform-browser';
import {FoodService} from '../../service/food.service';
import {CartDto} from '../../dto/cart-dto';
import Swal from 'sweetalert2';
import {TokenStorageService} from '../../service/token-storage.service';

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css']
})
export class BodyComponent implements OnInit {

  pageSize = 6;
  foodList$: Observable<IFood[]> | undefined;
  total$: Observable<number>;
  action: boolean;
  nameSearch = '';
  numberRecord = 0;
  content: boolean;
  totalRecord = 0;
  username: string;

  constructor(private foodService: FoodService,
              private title: Title,
              private tokenService: TokenStorageService,
              private router: Router) {
    this.title.setTitle('Trang chủ');
  }

  ngOnInit(): void {
    this.paginate(this.nameSearch, this.pageSize);
    this.router.events.subscribe((event) => {
      if (!(event instanceof NavigationEnd)) {
        return;
      }
      window.scrollTo(0, 0);
    });
    this.getCustomer();
  }

  paginate(nameSearch, pageSize) {
    this.foodService.findAllFood(nameSearch, pageSize).subscribe(data => {
      console.log(data);
      if (data != null) {
        this.action = true;
        this.foodList$ = new BehaviorSubject<IFood[]>(data.content);
        this.total$ = new BehaviorSubject<number>(data.totalElements);
      } else {
        this.action = false;
      }
    });
  }

  nextPage() {
    this.pageSize += 3;
    this.paginate(this.nameSearch, this.pageSize);
  }

  resetSearchInput(): void {
    this.nameSearch = '';
  }

  getCustomer(): void {
    this.username = this.tokenService.getUser().username;
  }

  addToCart(item: CartDto) {
    if (this.username == null) {
      Swal.fire({
        position: 'center',
        icon: 'warning',
        title: 'Bạn chưa đăng nhập, vui lòng đăng nhập trước !',
        showConfirmButton: false,
        timer: 2000
      });
      this.router.navigateByUrl('/login');
    } else {
      this.foodService.updateCart(item, this.username).subscribe(() => {
        const Toast = Swal.mixin({
          toast: true,
          position: 'top-end',
          timer: 3000,
          timerProgressBar: true
        });
        Toast.fire('Thêm Vào Giỏ Hàng Thành Công', '', 'success');
      });
    }
  }
}
