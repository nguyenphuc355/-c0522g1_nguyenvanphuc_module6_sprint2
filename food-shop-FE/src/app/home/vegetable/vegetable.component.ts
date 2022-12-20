import {Component, OnInit} from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {IFood} from '../../model/i-food';
import {FoodService} from '../../service/food.service';
import {Title} from '@angular/platform-browser';
import {Router} from '@angular/router';
import {CartDto} from '../../dto/cart-dto';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-vegetable',
  templateUrl: './vegetable.component.html',
  styleUrls: ['./vegetable.component.css']
})
export class VegetableComponent implements OnInit {

  pageSize = 4;
  foodList$: Observable<IFood[]> | undefined;
  total$: Observable<number>;
  nameSearch = '';
  action: boolean;
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
  }

  paginate(nameSearch, pageSize) {
    this.foodService.getVegetable(nameSearch, pageSize).subscribe(data => {
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
