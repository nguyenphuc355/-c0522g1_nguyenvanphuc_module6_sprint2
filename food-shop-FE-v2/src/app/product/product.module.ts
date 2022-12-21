import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductRoutingModule } from './product-routing.module';
import { CartComponent } from './cart/cart.component';
import {FormsModule} from '@angular/forms';
import { ErrorComponent } from './error/error.component';
import { HistoryComponent } from './history/history.component';


@NgModule({
  declarations: [CartComponent, ErrorComponent, HistoryComponent],
    imports: [
        CommonModule,
        ProductRoutingModule,
        FormsModule,
    ]
})
export class ProductModule { }
