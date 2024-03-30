import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {HomeRoutingModule} from './home-routing.module';
import {HeaderComponent} from './header/header.component';
import {BodyComponent} from './body/body.component';
import {FooterComponent} from './footer/footer.component';
import {ProductDetailComponent} from './product-detail/product-detail.component';
import {FormsModule} from '@angular/forms';
import {VegetableComponent} from './vegetable/vegetable.component';
import {MeatComponent} from './meat/meat.component';
import {FruitComponent} from './fruit/fruit.component';
import {OtherComponent} from './other/other.component';


@NgModule({
  declarations: [HeaderComponent,
    BodyComponent,
    FooterComponent,
    ProductDetailComponent,
    VegetableComponent,
    MeatComponent,
    FruitComponent,
    OtherComponent],
  exports: [
    HeaderComponent,
    FooterComponent,
    VegetableComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    FormsModule
  ]
})
export class HomeModule {
}
