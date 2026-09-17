package fi.haagahelia.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookstore.model.Book;
import fi.haagahelia.bookstore.model.Category;
import fi.haagahelia.bookstore.repository.BookRepository;
import fi.haagahelia.bookstore.repository.CategoryRepository;


@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}



	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository categoryRepository) {
		return (args) -> {

			//CATEGORIES
			Category fiction = new Category("Fiction");
			categoryRepository.save(fiction);
			Category nonFiction = new Category("Non-Fiction");
			categoryRepository.save(nonFiction);
			Category thriller = new Category("Thriller");
			categoryRepository.save(thriller);


			//BOOKS
			Book animalFarm = new Book("Animal Farm", "George Orwell", 1945, "123-456", 12.99);
			animalFarm.setCategory(nonFiction);
		    repository.save(animalFarm);

			Book harryPotterPhilosophersStone = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997, "987-654", 19.99);
			harryPotterPhilosophersStone.setCategory(fiction);
			repository.save(harryPotterPhilosophersStone);

			Book leParfum = new Book("Le Parfum", "Patrick Süskind", 1985, "456-789", 14.99);
			leParfum.setCategory(fiction);
			repository.save(leParfum);

			Book viperAuPoing = new Book("Viper au poing", "Jean-Christophe Grangé", 2002, "321-654", 17.99);
			viperAuPoing.setCategory(thriller);
			repository.save(viperAuPoing);

			Book frankenstein = new Book("Frankenstein", "Mary Shelley", 1818, "654-321", 9.99);
			frankenstein.setCategory(fiction);
			repository.save(frankenstein);


		};
	}

}
