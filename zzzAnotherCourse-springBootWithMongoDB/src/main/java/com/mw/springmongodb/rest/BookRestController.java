package com.mw.springmongodb.rest;


import com.mw.springmongodb.model.Book;
import com.mw.springmongodb.repository.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookRestController {

    @Autowired
    private BookDao bookDao;

    @GetMapping("/books")
    public List<Book> getBooks() {

        return bookDao.findAll();
    }

    @GetMapping("/books/{bookId}")
    public Optional<Book> getBookById(@PathVariable Integer bookId) {

        return bookDao.findById(bookId);
    }

    @PostMapping("/books")
    public void saveBook(@RequestBody Book book) {

        bookDao.insert(book);
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable Integer bookId) {

        bookDao.deleteById(bookId);
    }


}
