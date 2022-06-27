import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { Books } from '../books';
import { BooksService } from '../books.service';

@Component({
  selector: 'app-update-books',
  templateUrl: './update-books.component.html',
  styleUrls: ['./update-books.component.css']
})
export class UpdateBooksComponent implements OnInit {

  bookid: number;
  book: Books = new Books();
  constructor(private bookService: BooksService,
    private _snackBar: MatSnackBar,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.bookid = this.route.snapshot.params['bookid'];

    this.bookService.getBookById(this.bookid).subscribe(data => {
      this.book = data;
    }, (error:any) => console.log(error));
  }
  onSubmit(){
    this.bookService.updateBook(this.book).subscribe( (data) =>{
        this._snackBar.open("BooK Updated Successfully", "OK", {
          duration: 3000,
          horizontalPosition:'center' ,
           verticalPosition: 'top',
          panelClass: ['green-snackbar'],
         });
        
      this.goToBooksList();
      this.router.navigate(['books'])  //navigated to particular path
    }
    , (error:any) => console.log(error));
  }

  goToBooksList(){
    this.router.navigate(['/book']);
  }


}
