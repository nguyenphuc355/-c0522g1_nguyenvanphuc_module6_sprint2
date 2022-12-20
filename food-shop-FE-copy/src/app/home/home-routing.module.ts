import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {BodyComponent} from './body/body.component';
import {ProductDetailComponent} from './product-detail/product-detail.component';
import {VegetableComponent} from './vegetable/vegetable.component';
import {MeatComponent} from './meat/meat.component';
import {FruitComponent} from './fruit/fruit.component';
import {OtherComponent} from './other/other.component';


const routes: Routes = [
  {
    path: '', component: BodyComponent
  },
  {path: 'detail/:id', component: ProductDetailComponent},
  {path: 'vegetable', component: VegetableComponent},
  {path: 'meat', component: MeatComponent},
  {path: 'fruit', component: FruitComponent},
  {path: 'other', component: OtherComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule {
}
