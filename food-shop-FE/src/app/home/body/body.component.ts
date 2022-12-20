import {Component, OnInit} from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {IFood} from '../../model/i-food';
import {NavigationEnd, Router} from '@angular/router';
import {Title} from '@angular/platform-browser';
import {FoodService} from '../../service/food.service';
import {CartDto} from '../../dto/cart-dto';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css']
})
export class BodyComponent implements OnInit {

  pageSize = 8;
  foodList$: Observable<IFood[]> | undefined;
  total$: Observable<number>;
  action: boolean;
  nameSearch = '';
  numberRecord = 0;
  content: boolean;
  totalRecord = 0;

  constructor(private foodService: FoodService,
              private title: Title,
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
    this.pageSize += 4;
    this.paginate(this.nameSearch, this.pageSize);
  }

  resetSearchInput(): void {
    this.nameSearch = '';
  }

  addToCart(item: CartDto) {
    this.foodService.updateCart(item).subscribe(() => {
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Thêm vào giỏ hàng thành công',
        showConfirmButton: false,
        timer: 1500
      });
    });
  }
}
