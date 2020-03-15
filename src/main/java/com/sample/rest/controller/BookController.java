package com.sample.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.rest.model.Book;
import com.sample.rest.repository.BookRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class BookController.
 */
@RestController
public class BookController {

	/** The repository. */
	@Autowired
	private BookRepository repository;

	/**
	 * Gets the all books.
	 *
	 * @return the all books
	 */
	@GetMapping(path = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Book> getAllBooks() {
		List<Book> books = repository.findAll();
		System.out.println("Books : " + books);
		return books;
	}

	/**
	 * Gets the book by id.
	 *
	 * @param id the id
	 * @return the book by id
	 */
	@GetMapping(path = "/book/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book getBookById(@PathVariable("id") final long id) {
		Optional<Book> data = repository.findById(id);
		return data.get();
	}

	/*
	 * @GetMapping(path = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
	 * public List<Book> getBookByName(@RequestParam("bookName") final String
	 * bookName) { Optional<List<Book>> data = repository.findByBookName(bookName);
	 * return data.isPresent() ? data.get() : new ArrayList<Book>(); }
	 */

	/**
	 * Creates the book.
	 *
	 * @param book the book
	 * @return the book
	 */
	@PostMapping(path = "/book", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Book createBook(@RequestBody final Book book) {
		return repository.save(book);
	}

	/**
	 * Update book.
	 *
	 * @param id   the id
	 * @param book the book
	 * @return the book
	 */
	@PutMapping(path = "/book/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Book updateBook(@PathVariable("id") final long id, @RequestBody final Book book) {
		Optional<Book> existData = repository.findById(id);
		Book existingData = null;

		if (existData.isPresent()) {
			existingData = existData.get();
			existingData.setBookName(book.getBookName());
			existingData.setDescription(book.getDescription());
			existingData.setImageUrl(book.getImageUrl());
			existingData.setPrice(book.getPrice());
			existingData.setReleaseDate(book.getReleaseDate());
			existingData.setRating(book.getRating());
			existingData.setTags(book.getTags());
		}

		if (existingData != null)
			return repository.save(existingData);
		else
			return new Book();
	}

	/**
	 * Update book by payload.
	 *
	 * @param book the book
	 * @return the book
	 */
	@PutMapping(path = "/book", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Book updateBookByPayload(@RequestBody final Book book) {
		return repository.save(book);
	}

	/**
	 * Delete book.
	 *
	 * @param id the id
	 */
	@DeleteMapping(path = "/book/{id}")
	public void deleteBook(@PathVariable("id") final long id) {
		repository.deleteById(id);

		System.out.println("Provided book with the id has been deleted");
	}

	/**
	 * Delete book.
	 *
	 * @param book the book
	 */
	@DeleteMapping(path = "/book", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteBook(final Book book) {
		repository.delete(book);

		System.out.println("Provided Book has been deleted");
	}
}
