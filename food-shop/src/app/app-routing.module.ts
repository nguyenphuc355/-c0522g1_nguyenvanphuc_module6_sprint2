import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeModule} from './home/home.module';
import {LoginModule} from './login/login.module';


const routes: Routes = [
  {path: '', loadChildren: () => HomeModule},
  {path: 'login', loadChildren: () => LoginModule}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
