package com.graphql.learn.controller;

import com.graphql.learn.entity.Book;
import com.graphql.learn.services.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    // create
    @MutationMapping("createBook")
    public Book create(@Argument BookInput book){
        Book b=new Book();
        b.setTitle(book.getTitle());
        b.setPrice(book.getPrice());
        b.setDesc(book.getDesc());
        b.setAuthor(book.getAuthor());
        b.setPages(book.getPages());
        return bookService.create(b);
    }

    // get all
    @QueryMapping("allBooks")
    public List<Book> getAll(){
        return bookService.getAll();
    }

    //get single book
    @QueryMapping("getBook")
    public Book getById(@Argument int bookId){
        return bookService.get(bookId);
    }
}

class BookInput{
    private  String title;
    private  String desc;
    private  String author;
    private  double price;
    private  int pages;

    public BookInput(){

    }

    public BookInput(String title, String desc, String author, double price, int pages) {
        this.title = title;
        this.desc = desc;
        this.author = author;
        this.price = price;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
