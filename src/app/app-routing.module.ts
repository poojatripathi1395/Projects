import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListBooksComponent } from './list-books/list-books.component';
import { CreateBooksComponent } from './create-books/create-books.component';
import { UpdateBooksComponent } from './update-books/update-books.component';
import { ViewBooksComponent } from './view-books/view-books.component';

const routes: Routes = [
  {path: 'books', component: ListBooksComponent},
  {path: 'create-books', component: CreateBooksComponent},
  {path: '', redirectTo: 'books', pathMatch: 'full'},
  {path: 'update-books/:bookid', component: UpdateBooksComponent},
  {path: 'view-books/:bookid', component: ViewBooksComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],                                                                                                                                                                                                                                                                                                          
  exports: [RouterModule]
})
export class AppRoutingModule { }
