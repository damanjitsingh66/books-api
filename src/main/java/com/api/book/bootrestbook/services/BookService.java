package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {

    // fake service
    private static List<Book> list = new ArrayList<>();

    static {
        list.add(new Book(12, "java complete Reference", "XYZ"));
        list.add(new Book(36, "Head First to java", "ABC"));
        list.add(new Book(12963, "Think in java", "LMN"));

    }

    // get all books
    public List<Book> getAllBooks() {
        return list;
    }

    // get single book by id
    public Book getBookById(int id) {

        Book book = null;
        try {
            book = list.stream().filter(e -> e.getId() == id).findFirst().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    // adding the book
    public Book addBook(Book b) {
        list.add(b);
        return b;
    }

    // delete book
    public void deleteBook(int bid) {
        // filter is basically used for delete the book from the list
        list = list.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());
    }

    // update the book
    public void updateBook(Book book, int bookId) {
        list = list.stream().map(b -> {
            if (b.getId() == bookId) {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }

}
