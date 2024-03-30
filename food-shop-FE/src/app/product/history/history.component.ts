import {Component, OnInit} from '@angular/core';
import {CartDto} from '../../dto/cart-dto';
import {Title} from '@angular/platform-browser';
import {Router} from '@angular/router';
import {TokenStorageService} from '../../service/token-storage.service';
import {FoodService} from '../../service/food.service';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  cartHistory: CartDto[];
  username: string;

  constructor(
    private foodService: FoodService,
    private tokenService: TokenStorageService,
    private router: Router,
    private title: Title) {
    this.title.setTitle('Lịch sử mua hàng');
  }

  ngOnInit(): void {
    this.getUsername();
    this.getHistory();
  }

  getHistory(): void {
    this.foodService.history(this.username).subscribe(value => {
      this.cartHistory = value;
      console.log(this.cartHistory);
    });
  }

  getUsername(): void {
    this.username = this.tokenService.getUser().username;
  }

}
