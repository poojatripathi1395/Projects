import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Books } from '../books';
import { BooksService } from '../books.service';

@Component({
  selector: 'app-create-books',
  templateUrl: './create-books.component.html',
  styleUrls: ['./create-books.component.css']
})
export class CreateBooksComponent implements OnInit {
  book:Books = new Books();

  constructor(private bookService:BooksService,
    private _snackBar: MatSnackBar,
   private  router:Router) { }

  ngOnInit(): void {
  }
  saveBook(){
    this.bookService.createBooks(this.book).subscribe( data =>{
      console.log(data);
      this.goToBooksList();
    },
      (    error: any) => console.log(error));
  }

  goToBooksList(){
    this.router.navigate(['/book']);
  }

  onSubmit(){this.bookService.createBooks(this.book).subscribe( (data) =>{
    this._snackBar.open("BooK created Successfully", "OK", {
      duration: 3000,
      horizontalPosition:'center' ,
       verticalPosition: 'top',
      panelClass: ['green-snackbar'],
     });
     console.log(data);
     this.router.navigate(['books'])  //navigated to particular path
    }
    , (error:any) => console.log(error));

    console.log(this.book);
    this.saveBook();
  }

}
