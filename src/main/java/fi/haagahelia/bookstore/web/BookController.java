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
import fi.haagahelia.bookstore.repository.CategoryRepository;

@Controller
public class BookController {

    @Autowired 
    private BookRepository bookRepository;

    @Autowired 
    private CategoryRepository categoryRepository;

    @RequestMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        Book book = bookRepository.findById(bookId).get();
        model.addAttribute("book", book);        
        model.addAttribute("categories", categoryRepository.findAll());
        return "editbook";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        bookRepository.deleteById(bookId);
        return "redirect:../booklist";
    }
    
    @RequestMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
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
