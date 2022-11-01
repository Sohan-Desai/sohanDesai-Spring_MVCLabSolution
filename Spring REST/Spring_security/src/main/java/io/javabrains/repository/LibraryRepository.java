package io.javabrains.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.javabrains.entity.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {

}
