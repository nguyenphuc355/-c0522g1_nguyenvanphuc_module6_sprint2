import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {SearchResult} from '../model/search-result';
import {IFood} from '../model/i-food';
import {environment} from '../../environments/environment';
import {CartDto} from '../dto/cart-dto';

@Injectable({
  providedIn: 'root'
})
export class FoodService {

  constructor(private httpClient: HttpClient) {
  }

  findAllFood(name: string, size: number): Observable<SearchResult<IFood>> {
    const API_URL = environment.api_url + '/list?name=' + name + '&size=' + size;
    console.log(API_URL);
    return this.httpClient.get<SearchResult<IFood>>(API_URL);
  }

  getVegetable(name: string, size: number): Observable<SearchResult<IFood>> {
    const API_URL = environment.api_url + '/vegetable?name=' + name + '&size=' + size;
    console.log(API_URL);
    return this.httpClient.get<SearchResult<IFood>>(API_URL);
  }

  getAllMeat(name: string, size: number): Observable<SearchResult<IFood>> {
    const API_URL = environment.api_url + '/meat?name=' + name + '&size=' + size;
    console.log(API_URL);
    return this.httpClient.get<SearchResult<IFood>>(API_URL);
  }

  getAllFruit(name: string, size: number): Observable<SearchResult<IFood>> {
    const API_URL = environment.api_url + '/fruit?name=' + name + '&size=' + size;
    console.log(API_URL);
    return this.httpClient.get<SearchResult<IFood>>(API_URL);
  }

  getOther(name: string, size: number): Observable<SearchResult<IFood>> {
    const API_URL = environment.api_url + '/other?name=' + name + '&size=' + size;
    console.log(API_URL);
    return this.httpClient.get<SearchResult<IFood>>(API_URL);
  }


  getFoodById(id: number): Observable<IFood> {
    return this.httpClient.get<IFood>(environment.api_url + '/' + id);
  }


  getCartList(username: string): Observable<CartDto[]> {
    return this.httpClient.get<CartDto[]>(environment.api_url + '/cart' + '?username=' + username);
  }

  getTotalBill(username: string): Observable<CartDto> {
    return this.httpClient.get<CartDto>(environment.api_url + '/total-bill' + '?username=' + username);
  }

  updateCart(cartDto: CartDto, username: string): Observable<void> {
    return this.httpClient.post<void>(environment.api_url + '/cart-update' + '?id=' + cartDto.id + '&username=' + username, cartDto);
  }

  updateQty(cartDto: CartDto, username: string): Observable<void> {
    return this.httpClient.patch<void>(environment.api_url + '/qty-update' + '?id=' + cartDto.id +
      '&qty=' + cartDto.quantity + '&username=' + username, cartDto);
  }

  removeProduct(id: number | undefined): Observable<any> {
    return this.httpClient.delete<any>(environment.api_url + '/del-product' + '?id=' + id);
  }

  payment(username: string): Observable<void> {
    return this.httpClient.get<void>(environment.api_url + '/payment/' + username);
  }

  history(username: string): Observable<CartDto[]> {
    return this.httpClient.get<CartDto[]>(environment.api_url + '/history/' + username);
  }
}
