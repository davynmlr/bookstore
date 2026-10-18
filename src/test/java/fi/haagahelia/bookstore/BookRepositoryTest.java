package fi.haagahelia.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import fi.haagahelia.bookstore.model.Book;
import fi.haagahelia.bookstore.model.Category;
import fi.haagahelia.bookstore.repository.BookRepository;
import fi.haagahelia.bookstore.repository.CategoryRepository;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Test
    public void createNewBook() {
        Category category = new Category("TestCategory");
        categoryRepository.save(category);
        Book book = new Book("TestTitle", "TestAuthor", 2024, "1234567890", 19.99);
        book.setCategory(category);
        repository.save(book);
    }

    @Test 
    public void findBookByTitle() {
        Category category = new Category("TestCategory");
        categoryRepository.save(category);
        Book book = new Book("Test Book", "Test Author", 2024, "000-000", 9.99);
        book.setCategory(category);
        repository.save(book);

        Book found = repository.findByTitle("Test Book");
        assertThat(found.getAuthor()).isEqualTo("Test Author");
    }

    @Test 
    public void deleteBook() {
        Category category = new Category("TestCategory");
        categoryRepository.save(category);
        Book book = new Book("Test Book", "Test Author", 2024, "000-000", 9.99);
        book.setCategory(category);
        repository.save(book);

        repository.delete(book);
        assertThat(repository.findByTitle("Test Book")).isNull();
    }


}