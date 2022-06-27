import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Books } from '../books';
import { BooksService } from '../books.service';

@Component({
  selector: 'app-view-books',
  templateUrl: './view-books.component.html',
  styleUrls: ['./view-books.component.css']
})
export class ViewBooksComponent implements OnInit {
  bookid: number;
  book: Books = new Books();
  constructor(private bookService: BooksService ,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.bookid = this.route.snapshot.params['bookid'];

    this.bookService.getBookById(this.bookid).subscribe(data => {
      console.log(data);
      this.book = data;
    }, (error:any) => console.log(error));
  }
  onSubmit(){
    this.bookService.getBookById(this.bookid).subscribe( data =>{
      console.log(data);
      this.goToBooksList();
      this.router.navigate(['books']) } //navigated to particular path
    , (error:any) => console.log(error));
  }

  goToBooksList(){
    this.router.navigate(['/book']);
  }


}
