import { Component, OnInit } from '@angular/core';
import {Books} from '../books';
import { BooksService } from '../books.service'
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-books',
  templateUrl: './list-books.component.html',
  styleUrls: ['./list-books.component.css']
})
export class ListBooksComponent implements OnInit {
  books:any;
  constructor(private booksService: BooksService,
    private router: Router) {}

  ngOnInit(): void {
    
    this.getBooks();

  }

    getBooks(){
    this.booksService.getBookslist().subscribe(data => {
    console.log(data);
      this.books = data;
    });
  }

  updateBooks(bookid: number){
    this.router.navigate(['update-books', bookid]);
    //alert(bookid)
  }
  viewBookById(bookid: number){
    this.booksService.getBookById(bookid).subscribe(data => {
      console.log(data);
      });
  
    this.router.navigate(['view-books', bookid]);
    //alert(bookid)
  }

  deleteBooks(bookid: number){
    this.booksService.deleteBookById(bookid).subscribe( data => {
      console.log(data);
     this.getBooks();
    // alert(bookid)
    });
  }
  }



