import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductRoutingModule } from './product-routing.module';
import { CartComponent } from './cart/cart.component';
import {FormsModule} from '@angular/forms';
import {ToastModule} from 'primeng-lts/toast';


@NgModule({
  declarations: [CartComponent],
    imports: [
        CommonModule,
        ProductRoutingModule,
        FormsModule,
        ToastModule
    ]
})
export class ProductModule { }
