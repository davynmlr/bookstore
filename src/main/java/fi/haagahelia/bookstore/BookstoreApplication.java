package fi.haagahelia.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookstore.model.Book;
import fi.haagahelia.bookstore.repository.BookRepository;


@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(BookRepository repository){
		return (args) -> {
		//save a couple of books
		    repository.save(new Book("Animal Farm", "George Orwell", 1945, "123-456", 12.99));
			repository.save(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997, "987-654", 19.99));
			repository.save(new Book("Le Parfum", "Patrick Süskind", 1985, "456-789", 14.99));
			repository.save(new Book("Viper au poing", "Jean-Christophe Grangé", 2002, "321-654", 17.99));
			repository.save(new Book("Frankenstein", "Mary Shelley", 1818, "654-321", 9.99));
	};
	}

}
