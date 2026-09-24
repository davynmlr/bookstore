package fi.haagahelia.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import fi.haagahelia.bookstore.repository.BookRepository;
import fi.haagahelia.bookstore.model.Book;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class BookRestController {

    @Autowired
    private BookRepository bookRepository;

    //No need of ResponseBody annotation, because of @RestController

    @RequestMapping("/books")
    public List<Book> bookListRest() {
        return (List<Book>) bookRepository.findAll();
    }

    @RequestMapping(value="/books/{id}", method=RequestMethod.GET)
    public Book findBookRest(@PathVariable("id") Long bookId) {    
        return bookRepository.findById(bookId).get();
    }
    
}