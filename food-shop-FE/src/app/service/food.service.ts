import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {SearchResult} from '../model/search-result';
import {IFood} from '../model/i-food';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FoodService {

  constructor(private httpClient: HttpClient) {
  }

  getFoodList(page: number, size: number, name: string): Observable<SearchResult<IFood>> {
    return this.httpClient.get<SearchResult<IFood>>
    (environment.api_url + '/list?name=' + name + '&page=' + (page - 1) + '&size=' + size);
  }

  findAllFood(name: string, size: number): Observable<SearchResult<IFood>> {
    const API_URL = environment.api_url + '/list?name=' + name + '&size=' + size;
    console.log(API_URL);
    return this.httpClient.get<SearchResult<IFood>>(API_URL);
  }

  getFoodById(id: number): Observable<IFood> {
    return this.httpClient.get<IFood>(environment.api_url + '/' + id);
  }

}
