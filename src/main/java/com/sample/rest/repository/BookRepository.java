package com.sample.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.rest.model.Book;

/**
 * The Interface BookRepository.
 */
public interface BookRepository extends JpaRepository<Book, Long> {

}
