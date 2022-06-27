import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Books } from './books';

@Injectable({
  providedIn: 'root'
})
export class BooksService {
// private baseURL = "http://localhost:8080/book";
baseUrl=environment.BACKEND_URL;

  constructor(private httpClient: HttpClient) { }

  getBookslist(): Observable<any>{
    const url=this.baseUrl+"book"
    return this.httpClient.get(url)
  }
  createBooks(book: Books): Observable<any>{
    const url=this.baseUrl+"book"
    return this.httpClient.post(url, book);
  }

  getBookById(bookid: number): Observable<any>{
    const url=this.baseUrl+"book/"+bookid;
    return this.httpClient.get<Books>(url);
  }
  
  updateBook(book: Books): Observable<any>{
    const url=this.baseUrl+"book"
    return this.httpClient.put(url,book);
  }

  deleteBookById(bookid: number): Observable<any>{
    const url=this.baseUrl+"book/"+bookid;
    return this.httpClient.delete(url);
  }
}
