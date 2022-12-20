import {Component, OnInit} from '@angular/core';
import {IFood} from '../../model/i-food';
import {Title} from '@angular/platform-browser';
import {ActivatedRoute, Router} from '@angular/router';
import {FoodService} from '../../service/food.service';
import {CartDto} from '../../dto/cart-dto';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {
  food: IFood;

  constructor(private foodService: FoodService,
              private activatedRoute: ActivatedRoute,
              private title: Title,
              private router: Router) {
  }

  ngOnInit(): void {
    this.title.setTitle('Chi tiết sản phẩm');
    const id = Number(this.activatedRoute.snapshot.params.id);
    this.foodService.getFoodById(id).subscribe(value => {
      console.log(value);
      this.food = value;
    });
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
