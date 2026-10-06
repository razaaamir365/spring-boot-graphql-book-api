package com.graphql.learn.services.impl;

import com.graphql.learn.entity.Book;
import com.graphql.learn.repositories.BookRep;
import com.graphql.learn.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {

    private BookRep bookRep;

    @Autowired
    BookServiceImpl(BookRep bookRep){
        this.bookRep = bookRep;
    }

    @Override
    public Book create(Book book) {
        return bookRep.save(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRep.findAll();
    }


    @Override
    public Book get(int bookId) {
        return bookRep.findById(bookId).orElseThrow(()->new RuntimeException("Book are not fount !! "));

    }
}
