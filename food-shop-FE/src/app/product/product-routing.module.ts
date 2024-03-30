import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CartComponent} from './cart/cart.component';
import {ErrorComponent} from './error/error.component';
import {HistoryComponent} from './history/history.component';


const routes: Routes = [
  {path: 'cart', component: CartComponent},
  {path: 'error', component: ErrorComponent},
  {path: 'history', component: HistoryComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductRoutingModule {
}
