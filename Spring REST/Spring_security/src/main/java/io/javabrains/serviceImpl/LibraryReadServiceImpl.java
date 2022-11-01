package io.javabrains.serviceImpl;

import java.util.List;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import io.javabrains.entity.Library;
import io.javabrains.repository.LibraryRepository;

@Service
public class LibraryReadServiceImpl {

	@Autowired
	private LibraryRepository readRepository;

	public List<Library> getAllLibraries() {
		return readRepository.findAll();
	}

	public List<Library> getAllLibrariesWithNoBooks() {

		Library libraryWithNoBooks = Library.builder().bookNames("").build();
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("bookName", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		org.springframework.data.domain.Example<Library> example = org.springframework.data.domain.Example
				.of(libraryWithNoBooks, exampleMatcher);

		return readRepository.findAll(example);
	}
}
