package fi.haagahelia.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fi.haagahelia.bookstore.repository.BookRepository;
import fi.haagahelia.bookstore.model.Book;

@Controller
public class BookController {

    @Autowired 
    private BookRepository bookRepository;

    @RequestMapping(value = "/delete/{id}")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        bookRepository.deleteById(bookId);
        return "redirect:../booklist";
    }
    
    @RequestMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @PostMapping("/save")
    public String saveBook(Book book) {
        bookRepository.save(book);
        return "redirect:booklist";
    }

    @RequestMapping("/booklist")
    public String listBooks(Model model) {
        List<Book> books = (List<Book>) bookRepository.findAll();
        System.out.println(books);
        model.addAttribute("books", books);
        return "booklist";
    }
}
